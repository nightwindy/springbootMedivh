package com.windy.medivh.dao.repository;

import com.windy.medivh.dao.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by songshuang on 17/6/6.
 */
public interface CityRepository extends JpaRepository<CityEntity,String>, JpaSpecificationExecutor<CityEntity> {

    @Query("select fp from CityEntity fp where fp.id = ?1")
    CityEntity findByOrderNO(int id);

   /* @Modifying
    @Query(value = "update fp_debt set status = -1, gmt_modified = now() where order_no = ?1" ,nativeQuery = true)
    void close(String orderNo);

    @Query("select  new com.mhc.lincoln.dao.entity.AmountSumEntity(sum(t.loanAmount) ,sum(t.debtBalanceAndPrincipal) ) from FpDebtEntity t  where debtId in ?1")
    AmountSumEntity findAmountByDebtIds(List<String> debtIds);*/
}
