/*
package com.windy.medivh.core.scheduler;

import com.chevrolet.api.dto.TmsCarDTO;
import com.chevrolet.api.dto.TransportInfoDTO;
import com.mhc.lincoln.core.ao.IAssetDebtAO;
import com.mhc.lincoln.core.ao.IMessageAO;
import com.medivh.core.bo.FpDebtCollectionLogBO;
import com.windy.medivh.core.bo.FpDebtEntityBO;
import com.mhc.lincoln.core.cache.RedisService;
import com.windy.medivh.core.common.util.ArrayUtil;
import com.windy.medivh.core.common.util.DateUtil;
import com.mhc.lincoln.core.dao.FpDebtCollectionLogDAO;
import com.mhc.lincoln.core.dao.FpDebtDAO;
import com.windy.medivh.core.dao.OverdueSolveDAO;
import com.windy.medivh.core.service.DebtCarInfoService;
import com.windy.medivh.core.service.dubbo.OverDueServiceImpl;
import com.medivh.core.service.dubboAdapter.ChevroletAdapter;
import com.mhc.lincoln.dal.model.FpDebtDO;
import com.mhc.lincoln.dal.query.FpDebtQuery;
import com.mhc.lincoln.dao.entity.FpOverdueSolveEntity;
import com.mhc.lincoln.dto.StatisticsListRequest;
import com.mhc.lincoln.enums.DebtStatusEnum;
import com.subaru.common.enums.ApproveStatusEnum;
import com.subaru.common.enums.FinancialProductTypeEnum;
import com.subaru.common.enums.debt.OverdueSolveTypeEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OverDueScheduler {

    private static final Logger logger = LoggerFactory.getLogger(OverDueScheduler.class);

    private static final String CORN_DELAY = "0 0 1 * * ?"; // 每天的早晨1点执行任务

    private static final String STATISTICS_TIMING = "0 30 23 * * ?"; // 每天的晚上11点半执行任务

    private static final String ARRVAIL_DELAY = "0 0 2 * * ?";//每天早晨两点跑定时器，获取订单贷的物流到车日期

    private static final String COLLECTION_LOG_DELAY = "0 30 4 * * ?";//每天四点半跑定时器刷催收记录

    private static final String ALERT_DINGDING_DELAY = "0 30 5 * * ?";//每天5点半跑定时器刷催收记录

    private static final String TASK_LOCK = "debt_overdue_task_lock";

    private static final String ARRVIAL_CHECK_LOCK = "debt_arrvail_task-lock";

    private static final String STATISTICS_LOCK = "statistics_capital_task_lock";

    private static final String DEBT_COLLECTION_LOCK = "debt_collection_lock";

    private static final String ALERT_DINGDING_LOCK = "alert_dingding_lock";

    @Autowired
    private RedisService redisService;
    @Autowired
    private FpDebtDAO fpDebtDAO;
    @Autowired
    private DebtCarInfoService debtCarInfoService;
    @Autowired
    private ChevroletAdapter chevroletAdapter;
    @Value("${spring.profiles.active}")
    private String active;
    @Autowired
    private OverDueServiceImpl overDueService;

    @Autowired
    private OverdueSolveDAO overdueSolveDAO;
    @Autowired
    private FpDebtCollectionLogDAO fpDebtCollectionLogDAO;
    @Autowired
    private IMessageAO iMessageAO;

    @Autowired
    private IAssetDebtAO assetDebtAO;

    @Scheduled(cron = CORN_DELAY)//每天早上1点
    public void foemalitiesCheck() {
        if (StringUtils.isNotEmpty(active) && !"online".equals(active)) {
            logger.info("预发不跑定时任务");
            return;
        }
        //判断是否有机子在跑定时器
        if (!redisService.setNX(TASK_LOCK, "TASK_LOCK", 10)) {
            logger.info("定时任务现在不需要执行，另一台机器执行");
            return;
        }

        */
/**
         * 更新没有结清的借据和车辆信息
         *//*

        debtCarInfoService.calAllDebtCal();


        // 查询所有逾期的借据
        List<FpDebtEntityBO> bos = fpDebtDAO.getAllOverDueDebt();
        if (CollectionUtils.isEmpty(bos)) {
            logger.info("没有逾期的借据");
            return;
        }
        for (FpDebtEntityBO bo : bos) {
            if (FinancialProductTypeEnum.ORDER_LOAN.getCode().equals(new Integer(bo.getBizType())) && bo.getHasCheckArrvailTime().equals(Integer.valueOf(0).byteValue())) {//当业务是订单贷，但是没有维护物流到车日的即使超期了，也不做处理，只有维护了到车日，真的到期了才真正逾期
                continue;
            }
            if (DebtStatusEnum.PAST.getCode() != bo.getStatus()) {
                //逾期状态
                bo.setStatus((byte) (DebtStatusEnum.PAST.getCode()));
                //逾期本金（借据余额）
                bo.setOverduePrincipal(bo.getDebtBalanceAndPrincipal());
                if (bo.getRealDueDate() != null) {
                    //逾期时间(实际到期日+1)
                    bo.setOverdueTime(new Timestamp(bo.getRealDueDate().getTime() + 24 * 3600000L - 1));//这边减1为了防止00：00：00这样的数据不好判断逾期日期
                    //逾期天数(当前日期-实际到期日)
                    bo.setOverdueDaytime(((System.currentTimeMillis() - bo.getRealDueDate().getTime()) / (24 * 3600000L)) + 1L);
                }
                //逾期利息（借据利息）
                bo.setOverdueInterest(bo.getDebtBalanceInterest());
                //逾期本息和 （借据本息和）
                bo.setOverduePrincipalAndInterest(bo.getDebtBalanceInterestAndPrincipal());
            } else {
                if (bo.getRealDueDate() != null) {
                    //逾期时间(实际到期日+1)
                    bo.setOverdueTime(new Timestamp(bo.getRealDueDate().getTime() + 24 * 3600000L - 1));//这边减1为了防止00：00：00这样的数据不好判断逾期日期
                    //逾期天数(当前日期-实际到期日)
                    bo.setOverdueDaytime(((System.currentTimeMillis() - bo.getRealDueDate().getTime()) / (24 * 3600000L)) + 1L);
                }
                //同步刷一遍逾期本金，逾期利息，和逾期本息和
                //逾期本金（借据余额）
                bo.setOverduePrincipal(bo.getDebtBalanceAndPrincipal());
                //逾期利息（借据利息）
                bo.setOverdueInterest(bo.getDebtBalanceInterest());
                //逾期本息和 （借据本息和）
                bo.setOverduePrincipalAndInterest(bo.getDebtBalanceInterestAndPrincipal());
            }
            fpDebtDAO.updateDebt(bo);
        }

    }

    @Scheduled(cron = ARRVAIL_DELAY)//每天早上2点
    public void carArrvialTimeCheck() {
        if (StringUtils.isNotEmpty(active) && !"online".equals(active)) {
            logger.info("预发不跑定时任务");
            return;
        }
        //判断是否有机子在跑定时器
        if (!redisService.setNX(ARRVIAL_CHECK_LOCK, "ARRVIAL_CHECK_LOCK", 10)) {
            logger.info("定时任务现在不需要执行，另一台机器执行");
            return;
        }
        //获取没有刷新过到期日期的借据
        List<FpDebtEntityBO> unFlushArrvial = fpDebtDAO.getMayFlushArrvailDebt();
        if (CollectionUtils.isEmpty(unFlushArrvial)) {
            logger.info("没有待更新到车日期的借据");
        }

        // 需要刷的订单编号
        List<String> orderNoList = new ArrayList<>();
        for (FpDebtEntityBO bo : unFlushArrvial) {
            orderNoList.add(bo.getOrderNo());
        }
        List<String> orderNoList2 = assetDebtAO.getOrderLoanOrderNo();
        HashSet<String> orderNoSet = new HashSet<>(orderNoList2.size());
        orderNoList.forEach(orderNoSet::add);
        orderNoList2.forEach(orderNoSet::add);

        // 分页获取到车时间
        HashMap<String, TransportInfoDTO> tmsMap = new HashMap<>(orderNoSet.size());
        ArrayUtil.onPage(new ArrayList<>(orderNoSet), pageList -> {
            List<TransportInfoDTO> transportInfoDTOs = chevroletAdapter.getTransportInfoDTOByLoanOrderNoList(pageList);
            transportInfoDTOs.forEach(item -> tmsMap.put(item.getBizOrderNo(), item));
            return false;
        });

        // 更新订单借据的到车时间
        try {
            for (FpDebtEntityBO bo : unFlushArrvial) {
                TransportInfoDTO tmsInfo = tmsMap.get(bo.getOrderNo());
                if (tmsInfo == null || CollectionUtils.isEmpty(tmsInfo.getTmsCarDTOList())) {
                    continue;
                }

                // 按到车时间先后排序
                List<TmsCarDTO> tmsCarDTOList = tmsInfo.getTmsCarDTOList()
                        .stream()
                        .filter(tmsCarDTO -> tmsCarDTO.getArrivalTime() != null)
                        .sorted(Comparator.comparing(TmsCarDTO::getArrivalTime))
                        .collect(Collectors.toList());
                if (CollectionUtils.isEmpty(tmsCarDTOList)) {
                    continue;
                }

                TmsCarDTO carDTO = tmsCarDTOList.get(0);
                Date arrivalTime = DateUtil.getDate(carDTO.getArrivalTime());
                Date dueDate = DateUtil.addDays(arrivalTime,bo.getLimitCount()==null?0:bo.getLimitCount().intValue());
                bo.setDueDate(new Timestamp(dueDate.getTime()));
                bo.setRealDueDate(bo.getDueDate());
                bo.setArrivalTime(arrivalTime.getTime());
                bo.setHasCheckArrvailTime((byte) 1);
                fpDebtDAO.updateDebt(bo);

            }
        }catch (Exception e){
            logger.error("更新订单借据的物流到车时间异常",e);
        }

        // 更新新的车辆借据
        assetDebtAO.updateRepaymentDeadline(tmsMap);


    }

    @Scheduled(cron = STATISTICS_TIMING)//每天晚上11点
    public void statisticsCheck() {
        if (StringUtils.isNotEmpty(active) && !"online".equals(active)) {
            logger.info("预发不跑定时任务");
            return;
        }
        //判断是否有机子在跑定时器
        if (!redisService.setNX("STATISTICS_LOCK", STATISTICS_LOCK, 10)) {
            logger.info("定时任务现在不需要执行，另一台机器执行");
            return;
        }
        StatisticsListRequest statisticsListRequest = new StatisticsListRequest();
        statisticsListRequest.setPageNo(0);
        statisticsListRequest.setPageSize(20);
        fpDebtDAO.findAllStatisticsList(statisticsListRequest);
    }

    @Scheduled(cron = COLLECTION_LOG_DELAY)//每天后半夜四点半
    public void addCollection() {
        if (StringUtils.isNotEmpty(active) && !"online".equals(active)) {
            logger.info("预发不跑定时任务");
            return;
        }
        //判断是否有机子在跑定时器
        if (!redisService.setNX("DEBT_COLLECTION_LOCK", DEBT_COLLECTION_LOCK, 10)) {
            logger.info("定时任务现在不需要执行，另一台机器执行");
            return;
        }
        // 查询所有逾期的借据
        List<FpDebtEntityBO> bos = fpDebtDAO.getAllOverDueDebtForCollection();
        if (CollectionUtils.isEmpty(bos)) {
            logger.info("没有逾期的借据");
            return;
        }
        for (FpDebtEntityBO bo : bos) {//逾期1，3，7天的创建逾期代办
            //刷新未处理的代办任务中的逾期天数，逾期本金 ，逾期利息，逾期本息和
            List<FpDebtCollectionLogBO> collectionEntities = fpDebtCollectionLogDAO.getLogListByDebtId(bo.getDebtId());
            for (FpDebtCollectionLogBO fpDebtCollectionLogBO : collectionEntities) {
                if (fpDebtCollectionLogBO.getStatus().equals(ApproveStatusEnum.WAIT.getCode())) {
                    fpDebtCollectionLogBO.setOverdueDaytime(bo.getOverdueDaytime());
                    fpDebtCollectionLogBO.setOverduePrincipal(bo.getDebtBalanceAndPrincipal());
                    fpDebtCollectionLogBO.setOverduePrincipalAndInterest(bo.getDebtBalanceInterestAndPrincipal());
                    fpDebtCollectionLogBO.setOverdueInterest(bo.getDebtBalanceInterest());
                    fpDebtCollectionLogDAO.updateBO(fpDebtCollectionLogBO);
                }
            }
            if (Long.valueOf(1L).equals(bo.getOverdueDaytime())) {
                this.addCollectionLog(bo.getDebtId());
            }
        }
    }

    @Scheduled(cron = ALERT_DINGDING_DELAY)//每天后半夜5点半
    public void alertDingDing() {
        if (StringUtils.isNotEmpty(active) && !"online".equals(active)) {
            logger.info("预发不跑定时任务");
            return;
        }
        //判断是否有机子在跑定时器
        if (!redisService.setNX("ALERT_DINGDING_LOCK", ALERT_DINGDING_LOCK, 10)) {
            logger.info("定时任务现在不需要执行，另一台机器执行");
            return;
        }
        // 查询7天
        FpDebtQuery query = new FpDebtQuery();
        FpDebtQuery.Criteria criteria = query.createCriteria();
        criteria.andOverdueDaytimeEqualTo(7L);
        criteria.andStatusEqualTo(DebtStatusEnum.PAST.getCode());
        List<FpDebtDO> fpDebtDOS = fpDebtDAO.selectByQuery(query);
        if (CollectionUtils.isEmpty(fpDebtDOS)) {
            logger.info("没有超期7天的借据");
        } else {
            Map<String, Long> collect = fpDebtDOS.stream().collect(Collectors.groupingBy(FpDebtDO::getBusinessBusiness, Collectors.counting()));
            for (Map.Entry<String, Long> entry : collect.entrySet()) {
                String msg = "你好！目前你名下有" + entry.getValue() + "笔超期业务已经超期7天，请在今日内务必填写超期反馈，业务超期到达第8天，其资产风险性质将会发生改变需要进行填写贷后反馈，请在业务超期7日内及时填写";
                iMessageAO.sendDingTalkByUserId(String.valueOf(entry.getKey()), msg);
            }
        }

        // 查询8天
        FpDebtQuery query2 = new FpDebtQuery();
        FpDebtQuery.Criteria criteria2 = query2.createCriteria();
        criteria2.andOverdueDaytimeEqualTo(8L);
        criteria2.andStatusEqualTo(DebtStatusEnum.PAST.getCode());
        List<FpDebtDO> bos2 = fpDebtDAO.selectByQuery(query2);
        if (CollectionUtils.isEmpty(bos2)) {
            logger.info("没有超期8天的借据");
        } else {
            Map<String, Long> collect = bos2.stream().collect(Collectors.groupingBy(FpDebtDO::getBusinessBusiness, Collectors.counting()));
            for (Map.Entry<String, Long> entry : collect.entrySet()) {
                String msg = "目前你名下有" + entry.getValue() + "笔业务已经超期8天，其资产风险性质发生改变，将会对你个人绩效产生影响，请及时催收、反馈！";
                iMessageAO.sendDingTalkByUserId(String.valueOf(entry.getKey()), msg);
            }
        }


    }

    */
/**
     * 自动逾期催收记录添加
     * 判断逻辑是否要添加逾期催收记录
     *//*

    private void addCollectionLog(String debtId) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(debtId)) {
            return;
        }
        List<FpDebtCollectionLogBO> fpDebtCollectionLogBOList = fpDebtCollectionLogDAO.getLogListByDebtId(debtId);
        //未处理的就刷新
        if (Integer.valueOf(0).equals(fpDebtCollectionLogBOList.size())) {//没有催收记录就添加
            //生成催收记录
            overDueService.insertCollectionLog(debtId);
            return;
        }
        Boolean isAllDo = true;
        for (FpDebtCollectionLogBO fpDebtCollectionLogBO : fpDebtCollectionLogBOList) {
            if (fpDebtCollectionLogBO.getStatus().equals(ApproveStatusEnum.WAIT.getCode())) {
                isAllDo = false;
                break;
            }
        }
        if (!isAllDo) {//有未处理的代办，就不产生代办
            return;
        }
        // 先查有没有化解记录，有化解记录但是没处理的要新增催收记录
        // 其次没有化解记录的，催收记录都处理了也要生成催收代办
        OverdueSolveDAO.QueryRequest request = new OverdueSolveDAO.QueryRequest();
        request.setDebtId(debtId);
        List<FpOverdueSolveEntity> solveEntities = overdueSolveDAO.findByRequest(request);
        List<FpOverdueSolveEntity> newSolveList = new ArrayList<>();
        for (FpOverdueSolveEntity fpOverdueSolveEntity : solveEntities) {
            if (!fpOverdueSolveEntity.getSolveScheme().equals(OverdueSolveTypeEnum.NOT_EXIST.getCode())) {
                newSolveList.add(fpOverdueSolveEntity);
            }
        }
        if (CollectionUtils.isEmpty(newSolveList)) {
            overDueService.insertCollectionLog(debtId);
            return;
        }
        Boolean hasEnSolve = false;
        for (FpOverdueSolveEntity fpOverdueSolveEntity : newSolveList) {
            if (ApproveStatusEnum.PASS.getCode().equals(fpOverdueSolveEntity.getApproveStatus()) || ApproveStatusEnum.WAIT.getCode().equals(fpOverdueSolveEntity.getApproveStatus())) {
                hasEnSolve = true;
                break;
            }
        }
        if (!hasEnSolve) {
            overDueService.insertCollectionLog(debtId);
            return;
        }
    }
}
*/
