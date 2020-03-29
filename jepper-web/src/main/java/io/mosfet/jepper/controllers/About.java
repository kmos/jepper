package io.mosfet.jepper.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created with love. User: mosfet Date: 16/03/20 github: kmos twitter: nmosf */
@RestController
@RequestMapping("/api")
public class About {

  @GetMapping("/about")
  public String about() {
    return "hello!";
  }
}
