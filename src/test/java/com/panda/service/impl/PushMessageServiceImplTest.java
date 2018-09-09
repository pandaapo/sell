package com.panda.service.impl;

import com.panda.dto.OrderDTO;
import com.panda.service.OrderService;
import com.panda.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PushMessageService pushMessageService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1534579559247156340");
        pushMessageService.orderStatus(orderDTO);
    }
}