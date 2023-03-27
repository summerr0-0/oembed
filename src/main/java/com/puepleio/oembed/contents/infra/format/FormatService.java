package com.puepleio.oembed.contents.infra.format;

import com.puepleio.oembed.contents.service.ContentsCommand;
import com.puepleio.oembed.contents.service.ContentsResult;

public interface FormatService {
    ContentsResult getConvertFormat(ContentsCommand command);
}
