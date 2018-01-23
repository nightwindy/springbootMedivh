package com.windy.medivh.common.util;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by alex on 16/10/11.
 */
public class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    private static ConnectionKeepAliveStrategy collectionStrategy = new ConnectionKeepAliveStrategy() {
        public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
            // 解析http响应中的Keep-Alive头消息
            HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                HeaderElement header = it.nextElement();
                String param = header.getName();
                String value = header.getValue();
                // 如果制定了超时时间，则连接的存活时间为timeout的值
                if (value != null && param.equalsIgnoreCase("timeout")) {
                    try {
                        return Long.parseLong(value) * 1000;
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("Value format error.", e);
                    }
                }
            }
            // 否则默认存活30秒
            return 30 * 1000;
        }
    };

    private static HttpClient createClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager();
        clientConnectionManager.setMaxTotal(2);
        clientConnectionManager.setDefaultMaxPerRoute(20);

        return HttpClientBuilder.create().setConnectionManager(clientConnectionManager).build();
    }

    public static HttpEntity get(String url) {

        try {
            HttpGet httpGet = new HttpGet(url);
            HttpClient client = createClient();

            RequestConfig requestConfig = RequestConfig.custom().
                    setSocketTimeout(2000).setConnectTimeout(2000).build();
            httpGet.setConfig(requestConfig);

            HttpResponse response = client.execute(httpGet);

            if (response.getStatusLine().getStatusCode() != 200) {

                LOGGER.error("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);

                throw new Error("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);
            }

            return response.getEntity();

        } catch (Exception ex) {
            throw new Error(ex);
        }

    }

    public static HttpEntity post(String url, Map<String, String> header) {

        try {
            HttpPost httpPost = new HttpPost(url);
            HttpClient client = createClient();

            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
//
//            RequestConfig requestConfig = RequestConfig.custom().
//                    setSocketTimeout(2000).setConnectTimeout(2000).build();
//            httpPost.setConfig(requestConfig);

            HttpResponse response = client.execute(httpPost);

            if (response.getStatusLine().getStatusCode() != 200) {

                LOGGER.error("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);

                throw new Error("request url failed, http code=" + response.getStatusLine().getStatusCode()
                        + ", url=" + url);
            }

            return response.getEntity();

        } catch (Exception ex) {
            throw new Error(ex);
        }

    }
}
