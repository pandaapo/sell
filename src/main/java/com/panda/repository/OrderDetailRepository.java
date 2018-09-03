package com.panda.repository;

import com.panda.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 根据订单id查找订单商品
     * @param ordeId
     * @return
     */
    List<OrderDetail> findByOrderId(String ordeId);
}
