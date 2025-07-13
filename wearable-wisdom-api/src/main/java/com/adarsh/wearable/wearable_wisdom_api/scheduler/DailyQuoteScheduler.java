package com.adarsh.wearable.wearable_wisdom_api.scheduler;

import com.adarsh.wearable.wearable_wisdom_api.services.WearableWisdomService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyQuoteScheduler {

    private final WearableWisdomService service;

    public DailyQuoteScheduler(WearableWisdomService service) {
        this.service = service;
    }

    // every midnight
    @Scheduled(cron = "0 0 0 * * *")
    public void rotateDaily() {
        service.rotateDailyQuote();
    }
}
