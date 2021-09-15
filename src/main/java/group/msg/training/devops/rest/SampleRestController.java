package group.msg.training.devops.rest;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class SampleRestController {
	
	@GetMapping(value="/hello", produces="application/json")
    public String getHelloWorld() {
		return "{\"hello\":\"world\"}";
    }
}
