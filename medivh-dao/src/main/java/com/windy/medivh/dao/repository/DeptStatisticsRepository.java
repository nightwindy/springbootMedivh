package com.windy.medivh.dao.repository;

import com.windy.medivh.dao.entity.FpStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by waitou on 17/6/27.
 */
public interface DeptStatisticsRepository extends JpaRepository<FpStatisticsEntity, String>, JpaSpecificationExecutor<FpStatisticsEntity> {
}
