package com.panda.repository;

import com.panda.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("8888");
        orderDetail.setOrderId("111111");
        orderDetail.setProductIcon("www.jianshu.cn");
        orderDetail.setProductId("666");
        orderDetail.setProductName("滚蛋蛋");
        orderDetail.setDetailId("233333");
        orderDetail.setProductPrice(new BigDecimal(88));
        orderDetail.setProductQuantity(3);
        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(orderDetail);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> list = orderDetailRepository.findByOrderId("111111");
        Assert.assertNotEquals(0, list.size());
    }
}