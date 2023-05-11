package com.example.miniproject.config;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SentrySupport {

    public SentrySupport() {
        log.info("================================ SentrySupport init()");
        Sentry.init("https://ca8e476b98e0475cb81cc10a056c6b0d@o4505156849500160.ingest.sentry.io/4505156854284288");
    }

    public void logSimpleMessage(String msg) {
        EventBuilder eventBuilder = new EventBuilder()
                .withMessage(msg)
                .withLevel(Event.Level.ERROR);
//        추가적인 로그정보 확인코드
//                .withLogger(SentrySupport.class.getName());
        Sentry.capture(eventBuilder);
    }
}