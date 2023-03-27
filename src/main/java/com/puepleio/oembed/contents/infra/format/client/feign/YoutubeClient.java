package com.puepleio.oembed.contents.infra.format.client.feign;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "youtube",url="https://www.youtube.com/oembed")
public interface YoutubeClient {
    //https://www.youtube.com/oembed?url=https://www.youtube.com/watch?v=dBD54EZIrZo&format=json

    @GetMapping("?url={url}")
    Response status(@PathVariable("url") String url);
}
