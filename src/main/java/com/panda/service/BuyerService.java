package com.panda.service;

import com.panda.dto.OrderDTO;

/**
 * 买家service
 */
public interface BuyerService {

    //查询一个订单
    public OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    public OrderDTO cancelOrder(String openid, String orderId);
}
