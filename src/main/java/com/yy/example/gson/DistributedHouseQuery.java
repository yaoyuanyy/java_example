package com.yy.example.gson;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Description: 分散式活动房源
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/11/20 at 下午2:49
 */
@Data
@NoArgsConstructor
public class DistributedHouseQuery {

    /**
     * 活动编号
     */
    @NotBlank(message = "活动编号不为空")
    private String activityCode;
    /**
     * 商家编码
     */
    @NotBlank(message = "商家编号不为空")
    private String businessCode;

    @Valid
    private List<DistributedHouse> distributedList;

    public static class DistributedHouse{
        /**
         * 第三方劵id
         */
        @NotNull(message = "劵模板id不为空")
        private Long couponTemplateId;

        /**
         * 分散式房源编码
         */
        @NotBlank(message = "分散式房源编号不为空")
        private String rentUnitCode;

        public Long getCouponTemplateId() {
            return couponTemplateId;
        }

        public void setCouponTemplateId(Long couponTemplateId) {
            this.couponTemplateId = couponTemplateId;
        }

        public String getRentUnitCode() {
            return rentUnitCode;
        }

        public void setRentUnitCode(String rentUnitCode) {
            this.rentUnitCode = rentUnitCode;
        }

        @Override
        public String toString() {
            return "DistributedHouse{" +
                    "couponTemplateId=" + couponTemplateId +
                    ", rentUnitCode='" + rentUnitCode + '\'' +
                    '}';
        }
    }

}
