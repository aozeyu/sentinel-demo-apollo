package com.github.anilople.sentineldemoapollo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class EchoController {
  private static final Logger logger = LoggerFactory.getLogger(EchoController.class);
  private final ApplicationContext applicationContext;
  public EchoController(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @GetMapping("/echo")
  @SentinelResource(value = "myecho")
  public ResponseEntity<String> echo(@RequestParam String id) {
    logger.info("echo: id = [{}]", id);
    return ResponseEntity.ok(id);
  }

  @PostMapping("/echo/json/object")
  public ResponseEntity<Map<String,String>> echoJsonObject(@RequestBody Map<String,String> map) {
    return ResponseEntity.ok(map);
  }
}
