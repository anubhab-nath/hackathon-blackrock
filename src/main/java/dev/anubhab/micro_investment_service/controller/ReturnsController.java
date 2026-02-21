package dev.anubhab.micro_investment_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class ReturnsController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @PostMapping("/returns:nps")
    public ResponseEntity<String> calculateNPSReturns(@RequestBody String request) {
        logger.info("Calculating NPS returns...");
        // Placeholder for actual NPS return calculation logic
        String npsReturns = "NPS returns calculated successfully.";
        return ResponseEntity.ok(npsReturns);
    }

    @PostMapping("/returns:index")
    public ResponseEntity<String> calculateIndexReturns(@RequestBody String request) {
        logger.info("Calculating index returns...");
        // Placeholder for actual index return calculation logic
        String indexReturns = "Index returns calculated successfully.";
        return ResponseEntity.ok(indexReturns);
    }
}
