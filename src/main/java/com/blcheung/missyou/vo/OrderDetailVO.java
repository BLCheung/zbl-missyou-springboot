package com.blcheung.missyou.vo;

import com.blcheung.missyou.model.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class OrderDetailVO extends Order {
    /**
     * 支付到期时间限制
     */
    private Long limitPayTime;

    public OrderDetailVO(Order order, Long limitPayTime) {
        BeanUtils.copyProperties(order, this);
        this.limitPayTime = limitPayTime;
    }
}
