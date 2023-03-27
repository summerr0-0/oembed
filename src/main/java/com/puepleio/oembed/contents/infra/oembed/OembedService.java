package com.puepleio.oembed.contents.infra.oembed;

import com.puepleio.oembed.contents.infra.feign.FeignResponseConvert;
import com.puepleio.oembed.contents.infra.feign.TwitterClient;
import com.puepleio.oembed.contents.infra.feign.VimeoClient;
import com.puepleio.oembed.contents.infra.feign.YoutubeClient;
import com.puepleio.oembed.contents.service.ContentsCommand;
import com.puepleio.oembed.contents.service.ContentsResult;
import com.puepleio.oembed.contents.service.ConvertService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OembedService implements ConvertService {
    private final TwitterClient twitterClient;
    private final VimeoClient vimeoClient;
    private final YoutubeClient youtubeClient;

    public ContentsResult getResult(ContentsCommand command) {
        String url = command.getUrl();
        if(url.contains("https://twitter.com")){
            String responseBody = FeignResponseConvert.getResponseBody(twitterClient.status(url));
            return FeignResponseConvert.getResult(responseBody);
        }
        if(url.contains("https://www.youtube.com")) {
            return FeignResponseConvert.getResult(FeignResponseConvert.getResponseBody(youtubeClient.status(url)));
        }
        if(url.contains("https://vimeo.com")){
            return FeignResponseConvert.getResult(FeignResponseConvert.getResponseBody(vimeoClient.status(url)));
        }

        throw new IllegalArgumentException();
    }
}
