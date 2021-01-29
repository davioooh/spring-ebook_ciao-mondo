package com.davioooh.ciaomondo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingsController {

  @RequestMapping("/")
  public String greetings() {
    return "hello-world";
  }

}