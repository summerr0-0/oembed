package com.puepleio.oembed.contents.service;

import com.puepleio.oembed.contents.infra.format.FormatService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class ContentsServiceTest {

    FormatService formatService;
    ContentsService service;

    @BeforeEach
    void beforeEach() {
        formatService = new FormatServiceImpl();
        service = new ContentsService(formatService);
    }

    @Test
    void 유효하지_않은_URL_이_입력되면_안된다() {
        ContentsCommand wrongCommand = ContentsCommand.of("123");
        assertThatCode(() -> service.convert(wrongCommand))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_URL_이_입력되면_정상동작한다() {
        ContentsCommand wrongCommand = ContentsCommand.of("https://www.naver.com");
        assertThatCode(() -> service.convert(wrongCommand))
            .doesNotThrowAnyException();
    }
}