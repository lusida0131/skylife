package org.zerock.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() throws Exception {
      return "page/index";

    }
    @GetMapping("/page/index")
    public String index() throws Exception {
        return "page/index";
    }
    @GetMapping("/page/flight")
    public String flight() throws Exception {
        return "page/flight";
    }
    @GetMapping("/page/hotel")
    public String hotel() throws Exception {
        return "page/hotel";
    }
    @GetMapping("/page/board")
    public String board() throws Exception {
        return "page/board";
    }

	/*
	 * @GetMapping("/page/blog") public String blog() throws Exception { return
	 * "page/blog"; }
	 */
    @GetMapping("/page/public")
    public String pub() throws Exception {
        return "page/public";
    }
}