package com.upc.onlinejudge.client;


import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class SendCode {
    private Logger logger =  LoggerFactory.getLogger(getClass());

    @Value("${judger.path}")
    private String JUDGER_PATH;

    public boolean send(String data) {
        try {
            URI uri = new URI(JUDGER_PATH + "/task");
            System.out.println(JUDGER_PATH);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("task", data);
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, httpHeaders);
            ResponseEntity<String> resp = restTemplate.postForEntity(uri, httpEntity, String.class);
            return resp.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            logger.error(e.toString());
            e.printStackTrace();
            return false;
        }
    }
}
