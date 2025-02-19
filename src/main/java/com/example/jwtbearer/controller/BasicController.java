package com.example.jwtbearer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class BasicController {

    @GetMapping("/demo")
    String logoutSuccess() {
        log.info("");
        log.info("");
        log.info("");
        log.info("");
        log.info("  Secured endpoint  !");
        log.info("");
        log.info("");
        log.info("");
        return "Demo-secured";
    }
}
