package com.davioooh.ciaomondo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GreetingsController {

  @GetMapping
  public String greetings() {
    return "hello-world";
  }

  @GetMapping(params = "req-param")
  public String greetingsWithParam() {
    return "hello-world-params";
  }

  @GetMapping(headers = "req-header=hValue")
  public String greetingsWithHeader() {
    return "hello-world-headers";
  }

}