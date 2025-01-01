package com.orangesoft.order_service.service;

import com.orangesoft.order_service.dto.OrderRequest;
import com.orangesoft.order_service.dto.OrderResponse;

import java.util.List;

public interface IOrderService {
    List<OrderResponse> getAllOrders();
    OrderResponse getOrder(String orderNo);
    OrderResponse addOrder(OrderRequest orderRequest);
}
