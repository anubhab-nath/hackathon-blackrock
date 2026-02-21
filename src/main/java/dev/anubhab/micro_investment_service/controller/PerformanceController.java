package dev.anubhab.micro_investment_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class PerformanceController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/performance")
    public ResponseEntity<String> getPerformanceReport() {
        logger.info("Received request for performance report");
        // Simulate some processing time
        try {
            Thread.sleep(2000); // Simulating a delay of 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.severe("Thread was interrupted: " + e.getMessage());
            return ResponseEntity.status(500).body("Internal Server Error");
        }
        logger.info("Returning performance report");
        return ResponseEntity.ok("Performance report generated successfully");
    }
}
