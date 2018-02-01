package com.program.tutorcommon.enums;

/**
 * @author Li on 2018/2/1.
 */
public enum StateEnum {
    SUCCESS(200),WARN(400),ERROR(500);

    private int state;

    StateEnum(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
