/*
package com.medivh.core.service.dubboAdapter;

import com.maihaoche.acura.api.IInvestorService;
import com.maihaoche.acura.api.model.investor.Investor;
import com.mhc.acura.dubbo.IDepartmentService;
import com.mhc.acura.dubbo.IUserService;
import com.mhc.acura.dubbo.model.User;
import com.mhc.acura.dubbo.model.v2.StaffTopDepartment;
import com.subaru.common.entity.APIResult;
import com.subaru.common.entity.BizResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AcuraAdapter {

    @Resource(name = "investorService")
    private IInvestorService iInvestorService;
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IDepartmentService iDepartmentService;

    //获取所有的可债转的资方Id
    public BizResult<List<Long>> findCreditAssignmentInvestorIds(){
        BizResult<List<Long>> bizResult = new BizResult<>();
        try{
            bizResult = iInvestorService.findCreditAssignmentInvestorIds();
        }catch (Exception e){
            log.error("调用IInvestorService.findCreditAssignmentInvestorIds接口获取可债转的资方Id失败");
        }
        return bizResult;
    }

    */
/**
     * 获取业务经理的信息
     * @param var1
     * @return
     *//*

    public APIResult<List<User>> findBy(List<String> var1){
        APIResult<List<User>> apiResult = new APIResult<>();
        try{
            apiResult = iUserService.findBy(var1);
        }catch (Exception e){
            log.error("调用IUserService.findBy接口获取可债转的资方Id失败");
        }
        return apiResult;
    }

    */
/**
     * 获取组织架构树
     * @return
     *//*

    public BizResult<com.mhc.acura.dubbo.model.v2.DepartmentTree> findDepartmentTreeV2(){
        BizResult<com.mhc.acura.dubbo.model.v2.DepartmentTree> bizResult = new BizResult<>();
        try{
            bizResult = iDepartmentService.findDepartmentTreeV2();
        }catch (Exception e){
            log.error("调用IDepartmentService.findDepartmentTreeV2获取组织架构树失败");
        }
        return bizResult;
    }

    */
/**
     * 通过名称和花名模糊查询
     * @param name
     * @return
     *//*

    public BizResult<List<User>> findUserByRealNameOrNickName(String name){
        BizResult<List<User>> bizResult = new BizResult<>();
        try{
            bizResult = iUserService.findUserByRealNameOrNickName(name);
        }catch (Exception e){
            log.error("调用IUserService.findUserByRealNameOrNickName接口获取业务经理列表失败");
        }
        return bizResult;
    }

    */
/**
     * 通过资方Id获取资方信息
     * @param capitalIdList
     * @return
     *//*

    public BizResult<List<Investor>> findList(List<Long> capitalIdList){
        BizResult<List<Investor>> bizResult = new BizResult<>();
        try{
            bizResult = iInvestorService.findList(capitalIdList);
        }catch (Exception e){
            log.error("调用iInvestorService.findList接口获取资方基础信息接口失败");
        }
        return bizResult;
    }
}
*/
