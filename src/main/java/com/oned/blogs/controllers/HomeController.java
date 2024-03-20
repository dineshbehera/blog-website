package com.oned.blogs.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	
    Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    @Value("${message: default message}")
    private String msg;

    @GetMapping({"test", "/test"})
	public String home(HttpServletRequest request) {
		LOGGER.info(request.getRequestURL() +" is called !");
		return request.getRequestURL() +" is called !"+ " Message : "+ msg;
	}

}
