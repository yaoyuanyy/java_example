package com.yy.rest.sign_verify;

import java.util.Arrays;

public enum SystemErrorCode implements ErrorCode {
    SUCCESS(0, "error.code.sys.success"),
    SYSTEM_ERROR(1, "error.code.sys.error"),
    UNKNOWN_ERROR(-1, "error.code.sys.unknow"),

    BAD_REQUEST(400, "error.code.http.status.400"),
    UNAUTHORIZED(401, "error.code.http.status.401"),
    FORBIDDEN(403, "error.code.http.status.403"),
    NOT_FOUND(404, "error.code.http.status.404"),
    METHOD_NOT_ALLOWED(405, "error.code.http.status.405"),
    UNSUPPORTED_MEDIA_TYPE(415, "error.code.http.status.415"),
    INTERNAL_SERVER_ERROR(500, "error.code.http.status.500");

    private final int code;
    private final String message;

    SystemErrorCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @param code
     * @return
     */
    public static SystemErrorCode valueOf(final int code) {
        return Arrays.stream(values())
                .filter(x -> x.getCode() == code)
                .findFirst()
                .orElse(SystemErrorCode.UNKNOWN_ERROR);
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return LocaleUtils.getMessage(this.message);
    }

    @Override
    public String toString() {
        return "[" + this.getCode() + "]" + this.getMessage();
    }
}
