package com.example.demo.exception;

public enum DiamondEnum implements Errors {
    DIAMOND_TIMEOUT(1);

    private final Integer code;

    DiamondEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getErrorCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name();
    }
}
