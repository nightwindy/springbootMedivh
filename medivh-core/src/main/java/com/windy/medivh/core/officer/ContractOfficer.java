package com.windy.medivh.core.officer;

import com.alibaba.dubbo.common.json.ParseException;
import com.itextpdf.text.DocumentException;
import com.windy.medivh.core.ao.ContractService;
import com.windy.medivh.core.ao.ContractTemplateService;
import com.windy.medivh.core.ao.PaperService;
import com.windy.medivh.core.ao.XhtmlService;
import com.windy.medivh.core.bo.ContractTemplate;
import com.windy.medivh.core.model.AddContractCommand;
import com.windy.medivh.core.model.AddPaperCommand;
import com.windy.medivh.core.model.Paper;
import com.windy.medivh.core.service.UploadService;
import com.windy.medivh.dal.model.FpContractDO;
import com.windy.medivh.dal.model.FpContractTemplateDO;
import com.windy.medivh.dal.model.FpMaterialFileDO;
import com.windy.medivh.request.CreateContractCommand;
import com.windy.medivh.request.PreviewContractCommand;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Map;
import java.util.UUID;

@Service
public class ContractOfficer {

    private static final String FILE_NAME = "contract.pdf";

    @Autowired
    private XhtmlService xhtmlService;

    @Resource(name = "personUpload")
    private UploadService personUploadService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private ContractTemplateService contractTemplateService;

    /*@Autowired
    private ContractKeyWordConfigService contractKeyWordConfigService;

    @Autowired
    private SignService signHistoryService;


    @Autowired
    private AccessPathService accessPathService;*/


    public void test(Long id) throws ParseException {
        String param = "{\"warehouseAddress\":\"\",\"amountInWords\":\"贰拾玖万贰仟捌佰元整\",\"investorCardNo\":\"郭籽涵\",\"amountSub\":\"234,240\",\"pro\n" +
        "viderCardNos\":[{\"payAmount\":\"292,800\",\"bankBranch\":\"舟山市分行\",\"accountName\":\"舟山中兴汽车销售服务有限公司\",\"bankCardStatus\":2,\"bankName\":\"中国建设银行\",\"bankCarNo\":\"33001706260053007921\"}],\"wareHouseFullAddress\":\"\",\"amountSubToWard\":\"贰拾叁万肆仟贰佰肆拾元整\",\"investorAccountName\":\"\",\"dealerAccountName\":\"\",\"hasPayAmount\":\"58,560\",\"providerPersonal\":\"\",\"amoun\n" +
        "tSubInterestAfterSixty\":\"234.24\",\"marginRate\":\"20.00%\",\"dealerSocialCreditCode\":\"\",\"amountSubInterest\":\"93.69\",\"rate\":\"80.00%\",\"marginAmount\":\"58,560\",\"dealerBank\":\"\",\"today\":\"2017年10月17日\",\"dealerContacter\":\"郭籽涵\",\"invoiceType\":5,\"minimumInterestDays\":\"\",\"despositSuperCase\":\"零元整\",\"supervisionDesc\":\"\",\"dealerLegalPerson\":\"丁峥\",\"providerName\":\"湖南王杰\n" +
        "名车汽车销售有限公司\",\"interestRate\":\"\",\"serviceDesc\":\"\",\"amount\":\"292,800\",\"dealerName\":\"上海臻悦汽车销售服务有限公司\",\"orderNo\":\"G20171017213441\",\"dealerAddress\":\"上海市浦东新区康桥路787号3号楼1245室\",\"dealerCardNo\":\"\",\"shippings\":[{\"amount\":\"3,103\",\"companyName\":\"中汽远通货物运输（北京）有限公司\",\"toCity\":\"广东省深圳市罗湖区\",\"driverName\":\"范电波\",\"beginTime\":\"\",\"fromCity\":\"舟山市\"}],\"marginTime\":\"2017年10月17日\",\"providerCardNo\":[{\"payAmount\":\"292,800\",\"bankBranch\":\"舟山市分行\",\"accountName\":\"舟山中兴汽车销售服务有限公司舟山中兴汽车销售服务有限公司舟山中兴汽车销售服务有限公司\",\"bankCardStatus\":2,\"bankName\":\"中国建设银行\",\"bankCarNo\":\"33001706260053007921\"}],\"receiveDate\":\"\",\"investorSocialCreditCode\":\"\",\"dealerPersonal\":\"\",\"investorBank\":\"\",\"cars\":[{\"dailyInterestAfterSixty\":\"234.24\",\"models\":\"冠道 2017款 370TURBO 四驱尊享版\",\"instructions\":0,\"note\":\"\",\"amount\":\"234,240\",\"color\":\"黑色\",\"isInWarehouse\":1,\"certificate\":0,\"securityReport\":0,\"manufacturer\":\"\",\"evaluatingPrice\":\"300,966\",\"commodityInspectionForm\":0,\"coc\":0,\"vehiclePurchaseTaxTable\":0,\"unique\":\"LHGTG3873H8032794\",\"dailyInterest\":\"93.69\",\"customsDeclaration\":0,\"invoice\":0,\"brand\":\"本田\"}],\"despositAmount\":\"0\",\"contractAmount\":\"292,800\",\"investorLegalPerson\":\"唐学庆\"}";
       // String str = param.replaceAll("\\ ","");
        Map map = com.alibaba.fastjson.JSON.parseObject(param,HashedMap.class);
        CreateContractCommand createContractCommand = new CreateContractCommand(id,"hahah",map);
        String html = preview(new PreviewContractCommand(createContractCommand.getContractTemplateID(), createContractCommand.getParams()));
        String xhtml = null;
        try {
            xhtml = xhtmlService.toXhtml(html);
            File contractPDF = contractService.createPDF(xhtml);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }



    @Transactional(rollbackFor = Throwable.class)
    public Long create(CreateContractCommand command) throws Exception {
        Assert.notNull(command);
        //1.查询合同模板
        //2.通过合同模板查询实际文件
        //3.把字段映射到实际文件上 创建html
        String html = preview(new PreviewContractCommand(command.getContractTemplateID(), command.getParams()));
        String xhtml = xhtmlService.toXhtml(html);//转为xhtml

        //根据xhtml 创建pdf
        File contractPDF = contractService.createPDF(xhtml);//itextpdf

        byte[] content = FileUtil.readAsByteArray(contractPDF);
        String mime = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(contractPDF);

        String path = personUploadService.upload(contractPDF);//上传文件到7牛

        //插入数据库
        Long pdfFileId = paperService.add(new AddPaperCommand(path, content, mime));//
        Long htmlFileId = paperService.add(new AddPaperCommand(StringUtils.EMPTY, xhtml.getBytes("UTF-8"), "text/html"));
        Long contractId = contractService.add(new AddContractCommand(command.getContractTemplateID(), pdfFileId, htmlFileId));
        //删除本地已创建 pdf
        if (contractPDF != null && contractPDF.exists()) {
            contractPDF.delete();
        }

        return contractId;
    }

    public String preview(PreviewContractCommand command) {
        FpContractTemplateDO template = contractTemplateService.findBy(command.getContractTemplateID());
        FpMaterialFileDO paper = paperService.findBy(template.getFileId());
        return contractService.createHtml(paper.getPath(), command.getParams());
    }

    public String findHtml(Long contractId) throws Exception {
        FpContractDO contract = contractService.findBy(contractId);
        Assert.notNull(contract, "合同不存在");
        FpMaterialFileDO paper = paperService.findBy(contract.getHtmlFileId());
        return new String(paper.getContent(), "UTF-8");
    }
    public String findPdfPath(Long contractId) throws Exception {
        FpContractDO contract = contractService.findBy(contractId);
        Assert.notNull(contract, "合同不存在");
        FpMaterialFileDO paper = paperService.findBy(contract.getPdfFileId());
        /*if (!paper.getOpen()) {
            return accessPathService.findAccessPath(paper.getPath());
        }*/
        return paper.getPath();
    }
}
