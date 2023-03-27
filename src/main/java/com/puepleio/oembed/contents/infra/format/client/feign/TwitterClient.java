package com.puepleio.oembed.contents.infra.format.client.feign;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "twitter",url="https://publish.twitter.com/oembed")
public interface TwitterClient {
    //https://publish.twitter.com/oembed?url=https://twitter.com/hellopolicy/status/867177144815804416

    @GetMapping("?url={url}")
    Response status(@PathVariable("url") String url);
}
