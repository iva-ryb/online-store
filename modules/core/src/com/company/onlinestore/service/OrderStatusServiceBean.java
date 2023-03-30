package com.company.onlinestore.service;

import com.company.onlinestore.entity.OnlineOrder;
import com.company.onlinestore.entity.OrderStatus;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(OrderStatusService.NAME)
public class OrderStatusServiceBean implements OrderStatusService {

    @Inject
    private DataManager dataManager;

    @Override
    public void setStatus(OnlineOrder onlineOrder, String status) {
        switch (status) {
            case ("accepted"):
                onlineOrder.setStatus(OrderStatus.ACCEPTED.name());
                break;
            case ("confirmed"):
                onlineOrder.setStatus(OrderStatus.CONFIRMED.name());
                break;
            case ("paymentExcepted"):
                onlineOrder.setStatus(OrderStatus.PAYMENT_EXCEPTED.name());
                break;
            case ("paid"):
                onlineOrder.setStatus(OrderStatus.PAID.name());
                break;
            case ("awaitingShipment"):
                onlineOrder.setStatus(OrderStatus.AWAITING_SHIPMENT.name());
                break;
            case ("sent"):
                onlineOrder.setStatus(OrderStatus.SENT.name());
                break;
            case ("deliveredPickupPoint"):
                onlineOrder.setStatus(OrderStatus.DELIVERED_PICKUP_POINT.name());
                break;
            case ("deliveredRecipient"):
                onlineOrder.setStatus(OrderStatus.DELIVERED_RECIPIENT.name());
                break;
            case ("readyForDelivery"):
                onlineOrder.setStatus(OrderStatus.READY_FOR_DELIVERY.name());
                break;
            case ("canceled"):
                onlineOrder.setStatus(OrderStatus.CANCELED.name());
                break;
            case ("completed"):
                onlineOrder.setStatus(OrderStatus.COMPLETED.name());
                break;
        }
        dataManager.commit(onlineOrder);
    }
}