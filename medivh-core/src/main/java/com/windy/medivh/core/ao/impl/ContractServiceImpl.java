package com.windy.medivh.core.ao.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.windy.medivh.common.util.SnowFlake;
import com.windy.medivh.core.ao.ContractService;
import com.windy.medivh.core.itext.AsianFontProvider;
import com.windy.medivh.core.model.AddContractCommand;
import com.windy.medivh.core.model.AlterContractCommand;
import com.windy.medivh.core.model.Contract;
import com.windy.medivh.core.officer.ContractOfficer;
import com.windy.medivh.dal.manager.FpContractManager;
import com.windy.medivh.dal.model.FpContractDO;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@Service
public class ContractServiceImpl implements ContractService {

    private final VelocityEngine engine;

    @Autowired
    private FpContractManager manager;

    @Autowired
    private SnowFlake snowFlake;

    @Autowired
    private ContractOfficer contractOfficer;

    public ContractServiceImpl() throws IOException {
        this.engine = new VelocityEngine();
        Properties properties = new Properties();
        properties.load(ContractServiceImpl.class.getResourceAsStream("/velocity.properties"));
        engine.init(properties);
    }

    @Override
    public String createHtml(String templatePath, Map<String, Object> params) {
        Template template = engine.getTemplate(templatePath);

        VelocityContext root = new VelocityContext();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            root.put(entry.getKey(), entry.getValue());
        }

        StringWriter stringWriter = new StringWriter();
        template.merge(root, stringWriter);
        stringWriter.flush();

        return stringWriter.getBuffer().toString();
    }


    @Override
    public File createPDF(String xhtml) throws IOException, DocumentException {
        File contract = new File(String.format("%s.pdf", UUID.randomUUID().toString()));
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(contract));

        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(xhtml.getBytes("UTF-8")), Charset.forName("UTF-8"), new AsianFontProvider());
        document.close();

        return contract;
    }

    @Override
    @Transactional
    public Long add(AddContractCommand command) throws Exception {
        Assert.notNull(command);
        Contract contract = new Contract(snowFlake.nextId(), command.getContractTemplateId(), command.getPdfFileId(), command.getHtmlFileId());
        FpContractDO fpContractDO=new FpContractDO();
        fpContractDO.setContractId(snowFlake.nextId());
        fpContractDO.setContractTemplateId(command.getContractTemplateId());
        fpContractDO.setPdfFileId(command.getPdfFileId());
        fpContractDO.setHtmlFileId(command.getHtmlFileId());
         manager.insertSelective(fpContractDO);
        return contract.getId();
    }

    @Override
    public FpContractDO findBy(Long contractId) {
        if (contractId == null) {
            return null;
        }
        FpContractDO contract = manager.selectByPrimaryKey(contractId);
        return contract;
    }

    @Override
    public void alter(AlterContractCommand command) {
       /* Assert.notNull(command);

        Contract preContract = findBy(command.getId());

        Assert.notNull(preContract);

        Contract contract = new Contract(command.getId(), command.getContractTemplateID(), command.getPdfFileId(), preContract.getHtmlFileId());

        manager.alter(contract);*/
    }

}
