package com.company.onlinestore.service;

import com.company.onlinestore.entity.OnlineOrder;


public interface OrderStatusService {
    String NAME = "onlinestore_OrderStatusService";

    void setStatus(OnlineOrder onlineOrder, String status);
}