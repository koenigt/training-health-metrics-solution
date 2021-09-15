package group.msg.training.devops.metric;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Timed("business.timer")
public class MetricRestController {

    private Counter counter;
    private Random rand = new Random();

    public MetricRestController(MeterRegistry registry){
        counter = Counter.builder("business.counter").baseUnit("Stück").description("ein wichtiger counter").tags("ENV","EMEA",
                                                                                                               "STAGE",
                                                                                                        "TEST").register(registry);
        //counter = registry.counter("business.counter");
    }


    @GetMapping("/api/time")
    public ResponseEntity<?> getTime() {
        internalMethod();
        return ResponseEntity.ok().body("OK: "+ LocalDateTime.now());
    }

    @GetMapping("/api/count")
    public ResponseEntity<?> getCount() {
        internalMethod();
        counter.increment();
        return ResponseEntity.ok().body("OK: "+ LocalDateTime.now());
    }

    @Counted
    private void internalMethod(){
        try {
            Thread.sleep(rand.nextInt(500));
        } catch (InterruptedException e) {
            //nothing to do
        }
    }
}
