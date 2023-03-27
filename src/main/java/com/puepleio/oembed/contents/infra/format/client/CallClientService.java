package com.puepleio.oembed.contents.infra.format.client;

import com.puepleio.oembed.contents.service.ContentsResult;
import org.springframework.stereotype.Service;

public interface CallClientService {
    ContentsResult call(String url);
}
