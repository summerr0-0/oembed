package com.puepleio.oembed.contents.service;

import com.puepleio.oembed.contents.infra.format.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ContentsService {
    private final FormatService formatService;

    public ContentsResult convert(ContentsCommand command){
        if(!command.getUrl().contains("https://")){
            throw new IllegalArgumentException("유효하지 않은 Url입니다");
        }
        return formatService.getConvertFormat(command);
    }
}
