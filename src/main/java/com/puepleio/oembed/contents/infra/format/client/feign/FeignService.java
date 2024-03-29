package com.puepleio.oembed.contents.infra.format.client.feign;

import com.puepleio.oembed.contents.infra.format.client.CallClientService;
import com.puepleio.oembed.contents.service.ContentsResult;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignService implements CallClientService {
    private final FeignResponseConvert convert;
    private final TwitterClient twitterClient;
    private final VimeoClient vimeoClient;
    private final YoutubeClient youtubeClient;

    @Override
    public ContentsResult call(String url) {
        Response responseBody = null;
        if (url.contains("https://twitter.com")) {
            responseBody = twitterClient.status(url);

        } else if (url.contains("https://www.youtube.com")) {
            responseBody = youtubeClient.status(url);

        } else if (url.contains("https://vimeo.com")) {
            responseBody = vimeoClient.status(url);

        } else throw new IllegalArgumentException("유효한 서비스가 아닙니다 :: twitter, youtube, vimeo만 요청해주세요");

        return convert.getResponseBody(responseBody);
    }
}
