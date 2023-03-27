package com.puepleio.oembed.contents.infra.format.client.feign;

import feign.Param;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "vimeo",url="https://vimeo.com/api/oembed.json")
public interface VimeoClient {
    //https://vimeo.com/api/oembed.json?url=https://vimeo.com/20097015

    @GetMapping("?url={url}")
    Response status(@PathVariable("url") String url);
}
