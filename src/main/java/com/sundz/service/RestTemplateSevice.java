package com.sundz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Sundz
 * @version: V1.0
 * @date: 2020/9/24 17:31
 */
@Service
public class RestTemplateSevice {

    public Map<String, Object> get(){
        RestTemplate template = new RestTemplate();
        String url = "http://192.168.1.8:8080/app/v1/test/202";
        return template.getForObject(url, Map.class,20);
    }
}
