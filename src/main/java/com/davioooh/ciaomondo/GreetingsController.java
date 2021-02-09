package com.davioooh.ciaomondo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Controller
@RequestMapping("/")
public class GreetingsController {

  @GetMapping
  public ModelAndView greetings() {
    String greetingsMessage = getGreetingsByTime(LocalTime.now()) + " Mondo!";
    return new ModelAndView("hello-world")
      .addObject("message", greetingsMessage);
  }

  @GetMapping(params = "to")
  public ModelAndView userGreetings(@RequestParam("to") String toUser, @RequestHeader("User-Agent") String userAgent) {
    String greetingsMessage = String.format(
      "%s %s!",
      getGreetingsByTime(LocalTime.now()),
      toUser
    );
    return new ModelAndView("hello-user")
      .addObject("message", greetingsMessage)
      .addObject("userAgent", userAgent);
  }

  public static String getGreetingsByTime(LocalTime time) {
    String greetings;
    if (time.isBefore(LocalTime.NOON)) {
      greetings = "Buongiorno";
    } else if (time.isBefore(LocalTime.of(18, 0))) {
      greetings = "Buon pomeriggio";
    } else {
      greetings = "Buonasera";
    }
    return greetings;
  }

  @GetMapping(params = "req-param")
  public String greetingsWithParam() {
    return "hello-world-params";
  }

  @GetMapping(headers = "req-header=hValue")
  public String greetingsWithHeader() {
    return "hello-world-headers";
  }

  @ModelAttribute("from")
  public String name() {
    return "David";
  }

}