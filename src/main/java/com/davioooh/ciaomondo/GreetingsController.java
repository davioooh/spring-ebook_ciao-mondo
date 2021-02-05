package com.davioooh.ciaomondo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;

@Controller
@RequestMapping("/")
public class GreetingsController {

  @GetMapping
  public String greetings(Model model) {
    String greetingsMessage = greetingsByTime(LocalTime.now());
    model.addAttribute("message", greetingsMessage);
    return "hello-world";
  }

  public static String greetingsByTime(LocalTime time) {
    String greetings;
    if (time.isBefore(LocalTime.NOON)) {
      greetings = "Buongiorno";
    } else if (time.isBefore(LocalTime.of(18, 0))) {
      greetings = "Buon pomeriggio";
    } else {
      greetings = "Buonasera";
    }
    return greetings + " Mondo!";
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