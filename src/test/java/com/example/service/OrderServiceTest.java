package com.example.service;

import com.example.domain.Address;
import com.example.domain.Member;
import com.example.domain.Order;
import com.example.domain.item.Book;
import com.example.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class OrderServiceTest {
    @Autowired
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    @Rollback(value = false)
    void 상품주문() {
        //given
        Member member = Member.builder().name("회원").address(new Address("서울", "2길", "123-123")).build();
        em.persist(member);

        Book book = new Book();
        book.setName("DDD");
        book.setPrice(1000);
        book.setStockQuantity(10);
        em.persist(book);
        //when
        Long orderId = orderService.order(member.getId(), book.getId(), 10);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        Assertions.assertEquals(getOrder.getTotalPrice(), 10000);

    }

}