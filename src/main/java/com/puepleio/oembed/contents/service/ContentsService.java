package com.puepleio.oembed.contents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ContentsService {
    private final ConvertService convertService;

    public ContentsResult convert(ContentsCommand command){
        ContentsResult result = convertService.getResult(command);
        return result;
    }
}
