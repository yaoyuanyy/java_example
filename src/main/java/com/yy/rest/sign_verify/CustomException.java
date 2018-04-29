package com.yy.rest.sign_verify;

import lombok.Getter;

@Getter
public class CustomException extends SkylerException {
    private int code;
    private String debugMessage = "Exception";

    public CustomException() {
        super();
    }

    public CustomException(final ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }

    public CustomException(final ErrorCodeEnum errorCodeEnum, final String debugMessage) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
        this.debugMessage = debugMessage;
    }

    public CustomException(final ErrorCodeEnum errorCodeEnum, final String debugMessageFormat,
                           final Object... args) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
        this.debugMessage = String.format(debugMessageFormat, args);
    }

    public CustomException(final ErrorCodeEnum errorCodeEnum, final Throwable cause) {
        super(errorCodeEnum.getMessage(), cause);
    }
}
