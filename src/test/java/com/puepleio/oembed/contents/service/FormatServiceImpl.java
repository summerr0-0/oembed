package com.puepleio.oembed.contents.service;

import com.puepleio.oembed.contents.infra.format.FormatService;

public class FormatServiceImpl implements FormatService {

    @Override
    public ContentsResult getConvertFormat(ContentsCommand command) {
        return new ContentsResult(
            "type",
            1.0,
            "provider_name",
            "author_url",
            "provider_url",
            "title",
            "author_name",
            "is_plus",
            "html",
            "width",
            "height",
            "duration",
            "description",
            "thumbnail_url",
            "thumbnail_width",
            "thumbnail_height",
            "thumbnail_url_with_play_button",
            "upload_date",
            "video_id",
            "uri",
            "account_type"
        );
    }
}
