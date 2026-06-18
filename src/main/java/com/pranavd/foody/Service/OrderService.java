package com.pranavd.foody.Service;

import com.pranavd.foody.DTO.OrderRequestDTO;
import com.pranavd.foody.DTO.OrderResponseDTO;
import com.pranavd.foody.Model.MenuItem;
import com.pranavd.foody.Model.Order;
import com.pranavd.foody.Model.OrderItem;
import com.pranavd.foody.Model.User;
import com.pranavd.foody.Repository.MenuItemRepository;
import com.pranavd.foody.Repository.OrderItemRepository;
import com.pranavd.foody.Repository.OrderRepository;
import com.pranavd.foody.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService  {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public OrderResponseDTO placeOrder(Long userId, OrderRequestDTO request){

        User user=userRepository.findById(userId)
                .orElseThrow(() ->new RuntimeException("User Not Found"));

        BigDecimal totalPrice = BigDecimal.ZERO;
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderRequestDTO.OrderItemRequest itemRequest : request.getItems()){

            MenuItem menuItem=menuItemRepository.findById(itemRequest.getItemId())
                    .orElseThrow(()->new RuntimeException("Menu Item Not Found!"));

            BigDecimal itemTotal=menuItem.getDishPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQty()));

            totalPrice.add(itemTotal);

            OrderItem orderItem=new OrderItem();
            orderItem.setDishName(menuItem.getDishName());
            orderItem.setDishPrice(menuItem.getDishPrice());
            orderItem.setQuantity(itemRequest.getQty());
            orderItems.add(orderItem);
        }

        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(totalPrice);
        order.setOrderStatus("PENDING");
        Order savedOrder = orderRepository.save(order);

        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(savedOrder);
            orderItemRepository.save(orderItem);
        }

        return buildOrderResponse(savedOrder, orderItems);
    }
}















