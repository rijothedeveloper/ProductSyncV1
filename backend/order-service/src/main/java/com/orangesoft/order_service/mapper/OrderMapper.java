package com.orangesoft.order_service.mapper;

import com.orangesoft.order_service.dto.OrderRequest;
import com.orangesoft.order_service.dto.OrderResponse;
import com.orangesoft.order_service.entity.Order;

public class OrderMapper {
    public static Order mapOrderRequestToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setDescription(orderRequest.description());
        order.setStatus(orderRequest.status());
        order.setTotalPrice(orderRequest.totalPrice());
        order.setOrderItems(orderRequest.orderItems());
        return order;
    }

    public static OrderResponse mapOrderToOrderResponse(Order order) {
        return new OrderResponse(order.getOrderNo(), order.getDescription(), order.getStatus(), order.getTotalPrice(), order.getOrderItems());
    }
}
