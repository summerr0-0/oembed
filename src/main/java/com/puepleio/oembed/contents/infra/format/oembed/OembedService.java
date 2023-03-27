package com.puepleio.oembed.contents.infra.format.oembed;

import com.puepleio.oembed.contents.infra.format.client.CallClientService;
import com.puepleio.oembed.contents.service.ContentsCommand;
import com.puepleio.oembed.contents.service.ContentsResult;
import com.puepleio.oembed.contents.infra.format.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OembedService implements FormatService {

    private final CallClientService callClientService;

    public ContentsResult getConvertFormat(ContentsCommand command) {
        return callClientService.call(command.getUrl());
    }
}
