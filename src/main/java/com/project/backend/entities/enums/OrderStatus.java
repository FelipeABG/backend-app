package com.project.backend.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(0),
    PAID(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    //Attributes
    private final Integer code;

    //Builder
    private OrderStatus (Integer code){
        this.code = code;
    }

    //Methods
    public Integer getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){
        for (OrderStatus o : OrderStatus.values()){
            if (o.getCode() == code){
                return o;
            }
        }
        throw new IndexOutOfBoundsException("This enum does not exist");
    }
}
