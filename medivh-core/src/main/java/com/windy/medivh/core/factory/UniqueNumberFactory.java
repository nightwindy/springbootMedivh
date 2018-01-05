package com.windy.medivh.core.factory;

import com.windy.medivh.common.util.CalendarUtil;
import com.windy.medivh.core.cache.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by eddy on 2017/6/7.
 */
@Service
public class UniqueNumberFactory {
    @Autowired
    private RedisService redisService;

    /**
     * 过期时间 无限
     */
    public static final int NO_EXPIRE_TIME = -1;

    /**
     * 结算单/展期 等业务编号的 自增KEY,6位自增数字 范围 100000-->999999
     */
    public static final String ORDER_CENTER_REDIS = "LINCOLN_NUMBER_KEY";

    public static final String PREFIX = "JJ";
    public static final String STATISTICS_PREFIX = "TJ";
    public static final String CAR_DEPT_PREFIX = "CD";
    public static final String CAR_DEPT_RECORD_PREFIX ="RD";
    public static final String CAPITAL_POOL_PREFIX ="CP";
    public static final String DEBT_CESSION_PREFIX ="DC";
    public static final String DEBT_COLLECTION_PREFIX ="DB";
    public static final String COLLECTION_PREFIX ="CR";
    public static final String SOVLE_PREFIX="SR";



    public static final int MIN_NUM = 100000;

    public static final int MAX_NUM = 999999;

    /**
     * 存储 编号20170307100001的时间部分(即 20170307),减少重复生成, 当天日期yyyy-mm-dd 00:00:00时间戳作为key;
     * 仅保存 当天的 缓存即可;
     */
    private Map<Long, String> preDayNum = new ConcurrentHashMap<Long, String>(4);

    /*
        获取6位自增
     */
    public Long getSixsNum() {
        return redisService.incr(ORDER_CENTER_REDIS, NO_EXPIRE_TIME);
    }

    /**
     * 返回 六位自增 初始值100000
     *
     * @return
     */
    public Long getMinSixNum() {
        return this.getSixsNum() + MIN_NUM;
    }

    /**
     * 返回结算单编号:例如 20170307100001
     *
     * @return
     */
    public String getUniqueNum() {
        Calendar calendar = Calendar.getInstance();
        Long todayTime = Long.valueOf(CalendarUtil.toString(calendar.getTime()));

        if (preDayNum.get(todayTime) == null) {
            //需要清除preDayNum内所有key,避免缓存数据增长,仅保存 当天的 缓存即可
            preDayNum.clear();
            preDayNum.put(todayTime, CalendarUtil.toString(calendar.getTime()));
        }

        return preDayNum.get(todayTime) + this.getMinSixNum();
    }

    /*
        加 业务前缀 例如 J20170307100001
     */
    public String getPrefixNumber(String preFix) {
        return preFix + this.getUniqueNum();
    }

    /*
     加 业务前缀 例如 J20170307100001
  */
    public String getDebtPrimaryKey() {
        return PREFIX + this.getUniqueNum();
    }

    public String getStatisticsPrimaryKey() {
        return STATISTICS_PREFIX + this.getUniqueNum();
    }

    /**
     * 车辆借据的业务编号
     * 例如 CD20170307100001
     */
    public String getCarDeptPrefix(){
        return CAR_DEPT_PREFIX+this.getUniqueNum();
    }

    /**
     * 车辆计息记录编号
     */
    public String getCarDeptRecordPrefix(){
        return CAR_DEPT_RECORD_PREFIX+this.getUniqueNum();
    }

    /**
     * 催收记录编号
     */
    public String getCollectionPrefix(){
        return CAR_DEPT_RECORD_PREFIX+this.getUniqueNum();
    }

    /**
     * 催收记录编号
     */
    public String getSovlePrefix(){
        return SOVLE_PREFIX+this.getUniqueNum();
    }
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

}
