package com.example.foremail.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.example.foremail.dto.MailDto;
import com.example.foremail.util.MailUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SesService{
    private final AmazonSimpleEmailService amazonSimpleEmailService;
    public void send(MailDto mailDto) {
        try {
            SendRawEmailRequest sendRawEmailRequest = MailUtil.getSendRawEmailRequest(mailDto.getTitle(), mailDto.getContent(), mailDto.getReceiver());
            amazonSimpleEmailService.sendRawEmail(sendRawEmailRequest);

        }catch (Exception e){
            System.out.println("Email Failed");
            System.err.println("Error message: " + e.getMessage());
        }
    }
}

