package com.windy.medivh.core.officer;

import com.windy.medivh.core.ao.ContractTemplateService;
import com.windy.medivh.core.ao.PaperService;
import com.windy.medivh.core.model.AddContractTemplateCommand;
import com.windy.medivh.core.model.AddPaperCommand;
import com.windy.medivh.core.model.AlterContractTemplateCommand;
import com.windy.medivh.core.model.ContractTemplate;
import com.windy.medivh.core.service.UploadService;
import com.windy.medivh.dal.model.FpContractTemplateDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 17/3/4.
 */
@Service
public class ContractTemplateOfficer {

    @Resource(name = "openUpload")
    private UploadService openUploadService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private ContractTemplateService contractTemplateService;

    @Transactional(rollbackFor = Throwable.class)
    public void add(AddContractTemplateCommand command) throws Exception {
        Assert.notNull(command);
        contractTemplateService.add(new AddContractTemplateCommand(command.getName(), command.getFileId(), command.getSignKind()));
    }

   /* public void remove(RemoveContractTemplateCommand command) {
        Assert.notNull(command);

        ContractTemplate template = contractTemplateService.findBy(command.getTemplateID());
        Assert.notNull(template);

        paperService.remove(template.getFileId());
        contractTemplateService.remove(template.getId());
    }*/

    @Transactional(rollbackFor = Throwable.class)
    public void alter(AlterContractTemplateCommand command) throws Exception {
        Assert.notNull(command);

        FpContractTemplateDO template = contractTemplateService.findBy(command.getId());

        if (uploadNewFile(command.getFileId(), template))
            paperService.remove(template.getFileId());

        contractTemplateService.alter(new AlterContractTemplateCommand(command.getId(), command.getName(), command.getFileId(), command.getSignKind(), template.getVersion()));
    }

    private Boolean uploadNewFile(Long newFileId, FpContractTemplateDO template) {
        return !newFileId.equals(template.getFileId());
    }

    public Map<String, Object> upload(String fileName, byte[] contents) throws Exception {
        String content = new String(contents, "UTF-8");

        String path = openUploadService.upload(fileName, (content.getBytes("UTF-8")));//返回全路径
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String mime = fileNameMap.getContentTypeFor(fileName);
        Long fileId = paperService.add(new AddPaperCommand(path, contents, mime, Boolean.TRUE));

        Map<String, Object> map = new HashMap<>();
        map.put("fileId", fileId);
        map.put("path", path);
        return map;
    }

}
