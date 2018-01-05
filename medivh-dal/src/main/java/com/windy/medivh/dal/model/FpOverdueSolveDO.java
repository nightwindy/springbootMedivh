package com.windy.medivh.dal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FpOverdueSolveDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 化解编号
     * fp_overdue_solve.overdue_solve_id
     */
    private String overdueSolveId;

    /**
     * 催收编号
     * fp_overdue_solve.collection_no
     */
    private String collectionNo;

    /**
     * 借据id
     * fp_overdue_solve.debt_id
     */
    private String debtId;

    /**
     * 实施人
     * fp_overdue_solve.executor
     */
    private String executor;

    /**
     * 实施人id
     * fp_overdue_solve.execute_id
     */
    private String executeId;

    /**
     * 实施日期
     * fp_overdue_solve.execute_date
     */
    private Date executeDate;

    /**
     * 车辆位置 0未知 1厂家未发车 2物流中 3已入库
     * fp_overdue_solve.car_position
     */
    private Integer carPosition;

    /**
     * 借据本金
     * fp_overdue_solve.debt_principal
     */
    private java.math.BigDecimal debtPrincipal;

    /**
     * 借据利息
     * fp_overdue_solve.debt_interest
     */
    private java.math.BigDecimal debtInterest;

    /**
     * 借据本息和
     * fp_overdue_solve.debt_principal_interest
     */
    private java.math.BigDecimal debtPrincipalInterest;

    /**
     * 解决方案 0未知 1追加保证金 5 暂无
     * fp_overdue_solve.solve_scheme
     */
    private Integer solveScheme;

    /**
     * 实施描述
     * fp_overdue_solve.execute_desc
     */
    private String executeDesc;

    /**
     * 手续位置 0未知 1未邮寄 2大区办公室 3杭州公司 4资方 5三方监管
     * fp_overdue_solve.procedure_position
     */
    private Integer procedurePosition;

    /**
     * 还款利息
     * fp_overdue_solve.payment_interest
     */
    private java.math.BigDecimal paymentInterest;

    /**
     * 备注
     * fp_overdue_solve.remark
     */
    private String remark;

    /**
     * 预计还款时间
     * fp_overdue_solve.predict_repayment_date
     */
    private Date predictRepaymentDate;

    /**
     * 车辆状态 0未知 1 异常 2 正常
     * fp_overdue_solve.car_status
     */
    private Integer carStatus;

    /**
     * 手续状态 0未知 1 异常 2 正常
     * fp_overdue_solve.procedure_status
     */
    private Integer procedureStatus;

    /**
     * 车辆状态描述
     * fp_overdue_solve.car_status_desc
     */
    private String carStatusDesc;

    /**
     * 手续状态描述
     * fp_overdue_solve.procedure_status_desc
     */
    private String procedureStatusDesc;

    /**
     * 审批状态 0 待审核 1 不通过 2 通过
     * fp_overdue_solve.approve_status
     */
    private Integer approveStatus;

    /**
     * 审批意见
     * fp_overdue_solve.approve_comment
     */
    private String approveComment;

    /**
     * 
     * fp_overdue_solve.status
     */
    private Integer status;

    /**
     * 创建来源 0 H5 1 后台
     * fp_overdue_solve.create_source
     */
    private Integer createSource;

    /**
     * 
     * fp_overdue_solve.gmt_modified
     */
    private Date gmtModified;

    /**
     * 
     * fp_overdue_solve.gmt_create
     */
    private Date gmtCreate;

    /**
     * 还款承诺函 url 和 name 集合
     * fp_overdue_solve.repayment_promise_letter_list
     */
    private String repaymentPromiseLetterList;

    /**
     * 其他文件 url和name的集合
     * fp_overdue_solve.other_file_list
     */
    private String otherFileList;

}