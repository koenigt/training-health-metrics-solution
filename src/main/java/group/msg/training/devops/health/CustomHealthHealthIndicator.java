package group.msg.training.devops.health;

import java.util.Random;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthHealthIndicator implements HealthIndicator {

    Random rand = new Random();

    @Override
    public Health health() {
        Health.Builder builder;
        if(rand.nextBoolean()){
            builder = Health.up();
        } else {
            builder = Health.down();
        }
        return builder.withDetail("counter_01", 17).withDetail("counter_02", 23771).build();
    }
}
