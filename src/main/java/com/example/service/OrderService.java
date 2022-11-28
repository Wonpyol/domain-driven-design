package com.example.service;

import com.example.domain.Delivery;
import com.example.domain.Member;
import com.example.domain.Order;
import com.example.domain.OrderItem;
import com.example.domain.item.Item;
import com.example.repository.ItemRepository;
import com.example.repository.MemberRepository;
import com.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        //엔티티조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);
        //배송정보
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        //주문상품생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        //주문생성
        Order order = Order.createOrder(member, delivery, orderItem);
        //주문저장
        orderRepository.save(order);

        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancelOrder();
    }

    public List<Order> findOrders() {
        return null;
    }


}
