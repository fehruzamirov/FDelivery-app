package com.deliverybusiness.enums;

public enum DayOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String msg;

    DayOfWeek(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
