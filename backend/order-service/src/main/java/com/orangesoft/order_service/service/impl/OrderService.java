package com.orangesoft.order_service.service.impl;

import com.orangesoft.order_service.dto.OrderRequest;
import com.orangesoft.order_service.dto.OrderResponse;
import com.orangesoft.order_service.entity.Order;
import com.orangesoft.order_service.excemption.OrderNotFoundException;
import com.orangesoft.order_service.mapper.OrderMapper;
import com.orangesoft.order_service.repository.OrderRepository;
import com.orangesoft.order_service.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> new OrderResponse(order.getOrderNo(), order.getDescription(), order.getStatus(), order.getTotalPrice(), order.getOrderItems()))
                .toList();

    }

    @Override
    public OrderResponse getOrder(String orderNo) {
        Order order = orderRepository.findById(orderNo).orElseThrow(() -> new OrderNotFoundException(orderNo));
        return OrderMapper.mapOrderToOrderResponse(order);
    }

    public OrderResponse addOrder(OrderRequest orderRequest) {
//        boolean enoughInventory = this.restClient.get().retrieve().body(Boolean.class);
//        if (!enoughInventory) {
//            // throw an error if there is not enough inventory
//        }
        Order order = new Order(UUID.randomUUID().toString(), orderRequest.description(), orderRequest.status(), orderRequest.totalPrice(), orderRequest.orderItems());
        orderRepository.save(order);
        return new OrderResponse(order.getOrderNo(), order.getDescription(), order.getStatus(), order.getTotalPrice(), order.getOrderItems());
    }
}
