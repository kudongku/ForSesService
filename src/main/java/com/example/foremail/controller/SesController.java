package com.example.foremail.controller;

import com.example.foremail.dto.MailDto;
import com.example.foremail.service.SesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SesController {

    private final SesService sesService;

    @GetMapping("{title}/{content}/{receiver}")
    public void sendEmail(
        @PathVariable String content,
        @PathVariable String receiver,
        @PathVariable String title
    ){
        sesService.send(new MailDto(title, content, receiver));
    }
}
