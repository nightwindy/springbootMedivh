/* 原本 jpa
package com.windy.medivh.core.dao;

import com.mhc.lincoln.core.factory.UniqueNumberFactory;
import com.mhc.lincoln.dao.entity.FpOverdueSolveEntity;
import com.mhc.lincoln.dao.repository.OverdueSolveRepository;
import com.subaru.common.enums.debt.OverdueSolveTypeEnum;
import com.subaru.common.query.PageResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by XianGuo
 * Date: 2017-09-04 10:06
 *//*

@Service
@Slf4j
public class OverdueSolveDAO {

    @Autowired
    private OverdueSolveRepository overdueSolveRepository;

    @Autowired
    private UniqueNumberFactory uniqueNumberFactory;

    */
/**
     * 新增化解记录
     *//*

    public String createSolve(FpOverdueSolveEntity fpOverdueSolveEntity) {
        fpOverdueSolveEntity.setOverdueSolveId(uniqueNumberFactory.getSovlePrefix());
        fpOverdueSolveEntity.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        return this.saveSolve(fpOverdueSolveEntity);
    }

    */
/**
     * 更新化解记录
     *//*

    public String updateSolve(FpOverdueSolveEntity fpOverdueSolveEntity) {
        return this.saveSolve(fpOverdueSolveEntity);
    }

    */
/**
     * 保存化解记录
     *//*

    public String saveSolve(FpOverdueSolveEntity fpOverdueSolveEntity){
        if(fpOverdueSolveEntity==null){
            return null;
        }

        // 限制车辆状态和手续状态字符长度
        if(fpOverdueSolveEntity.getCarStatusDesc()!=null&&fpOverdueSolveEntity.getCarStatusDesc().length()>1000){
            fpOverdueSolveEntity.setCarStatusDesc(fpOverdueSolveEntity.getCarStatusDesc().substring(0,1000)+"...");
        }

        if(fpOverdueSolveEntity.getProcedureStatusDesc()!=null&&fpOverdueSolveEntity.getProcedureStatusDesc().length()>1000){
            fpOverdueSolveEntity.setProcedureStatusDesc(fpOverdueSolveEntity.getCarStatusDesc().substring(0,1000)+"...");
        }
        fpOverdueSolveEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));
        overdueSolveRepository.save(fpOverdueSolveEntity);
        return fpOverdueSolveEntity.getOverdueSolveId();
    }

    */
/**
     * 获取催收记录列表
     *//*

    public List<FpOverdueSolveEntity> findByRequest(QueryRequest request) {

        return overdueSolveRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>(2);
            if (!StringUtils.isEmpty(request.getDebtId())) {
                predicateList.add(criteriaBuilder.equal(root.get("debtId"), request.getDebtId()));
            }
            // 过滤暂无的方案
            predicateList.add(criteriaBuilder.notEqual(root.get("approveStatus"),OverdueSolveTypeEnum.NOT_EXIST.getCode()));
            Predicate[] predicates = new Predicate[predicateList.size()];
            return criteriaBuilder.and(predicateList.toArray(predicates));
        });
    }

    */
/**
     * 分页获取催收记录列表
     *//*

    public PageResult<FpOverdueSolveEntity> findByPageRequest(QueryRequest request) {

        Sort sort = new Sort(Sort.Direction.DESC, "gmtCreate");
        Pageable pageable = new PageRequest(request.getPageNo(), request.getPageSize(), sort);
        Page<FpOverdueSolveEntity> pageResult = overdueSolveRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (!StringUtils.isEmpty(request.getDebtId())) {
                predicateList.add(criteriaBuilder.equal(root.get("debtId"), request.getDebtId()));
            }
            // 过滤暂无的方案
            predicateList.add(criteriaBuilder.notEqual(root.get("solveScheme"),OverdueSolveTypeEnum.NOT_EXIST.getCode()));
            Predicate[] predicates = new Predicate[predicateList.size()];
            return criteriaBuilder.and(predicateList.toArray(predicates));
        }, pageable);

        if (pageResult == null || CollectionUtils.isEmpty(pageResult.getContent())) {
            return null;
        }

        PageResult<FpOverdueSolveEntity> result = new PageResult<>();
        result.setPageNo(request.getPageNo());
        result.setPageSize(request.getPageSize());
        result.setResult(pageResult.getContent());
        result.setTotalCount((int) pageResult.getTotalElements());
        return result;
    }

    */
/**
     * 查询催收记录
     *//*

    public FpOverdueSolveEntity findById(String collectionNo) {
        return overdueSolveRepository.findOne(collectionNo);
    }


    @Data
    public static class QueryRequest {

        */
/**
         * 分页大小
         *//*

        private int pageSize;

        */
/**
         * 页
         *//*

        private int pageNo;

        */
/**
         * 借据id
         *//*

        private String debtId;


    }
}

*/
