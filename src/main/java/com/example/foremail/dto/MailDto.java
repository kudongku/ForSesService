package com.example.foremail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MailDto {

    private String title;
    private String content;
    private String receiver;
}
