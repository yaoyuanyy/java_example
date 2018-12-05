package com.yy.example.gson;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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
public class CentralizedHouseQuery {

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
    private List<CentralizedHouse> centralizedList;

    public static class CentralizedHouse {
        /**
         * 第三方劵id
         */
        @NotNull(message = "劵模板id不为空")
        private Long couponTemplateId;

        /**
         * 集中式房源编码
         */
        @NotBlank(message = "房源编号不为空")
        private String layoutCode;

        public Long getCouponTemplateId() {
            return couponTemplateId;
        }

        public void setCouponTemplateId(Long couponTemplateId) {
            this.couponTemplateId = couponTemplateId;
        }

        public String getLayoutCode() {
            return layoutCode;
        }

        public void setLayoutCode(String layoutCode) {
            this.layoutCode = layoutCode;
        }

        @Override
        public String toString() {
            return "DistributedHouse{" +
                    "couponTemplateId=" + couponTemplateId +
                    ", layoutCode='" + layoutCode + '\'' +
                    '}';
        }
    }
}
