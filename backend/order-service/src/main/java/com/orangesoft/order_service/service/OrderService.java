package com.orangesoft.order_service.service;

import com.orangesoft.order_service.dto.OrderRequest;
import com.orangesoft.order_service.dto.OrderResponse;
import com.orangesoft.order_service.entity.Order;
import com.orangesoft.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestClient restClient;

    public OrderService(OrderRepository orderRepository, RestClient.Builder restClientBuilder) {
        String inventory_base_url = "http://localhost:8084/api/v1/inventory";
        this.orderRepository = orderRepository;
        this.restClient = restClientBuilder.baseUrl(inventory_base_url).build();
    }
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> new OrderResponse(order.getOrderNo(), order.getName(), order.getDescription(), order.getStatus(), order.getTotalPrice(), order.getOrderItems()))
                .toList();

    }

    public OrderResponse addOrder(OrderRequest orderRequest) {
//        boolean enoughInventory = this.restClient.get().retrieve().body(Boolean.class);
//        if (!enoughInventory) {
//            // throw an error if there is not enough inventory
//        }
        Order order = new Order(UUID.randomUUID().toString(), orderRequest.name(), orderRequest.description(), orderRequest.status(), orderRequest.totalPrice(), orderRequest.orderItems());
        orderRepository.save(order);
        return new OrderResponse(order.getOrderNo(), order.getName(), order.getDescription(), order.getStatus(), order.getTotalPrice(), order.getOrderItems());
    }
}
