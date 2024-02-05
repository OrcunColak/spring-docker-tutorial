package com.colak.springdockertutorial.customhealth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Example for a custom indicator that is shown inside /actuator/health
 */
@Component
@Slf4j
public class CustomHealthIndicator implements HealthIndicator {

    // Normal path : http://localhost:8080/actuator/health
    @Override
    public Health health() {
        log.info("health is called");
        if (isConditionMet()) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("reason", "Custom condition not met").build();
        }
    }

    private boolean isConditionMet() {
        // Implement your custom condition check here in our case we may wan to check aws connectivity here.
        // Return true if the condition is met, false otherwise
        return true;
    }
}
