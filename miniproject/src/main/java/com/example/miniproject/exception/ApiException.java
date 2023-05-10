package com.example.miniproject.exception;

import com.example.miniproject.config.SentrySupport;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class ApiException extends RuntimeException {
    private ExceptionEnum error;
    private SentrySupport sentrySupport = new SentrySupport();

    public ApiException(ExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
        sentrySupport.logSimpleMessage(error.getMessage());
    }
}
