package com.puepleio.oembed.contents.service;

import com.puepleio.oembed.contents.infra.feign.FeignResponseConvert;
import com.puepleio.oembed.contents.infra.feign.YoutubeClient;
import org.springframework.stereotype.Component;


public class YoutubeCall implements CallInter{
    private final YoutubeClient youtubeClient;

    public YoutubeCall(YoutubeClient youtubeClient) {
        this.youtubeClient = youtubeClient;
    }

    @Override
    public ContentsResult callSns(String url) {
        return null;
    }
}
