package cn.lifan.service;

import cn.lifan.error.BusinessException;
import cn.lifan.service.model.OrderModel;

public interface OrderService {

    OrderModel createOrder(Integer userId,Integer itemId,Integer amount) throws BusinessException;



}
