package com.panda.service;

import com.panda.dataobject.SellerInfo;
import org.springframework.stereotype.Service;

/**
 * 卖家端
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
