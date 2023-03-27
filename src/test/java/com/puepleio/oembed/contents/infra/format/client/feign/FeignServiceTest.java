package com.puepleio.oembed.contents.infra.format.client.feign;

import feign.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FeignServiceTest {

    FeignService service;
    TwitterClient twitterClient;
    VimeoClient vimeoClient;
    YoutubeClient youtubeClient;

    @BeforeEach
    void beforeEach() {
        this.twitterClient = new TwitterClientImpl();
        this.vimeoClient = new VimeoClientImpl();
        this.youtubeClient = new YoutubeClientImpl();

        this.service = new FeignService(twitterClient,vimeoClient,youtubeClient);
    }

    @Test
    void 유효하지_않은_값이_들어오면_익셉션_발생() {
        assertThatCode(() -> service.call("123"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_값이_들어오면_성공() {
        assertThatCode(() -> service.call("https://twitter.com/123"))
            .doesNotThrowAnyException();
        assertThatCode(() -> service.call("https://www.youtube.com/123"))
            .doesNotThrowAnyException();
        assertThatCode(() -> service.call("https://vimeo.com/123"))
            .doesNotThrowAnyException();


    }
}