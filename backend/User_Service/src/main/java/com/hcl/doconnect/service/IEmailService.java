package com.hcl.doconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IEmailService {

	String sendMail(List<String> emails);
}
