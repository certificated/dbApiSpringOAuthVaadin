package com.example.application.data.service;

import com.example.application.AppProperties;
import com.example.application.data.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CreditcardService {
    @Autowired
    AppProperties appProperties;

    public List<Creditcard> getCreditcards(String accessToken)
    {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = appProperties.getDbApiCreditcards();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<Creditcards> response = restTemplate.exchange(
                resourceUrl,
                HttpMethod.GET,
                request,
                Creditcards.class
        );

        Creditcards creditcards = response.getBody();

        return creditcards.getItems();


    }

}
