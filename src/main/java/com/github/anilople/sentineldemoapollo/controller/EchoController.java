package com.github.anilople.sentineldemoapollo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
  private static final Logger logger = LoggerFactory.getLogger(EchoController.class);

  @GetMapping("/echo")
  public ResponseEntity<String> echo(@RequestParam String id) {
    logger.info("echo: id = [{}]", id);
    return ResponseEntity.ok(id);
  }
}
