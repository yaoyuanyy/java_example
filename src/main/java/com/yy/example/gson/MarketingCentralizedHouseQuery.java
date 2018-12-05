package com.yy.example.gson;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/11/14 at 下午2:49
 */
@Data
@NoArgsConstructor
public class MarketingCentralizedHouseQuery {

    /**
     * 活动编号
     */
    private String activityCode;

    /**
     * 第三方劵id
     */
    private Long couponTemplateId;

    /**
     * 集中式房源编码
     */
    private String layoutCode;

    /**
     * 商家编码
     */
    private String businessCode;

    /**
     * 状态 待审核
     */
    private Byte status = 1;
}
