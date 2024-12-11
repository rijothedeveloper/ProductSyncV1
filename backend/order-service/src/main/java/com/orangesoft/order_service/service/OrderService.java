package com.orangesoft.order_service.service;

import com.orangesoft.order_service.OrderServiceApplication;
import com.orangesoft.order_service.dto.OrderRequest;
import com.orangesoft.order_service.dto.OrderResponse;
import com.orangesoft.order_service.entity.Order;
import com.orangesoft.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> new OrderResponse(order.getOrderNo(), order.getName(), order.getDescription(), order.getStatus(), order.getTotalPrice()))
                .toList();

    }

    public OrderResponse addOrder(OrderRequest orderRequest) {
        Order order = new Order(UUID.randomUUID().toString(), orderRequest.name(), orderRequest.description(), orderRequest.status(), orderRequest.totalPrice());
        orderRepository.save(order);
        return new OrderResponse(order.getOrderNo(), order.getName(), order.getDescription(), order.getStatus(), order.getTotalPrice());
    }
}
