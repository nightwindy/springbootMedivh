package com.windy.medivh.core.ao.impl;

import com.windy.medivh.core.ao.XhtmlService;
import org.springframework.stereotype.Service;
import org.w3c.tidy.Tidy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class XhtmlServiceImpl implements XhtmlService {

    private final String charset = "UTF-8";

    private final Tidy tidy;

    public XhtmlServiceImpl() {
        tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setInputEncoding(charset);
        tidy.setOutputEncoding(charset);
    }

    @Override
    public String toXhtml(String content) throws IOException {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes(charset));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            tidy.parse(inputStream, outputStream);
            return outputStream.toString(charset);
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }
}
