package com.puepleio.oembed.contents.infra.format.client.feign;

import com.puepleio.oembed.contents.infra.format.client.CallClientService;
import com.puepleio.oembed.contents.service.ContentsResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignService implements CallClientService {
    private final TwitterClient twitterClient;
    private final VimeoClient vimeoClient;
    private final YoutubeClient youtubeClient;

    @Override
    public ContentsResult call(String url) {
        if (url.contains("https://twitter.com")) {
            String responseBody = FeignResponseConvert.getResponseBody(twitterClient.status(url));
            return FeignResponseConvert.getResult(responseBody);
        }
        if (url.contains("https://www.youtube.com")) {
            return FeignResponseConvert.getResult(FeignResponseConvert.getResponseBody(youtubeClient.status(url)));
        }
        if (url.contains("https://vimeo.com")) {
            return FeignResponseConvert.getResult(FeignResponseConvert.getResponseBody(vimeoClient.status(url)));
        }
        throw new IllegalArgumentException("유효한 서비스가 아닙니다 :: twitter, youtube, vimeo만 요청해주세요");
    }
}
