package com.puepleio.oembed.contents.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ContentsResult {
    private String type;
    private double version;
    private String provider_name;
    private String author_url;
    private String provider_url;
    private String title;
    private String author_name;
    private String is_plus;
    private String html;
    private String width;
    private String height;
    private String duration;
    private String description;
    private String thumbnail_url;
    private String thumbnail_width;
    private String thumbnail_height;
    private String thumbnail_url_with_play_button;
    private String upload_date;
    private String video_id;
    private String uri;
    private String account_type;

}
