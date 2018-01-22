package com.windy.medivh.dal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FpMaterialFileDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * fp_material_file.file_id
     */
    private Long fileId;

    /**
     * 存放在CDN的文件路径
     * fp_material_file.path
     */
    private String path;

    /**
     * 资料文件内容
     * fp_material_file.content
     */
    private byte[] content;

    /**
     * 文件类型
     * fp_material_file.mime
     */
    private String mime;

    /**
     * 是否公开访问权限 ,0 false，1 true，默认0
     * fp_material_file.open
     */
    private Integer open;

    /**
     * 1可用0不可用
     * fp_material_file.status
     */
    private Integer status;

    /**
     * 创建时间
     * fp_material_file.gmt_create
     */
    private Date gmtCreate;

    /**
     * 修改时间
     * fp_material_file.gmt_modified
     */
    private Date gmtModified;
    public FpMaterialFileDO() {

    }
    public FpMaterialFileDO(Long id, String path, byte[] content, String mime, Integer open) {
        this.fileId = id;
        this.path = path;
        this.content = content;
        this.mime = mime;
        this.open = open;
    }

}