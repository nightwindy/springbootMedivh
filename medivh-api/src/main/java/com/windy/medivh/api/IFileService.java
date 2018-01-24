package com.windy.medivh.api;


import com.windy.medivh.common.entity.BizResult;
import com.windy.medivh.request.DownloadFile;
import com.windy.medivh.request.ImagePathExtCommand;
import com.windy.medivh.dto.ExtFileRequest;

import java.util.List;
import java.util.Map;


public interface IFileService {

    /**
     * 上传七牛
     *
     * @param fileName
     * @param content
     * @param open     true:上传公有空间; false:上传私有空间
     * @return
     */
    BizResult<Map<String, Object>> upLoad(String fileName, byte[] content, Boolean open);

    /**
     * 一键下载（包含验车照片、手续照片、入库单、合同）和其他（根据FileId的文件）
     * @param productId 订单ID
     * @param contractIds 合同ID
     * @param files 文件
     * @return
     */
    BizResult<byte[]> download(String productId, List<Long> contractIds, List<DownloadFile> files);

    /**
     * 一键下载（包含验车照片、手续照片、入库单、合同）
     * @param productNo
     * @param contractIds
     * @return
     */
    BizResult<byte[]> download(String productNo, List<Long> contractIds);

    /**
     * 一键下载然后发送给到邮箱中（包含验车照片、手续照片、入库单、合同）
     * @param productNo
     * @param contractIds
     * @param email
     * @return
     */
    BizResult<String> downloadByResume(String productNo, List<Long> contractIds, String email);

    /**
     * 一键下载然后发送给到邮箱中（包含验车照片、手续照片、入库单、合同 运单 采购合同 保证金 定金打款凭证 尾款凭证）
     * @param productNo
     * @param contractIds
     * @param email
     * @return
     */
    BizResult<String> orderDownloadByResume(String productNo, List<Long> contractIds, List<String> statementsIds, String email);
    /**
     * 一键下载（包含合同、其他上传的文件）
     * @param fileName
     * @param contractIds
     * @param fileIds
     * @return
     */
    BizResult<byte[]> downloadFiles(String fileName, List<Long> contractIds, List<Long> fileIds);

    /**
     * 根据FileID 返回可以访问的地址
     *
     * @param fileId
     * @return
     */
    BizResult<String> findPathByFileId(Long fileId);

    /**
     * 根据FileID 返回可以访问的地址
     *
     * @return
     */
    BizResult<ExtFileRequest> findExtImagePath(ImagePathExtCommand command);

    /**
     * 根据FileID 返回可以访问的地址
     *
     * @param fileIds
     * @return
     */
    BizResult<List<String>> findPathsByFileIds(List<Long> fileIds);

    /**
     * 获取七牛文件上传的token
     * @param isOpen 是否开放
     */
    BizResult<String> getQiniuUploadToken(boolean isOpen);
}
