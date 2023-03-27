package com.puepleio.oembed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puepleio.oembed.contents.service.ContentsResult;
import org.junit.jupiter.api.Test;

public class JsonConvertTest {
    @Test
    void json_파싱() throws JsonProcessingException {
//        "{\"name\":\"mkyong\", \"age\":\"37\"}";
        String json =
            "{\"type\": \"video\", " +
                "\"version\": \"1.0\", " +
                "\"provider_name\": \"Vimeo\"," +
                "\"provider_url\": \"https://vimeo.com/\"," +
                "\"title\": \"A Time Artifact - work in progress\" }";

    // jackson objectmapper 객체 생성
    ObjectMapper objectMapper = new ObjectMapper();

    // convert JSON string to Map
    ContentsResult result = objectMapper.readValue(json, ContentsResult.class);

        System.out.println("result.getAuthor_name() = "+result.getProvider_name());
}
}
