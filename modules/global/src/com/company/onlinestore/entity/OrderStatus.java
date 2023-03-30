package com.company.onlinestore.entity;

public enum OrderStatus {
    ACCEPTED("accepted"),
    CONFIRMED("confirmed"),
    PAYMENT_EXCEPTED("paymentExcepted"),
    PAID("paid"),
    AWAITING_SHIPMENT("awaitingShipment"),
    SENT("sent"),
    DELIVERED_PICKUP_POINT("deliveredToPickupPoint"),
    DELIVERED_RECIPIENT("deliveredRecipient"),
    READY_FOR_DELIVERY("readyForDelivery"),
    CANCELED("canceled"),
    COMPLETED("completed");

    private final String val;

    OrderStatus(String val) {
        this.val = val;
    }
}
