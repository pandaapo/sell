package com.panda.service;

/**
 * 秒杀
 */
public interface SecKillService {

    public String querySecKillProductInfo(String productId);

    public void orderProductMockDiffUser(String productId);
}
