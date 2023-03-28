package com.puepleio.oembed.contents.controller;

import com.puepleio.oembed.contents.service.ContentsCommand;
import com.puepleio.oembed.contents.service.ContentsResult;
import com.puepleio.oembed.contents.service.ContentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller()
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class ContentsController {

    private final ContentsService service;

    @GetMapping
    public String root(){
        return "index";
    }

    @GetMapping("/data")
    public String getContents(@RequestParam("url") String url, Model model){
        ContentsResult convert = service.convert(ContentsCommand.of(url));
        model.addAttribute("convert", convert);
        return "result";
    }
}
