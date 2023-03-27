package com.puepleio.oembed.contents.service;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ContentsResult {
    private String type;
    private float version;
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

//  "title": "언제 어디서나! 핑크퐁 BEST 모음 80분 | 차에서 듣는 동요 | 아기상어, 상어가족 외 70곡 | + 모음집 | 핑크퐁! 인기동요",
//      "author_name": "핑크퐁 (인기 동요・동화)",
//      "author_url": "https://www.youtube.com/@Pinkfong_Korean",
//      "type": "video",
//      "height": 113,
//      "width": 200,
//      "version": "1.0",
//      "provider_name": "YouTube",
//      "provider_url": "https://www.youtube.com/",
//      "thumbnail_height": 360,
//      "thumbnail_width": 480,
//      "thumbnail_url": "https://i.ytimg.com/vi/dBD54EZIrZo/hqdefault.jpg",
//      "html": "<iframe width=\"200\" height=\"113\"

//{
//    "url": "https://twitter.com/hellopolicy/status/867177144815804416",
//    "author_name": "대한민국 정부",
//    "author_url": "https://twitter.com/hellopolicy",
//    "html": "<blockquote class=\"twitter-tweet\" align=\"center\" data-lang=\"en\" data-theme=\"light\"><p lang=\"ko\" dir=\"ltr\">정책요정 폴리씨가 정부 정책을 알기 쉽고 공감할 수 있게 소개해드립니다! 대한민국 정부 대표 채널 &#39;폴리씨&#39; 국민여러분과 소통할 수 있도록 더욱 노력하겠습니다. <a href=\"https://t.co/eXKCjQIFJ2\">pic.twitter.com/eXKCjQIFJ2</a></p>&mdash; 대한민국 정부 (@hellopolicy) <a href=\"https://twitter.com/hellopolicy/status/867177144815804416?ref_src=twsrc%5Etfw\">May 24, 2017</a></blockquote>\n",
//    "width": 550,
//    "height": null,
//    "type": "rich",
//    "cache_age": "3153600000",
//    "provider_name": "Twitter",
//    "provider_url": "https://twitter.com",
//    "version": "1.0"
//    }

//  "type": "video",
//      "version": "1.0",
//      "provider_name": "Vimeo",
//      "provider_url": "https://vimeo.com/",
//      "title": "A Time Artifact - work in progress",
//      "author_name": "Depict_tk",
//      "author_url": "https://vimeo.com/user5346842",
//      "is_plus": "0",
//      "account_type": "basic",
//      "html": "<iframe src=\"https://player.vimeo.com/video/20097015?h=08095da358&amp;app_id=122963\" width=\"640\" height=\"480\" frameborder=\"0\" allow=\"autoplay; fullscreen; picture-in-picture\" allowfullscreen title=\"A Time Artifact - work in progress\"></iframe>",
//      "width": 640,
//      "height": 480,
//      "duration": 314,
//      "description": "concepts: playzoo\ncodes: purpleworks\n\nopenFrameworks (Linux) / Logitech HD webcam / Turntable",
//      "thumbnail_url": "https://i.vimeocdn.com/video/128068226-3e88e664fc0805498112c738d3a44fe6319a6385f63e3a2af526b35440a15ed5-d_640",
//      "thumbnail_width": 640,
//      "thumbnail_height": 480,
//      "thumbnail_url_with_play_button": "https://i.vimeocdn.com/filter/overlay?src0=https%3A%2F%2Fi.vimeocdn.com%2Fvideo%2F128068226-3e88e664fc0805498112c738d3a44fe6319a6385f63e3a2af526b35440a15ed5-d_640&src1=http%3A%2F%2Ff.vimeocdn.com%2Fp%2Fimages%2Fcrawler_play.png",
//      "upload_date": "2011-02-18 05:31:51",
//      "video_id": 20097015,
//      "uri": "/videos/20097015"
//      }