package com.puepleio.oembed.contents.service;

import lombok.Getter;

@Getter
public class ContentsCommand {
    private String url = "";

    public static ContentsCommand of(String url) {
        return new ContentsCommand(url);
    }

    private ContentsCommand(String url) {
        this.url = url;
    }
}
