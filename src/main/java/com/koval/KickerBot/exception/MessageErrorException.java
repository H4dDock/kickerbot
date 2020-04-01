package com.koval.KickerBot.exception;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MessageErrorException extends ResponseStatusException implements MessageSourceResolvable {
    private final String field;
    private final String[] codes;
    private final Object[] arguments;
    private final String defaultMessage;

    public MessageErrorException(HttpStatus httpStatus, String field, String code) {
        super(httpStatus, field + "." + code);
        this.field = field;
        this.defaultMessage = field + "." + code;
        this.codes = new String[]{defaultMessage};
        this.arguments = null;
    }

    @Override
    public String[] getCodes() {
        return codes;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public String getDefaultMessage() {
        return defaultMessage;
    }
}
