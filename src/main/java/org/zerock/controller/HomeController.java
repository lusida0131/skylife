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
    
    @GetMapping("/page/map")
    public String map() throws Exception {
        return "page/map";
    }
    @GetMapping("/page/map2")
    public String map2() throws Exception {
        return "page/map2";
    }
    @GetMapping("/page/map3")
    public String map3() throws Exception {
        return "page/map3";
    }
    // 관리자 페이지 이동
    @GetMapping("/auth/anonymous")
    public String admin() {
    	return "auth/anonymous";
    }
    // 관리자 페이지
    @GetMapping("/auth/admin")
    public String admin1() {
    	return "/auth/admin";
    }
  
    //게시판 수정
    @GetMapping("/admin/publicup")
    public String public1() {
    	return "/admin/publicup";
    }
    //댓글 수정
    @GetMapping("/admin/product_list")
    public String product() {
    	return "/admin/product_list";
    }
    
    @GetMapping("/page/public")
    public String pub() throws Exception {
        return "redirect:/pub/public";
    }
    @GetMapping("/page/map4")
    public String map4() throws Exception {
        return "page/map4";
    }
}