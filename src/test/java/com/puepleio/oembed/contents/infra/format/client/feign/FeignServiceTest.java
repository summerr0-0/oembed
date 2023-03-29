package com.puepleio.oembed.contents.infra.format.client.feign;

import com.puepleio.oembed.contents.service.ContentsResult;
import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FeignServiceTest {
    @InjectMocks
    FeignService service;

    @Mock
    FeignResponseConvert convert;
    @Mock
    TwitterClient twitterClient;
    @Mock
    VimeoClient vimeoClient;
    @Mock
    YoutubeClient youtubeClient;

    @Test
    void 유효하지_않은_값이_들어오면_익셉션_발생() {
        assertThatCode(() -> service.call("123"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 트위터로_요청하면_트위터_클라이언트가_동작() {
        //given
        given(twitterClient.status("https://twitter.com/123"))
            .willReturn(
                Response.builder()
                    .status(200)
                    .reason("OK")
                    .headers(new HashMap<>())
                    .request(Request.create(Request.HttpMethod.GET, "https://twitter.com/123",
                        new HashMap<>(), Request.Body.create(""), new RequestTemplate()))
                    .build());

        given(convert.getResponseBody(any())).willReturn(new ContentsResult());

        //when
        assertThatCode(() -> service.call("https://twitter.com/123"))
            .doesNotThrowAnyException();

        //then
        then(twitterClient).should(times(1)).status(any());
        then(youtubeClient).shouldHaveNoInteractions();
        then(vimeoClient).shouldHaveNoInteractions();

    }

    @Test
    void 유튜브로_요청하면_유튜브_클라이언트가_동작() {
        //given
        given(youtubeClient.status("https://www.youtube.com/123"))
            .willReturn(
                Response.builder()
                    .status(200)
                    .reason("OK")
                    .headers(new HashMap<>())
                    .request(Request.create(Request.HttpMethod.GET, "https://www.youtube..com/123",
                        new HashMap<>(), Request.Body.create(""), new RequestTemplate()))
                    .build());

        given(convert.getResponseBody(any())).willReturn(new ContentsResult());

        //when
        assertThatCode(() -> service.call("https://www.youtube.com/123"))
            .doesNotThrowAnyException();

        //then
        then(youtubeClient).should(times(1)).status(any());
        then(twitterClient).shouldHaveNoInteractions();
        then(vimeoClient).shouldHaveNoInteractions();

    }

    @Test
    void 비메오로_요청하면_유튜브_클라이언트가_동작() {
        //given
        given(vimeoClient.status("https://vimeo.com/123"))
            .willReturn(
                Response.builder()
                    .status(200)
                    .reason("OK")
                    .headers(new HashMap<>())
                    .request(Request.create(Request.HttpMethod.GET, "https://vimeo.com/123",
                        new HashMap<>(), Request.Body.create(""), new RequestTemplate()))
                    .build());

        given(convert.getResponseBody(any())).willReturn(new ContentsResult());

        //when
        assertThatCode(() -> service.call("https://vimeo.com/123"))
            .doesNotThrowAnyException();

        //then
        then(vimeoClient).should(times(1)).status(any());
        then(twitterClient).shouldHaveNoInteractions();
        then(youtubeClient).shouldHaveNoInteractions();

    }
}

