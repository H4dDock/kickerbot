package com.koval.KickerBot.util;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public class BaseControllerUtils {
    public static URI uri(String uriString, Map<String, Object> pathParams) {
        return UriComponentsBuilder.fromUriString(uriString).build(pathParams);
    }
}
