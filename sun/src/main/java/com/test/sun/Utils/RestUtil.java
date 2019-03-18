package com.test.sun.Utils;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import org.json.JSONObject;

import java.util.Map;

public class RestUtil {
    public Map<String, Object> GET(String url){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(1000*3); // ms
        requestFactory.setReadTimeout(1000*3); // ms

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        String p = restTemplate.getForObject(url,String.class);

        return new JSONObject(p).toMap();
    }
}
