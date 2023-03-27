package com.puepleio.oembed.contents.infra.format.client.feign;

import feign.Request;
import feign.RequestTemplate;
import feign.Response;

import java.util.HashMap;

public class TwitterClientImpl implements TwitterClient {

    @Override
    public Response status(String url) {
        return Response.builder()
            .status(200)
            .reason("OK")
            .headers(new HashMap<>())
            .request(Request.create(Request.HttpMethod.GET, url,
                new HashMap<>(), Request.Body.create("twitter"), new RequestTemplate()))
            .build();
    }
}