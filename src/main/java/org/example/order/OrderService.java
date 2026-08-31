package org.example.order;

import java.math.BigDecimal;

public class OrderService {
    public void processOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("订单不能为空");
        }
        if (null == order.getOrderNo()) {
            throw new IllegalArgumentException("订单编号不能为空");
        }
        if (null == order.getCustomerName()) {
            throw new IllegalArgumentException("客户名称不能为空");
        }
        if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("金额必须大于0");
        }
        if (order.getAmount().compareTo(new BigDecimal("10000")) > 0) { // 假设超限阈值为 100000
            throw new IllegalArgumentException("金额超限");
        }

    }
}
