package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() throws Exception {
      return "/fs/flight";

    }
    @GetMapping("/page/index")
    public String index() throws Exception {
        return "/fs/flight";
    }
    @GetMapping("/auth/index")
    public String index1() throws Exception {
        return "/fs/flight";
    }
    
    @GetMapping("/page/flight")
    public String flight() throws Exception {
        return "fs/flight";
    }
    
    @GetMapping("/Park/park")
    public String park() throws Exception {
        return "Park/park";
    }
    
    @GetMapping("/map/map")
    public String map() throws Exception {
        return "map/map";
    }
    @GetMapping("/map/map2")
    public String map2() throws Exception {
        return "map/map2";
    }

    @GetMapping("/page/public")
    public String pub() throws Exception {
        return "redirect:/pub/public";
    }
 }