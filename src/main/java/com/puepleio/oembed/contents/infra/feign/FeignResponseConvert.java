package com.puepleio.oembed.contents.infra.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puepleio.oembed.contents.service.ContentsResult;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
public class FeignResponseConvert {
    public static String getResponseBody(Response response) {
        if (response.body() == null) {
            log.info("responseBody is empty");
            return "";
        }
        try (InputStream responseBodyStream = response.body().asInputStream()) {
            return IOUtils.toString(responseBodyStream, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            log.error("responseBody error::{}", response);
            return "";
        }
    }

    public static ContentsResult getResult(String json) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        ContentsResult result = null;
        try {
            result = objectMapper.readValue(json, ContentsResult.class);
        } catch (JsonProcessingException e) {
            log.error("error to parsing", e);
        }
        return result;
    }


    private FeignResponseConvert() {
    }
}