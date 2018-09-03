package com.panda.repository;

import com.panda.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    /**
     * 按照买家openid来查订单，带分页
     * @param openid
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String openid, Pageable pageable);
}
