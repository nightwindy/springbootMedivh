package com.windy.medivh.core.dao;

import com.windy.medivh.common.entity.BizResult;
import com.windy.medivh.core.common.util.ConvertUtils;
import com.windy.medivh.dao.entity.CityEntity;
import com.windy.medivh.dao.repository.CityRepository;
import com.windy.medivh.dto.CityResponse;
import com.windy.medivh.request.CityRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.Predicate;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by windy on 2018/1/8.
 */


@Service
@Slf4j
public class CityDAO {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CityRepository cityRepository;

    public BizResult<List<CityResponse>> findFinanceList(CityRequest listRequest) {
        BizResult<List<CityResponse>> result = new BizResult<>();
        List<Map<String, Object>> financeListPage = getFinanceListPage(listRequest);
        Map<String, BigInteger> financeListPageCount = (Map) getFinanceListPageCount(listRequest);
        try {
            List<CityResponse> debtFinanceListResponse = ConvertUtils.convertListMap2ListBean(financeListPage, CityResponse.class);
            result.setData(debtFinanceListResponse);
            result.setSuccess(true);
            result.setPageNo(listRequest.getPageNo());
            result.setPageSize(listRequest.getPageSize());
            result.setTotalCount(financeListPageCount.get("totalCount").intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public List<Map<String, Object>> getFinanceListPage(CityRequest listRequest) {
        StringBuffer sb = new StringBuffer();
        sb.append("select c.cession_name as cessionName,d.debt_id as debtId,d.order_no as orderNo,d.dealer_name dealerName,d.capital_name as capitalName,d.biz_type as bizType,d.loan_amount as loanAmount,d.assure_amount as assureAmount,d.debt_balance_interest as debtBalanceInterest,d.reality_rate as realityRate,d.expenditure_date as expenditureDate,d.real_due_date as realDueDate,d.debt_balance_interest as transInterest from fp_debt d INNER join (" +
                " select a.debt_id,b.cession_name,a.status,a.capital_pool_id from (select fp_debt_cession.capital_pool_id,cession_name from fp_debt_cession inner join fp_capital_pool " +
                " on fp_debt_cession.capital_pool_id =  fp_capital_pool.capital_pool_id  where fp_debt_cession.capital_id=?1 ) b  left join " +
                " fp_capital_pool_debt_rel a on a.capital_pool_id =b.capital_pool_id  ) c on d.debt_id= c.debt_id " +
                " where 1=1  and c.status=10 ");

        /*//查询条件
        if (StringUtils.isNotBlank(listRequest.getOrderNo())) {
            sb.append(" and d.order_no like '%" + listRequest.getOrderNo() + "%'  ");
        }
        if (StringUtils.isNotBlank(listRequest.getCessionName())) {
            sb.append(" and c.cession_name like '%" + listRequest.getCessionName() + "%' ");
        }
        if (StringUtils.isNotBlank(listRequest.getDealerName())) {
            sb.append(" and d.dealer_name like '%" + listRequest.getDealerName() + "%'  ");
        }
        if (listRequest.getBizType() != null) {
            sb.append(" and d.biz_type =" + listRequest.getBizType());
        }
        if (StringUtils.isNotBlank(listRequest.getExpendStartTime()) && StringUtils.isNotBlank(listRequest.getExpendEndTime())) {
            sb.append(" and d.expenditure_date between '" + listRequest.getExpendStartTime() + "' and '" + listRequest.getExpendEndTime() + "'");
        }*/
        Integer pageNos = listRequest.getPageNo() * listRequest.getPageSize();
        sb.append("  limit " + pageNos + "," + listRequest.getPageSize());


        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter(1, listRequest.getCityName());
        //创建原生SQL查询QUERY实例
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String, Object>> resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    public Object getFinanceListPageCount(CityRequest listRequest) {
        StringBuffer sb = new StringBuffer();
        sb.append("select count(d.debt_id) as totalCount from fp_debt d INNER join (" +
                " select a.debt_id,b.cession_name,a.status,a.capital_pool_id from (select fp_debt_cession.capital_pool_id,cession_name from fp_debt_cession inner join fp_capital_pool " +
                " on fp_debt_cession.capital_pool_id =  fp_capital_pool.capital_pool_id  where fp_debt_cession.capital_id=?1 ) b  left join " +
                " fp_capital_pool_debt_rel a on a.capital_pool_id =b.capital_pool_id  ) c on d.debt_id= c.debt_id " +
                " where 1=1  and c.status=10 ");

       /* //查询条件
        if (StringUtils.isNotBlank(listRequest.getOrderNo())) {
            sb.append(" and d.order_no like '%" + listRequest.getOrderNo() + "%'  ");
        }
        if (StringUtils.isNotBlank(listRequest.getCessionName())) {
            sb.append(" and c.cession_name like '%" + listRequest.getCessionName() + "%' ");
        }
        if (StringUtils.isNotBlank(listRequest.getDealerName())) {
            sb.append(" and d.dealer_name like '%" + listRequest.getDealerName() + "%'  ");
        }
        if (listRequest.getBizType() != null) {
            sb.append(" and d.biz_type =" + listRequest.getBizType());
        }
        if (StringUtils.isNotBlank(listRequest.getExpendStartTime()) && StringUtils.isNotBlank(listRequest.getExpendEndTime())) {
            sb.append(" and d.expenditure_date between '" + listRequest.getExpendStartTime() + "' and '" + listRequest.getExpendEndTime() + "'");
        }*/
        String sbCount = sb.toString();
        Query queryCount = entityManager.createNativeQuery(sbCount);
        queryCount.setParameter(1, listRequest.getCityName());
        queryCount.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        Object resultCount = queryCount.getSingleResult();

        entityManager.close();
        return resultCount;
    }

    /**
     * s
     */
    public CityResponse getCityById(String deptId) {
        CityEntity entity = cityRepository.findOne(deptId);
        if (entity == null) {
            return null;
        }
        CityResponse  fpDebtEntityBO = new CityResponse();
        BeanUtils.copyProperties(entity, fpDebtEntityBO);
        return fpDebtEntityBO;
    }


    /*//根据managerId和status获取批量待办
    public List<FpDebtCollectionLogBO> getLogListByManagerIdandStatus(OverDueWaitRequest overDueWaitRequest){
        List<FpDebtCollectionLogBO> fpDebtCollectionLogBOS = new ArrayList<>();
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(overDueWaitRequest.getManagerId())&& null != overDueWaitRequest.getStatus()){
            logger.info("FpDebtCollectionLogDAO->getLogListByManagerIdandStatus" + overDueWaitRequest.getManagerId() + overDueWaitRequest.getStatus());
            try {
                Sort sort = new Sort(Sort.Direction.DESC, "gmtCreate");
                Pageable pageable = new PageRequest(overDueWaitRequest.getPageNo(), overDueWaitRequest.getPageSize(), sort);

                Page<FpDebtCollectionLogEntity> list = debtCollectionLogRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
                    List<Predicate> PredicateList = new ArrayList<Predicate>();
                    if (org.apache.commons.lang.StringUtils.isNotEmpty(overDueWaitRequest.getManagerId())){
                        PredicateList.add(criteriaBuilder.equal(root.get("managerId"), overDueWaitRequest.getManagerId()));
                    }
                    if (null != overDueWaitRequest.getStatus()){
                        PredicateList.add(criteriaBuilder.equal(root.get("status"),overDueWaitRequest.getStatus()));
                    }
                    Predicate[] p = new Predicate[PredicateList.size()];
                    return criteriaBuilder.and(PredicateList.toArray(p));
                }, pageable);

                for (FpDebtCollectionLogEntity entity : list) {
                    FpDebtCollectionLogBO fpDebtCollectionLogBO = new FpDebtCollectionLogBO();
                    BeanUtils.copyProperties(entity, fpDebtCollectionLogBO);
                    fpDebtCollectionLogBOS.add(fpDebtCollectionLogBO);
                }
            } catch (Exception e) {
                logger.error("debtCollectionLogRepository.findAll服务器出错", e);
            }
            logger.info("debtCollectionLogRepository -> getLogListByManagerIdandStatus = result : " + fpDebtCollectionLogBOS.size());
        }
        return fpDebtCollectionLogBOS;
    }*/

}
