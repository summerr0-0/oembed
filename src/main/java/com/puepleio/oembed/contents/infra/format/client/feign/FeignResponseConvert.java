package com.puepleio.oembed.contents.infra.format.client.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puepleio.oembed.contents.service.ContentsResult;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class FeignResponseConvert {
    public ContentsResult getResponseBody(Response response) {
        String json = "";
        if (response.body() == null) {
            log.info("responseBody is empty");
            return new ContentsResult();
        }
        try (InputStream responseBodyStream = response.body().asInputStream()) {
            json = IOUtils.toString(responseBodyStream, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            log.error("responseBody error::{}", response);
            return new ContentsResult();
        }

        return getResult(json);
    }

    private ContentsResult getResult(String json) {
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
