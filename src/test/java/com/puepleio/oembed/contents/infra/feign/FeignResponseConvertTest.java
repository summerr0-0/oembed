package com.puepleio.oembed.contents.infra.feign;

import com.puepleio.oembed.contents.service.ContentsResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FeignResponseConvertTest {

    @Test
    void json_을_입력받으면_parsing_된다() {
        String json =
            "{\"type\": \"video\", " +
                "\"version\": \"1.0\", " +
                "\"provider_name\": \"Vimeo\"," +
                "\"provider_url\": \"https://vimeo.com/\"," +
                "\"title\": \"A Time Artifact - work in progress\" }";
        ContentsResult result = FeignResponseConvert.getResult(json);

        assertThat(result.getType()).isEqualTo("video");
        assertThat(result.getProvider_name()).isEqualTo("Vimeo");
    }
}