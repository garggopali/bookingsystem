package com.gopali.bookingsystem.component;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmailNotifier {
    private final RestTemplate restTemplate = new RestTemplate();

    public void sendEmail(String to, String subject, String body) {

        Map<String, String> emailStructure = Map.of(
                "to", to,
                "subject", subject,
                "body", body

        );

        try {
            restTemplate.postForEntity("https://webhook.site/5eb76038-e418-442a-bcc8-fc8f38af84d4", emailStructure,
                    Void.class);
        } catch (Exception e) {
            System.out.println("Failed to send emaiol " + e.getMessage());
        }
    }
}
