package org.zerock.controller;

import java.util.Random;
import java.util.HashMap;
import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.skylifeVO;
import org.zerock.service.KakaoAPI;
import org.zerock.service.skylifeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping
@AllArgsConstructor
public class skylifeJoinController {
	
	@Autowired
	private JavaMailSender mailSender;	// 硫붿씪 �꽌鍮꾩뒪瑜� �궗�슜�븯湲� �쐞�빐 �쓽議댁꽦�쓣 二쇱엯�븿.
	
	private skylifeService service;
	private KakaoAPI kakao;
	
	//濡쒓퉭�쓣 �쐞�븳 蹂��닔
	private static final Logger logger= 
	LoggerFactory.getLogger(skylifeJoinController.class);
	private static final String String = null;
	
	@GetMapping("/auth/loginForm")
	public String login() {
		return "/auth/loginForm";
	}

	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return"/auth/joinForm";
	}
	
	@PostMapping("/auth/joinForm")
	public String joinForm(skylifeVO skylifevo,RedirectAttributes redirectAttributes) {
		String hashedPw = BCrypt.hashpw(skylifevo.getPw(), BCrypt.gensalt()); 
		skylifevo.setPw(hashedPw); 
		service.register(skylifevo); 
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");

		return "redirect:/auth/loginForm";
	}
	
	@PostMapping("/auth/loginForm")
	public String loginForm(HttpSession session, skylifeVO skylifevo, Model model ) throws Exception {
		skylifeVO user = service.Login(skylifevo);
		if(user!=null&&BCrypt.checkpw(skylifevo.getPw(), user.getPw())) {
			session.setAttribute("user", user);
			
			return "redirect:/";
		}
		else {
	
			
			return "redirect:/auth/loginForm";
		}
	}
	// 濡쒓렇�븘�썐
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	//카카占쏙옙 占싸깍옙占쏙옙 占쌀띰옙 占쏙옙占�
	@RequestMapping(value="/auth/loginForm")
	public String login(@RequestParam("code") String code, HttpSession session) {
	    String access_Token = kakao.getAccessToken(code);
	    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    System.out.println("login Controller : " + userInfo);
	    
	    //    클占쏙옙占싱억옙트占쏙옙 占싱몌옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占실울옙 占쌔댐옙 占싱몌옙占싹곤옙 占쏙옙큰 占쏙옙占�
	    if (userInfo.get("email") != null) {
	        session.setAttribute("userId", userInfo.get("email"));
	        session.setAttribute("access_Token", access_Token);
	    }
	    return "redirect:/page/index";
	}
	
	@RequestMapping(value = "/idCheck",method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		int result=service.idCheck(id);
		return Integer.toString(result);
	}
	
	@RequestMapping(value="/auth/index")
	public String index() {
	    System.out.println("auth/index : ");
	    return "page/index";
	}
	

// �씠硫붿씪 �씤利�
	@RequestMapping(value="/auth/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {
		/* 酉�(view)濡쒕��꽣 �꽆�뼱�삩 �뜲�씠�꽣 �솗�씤 */
		logger.info("�씠硫붿씪 �뜲�씠�꽣 �쟾�넚 �솗�씤");
		logger.info("�씤利앸찓�씪 : " + email);

		/* �씤利앸쾲�샇 (�궃�닔) �깮�꽦*/
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("�씤利앸쾲�샇 " + checkNum);

		/* �씠硫붿씪 蹂대궡湲� */
		String setFrom = "SkyLifeKorea@gmail.com";
		String toMail = email;
		String title = "�쉶�썝媛��엯 �씤利� �씠硫붿씪 �엯�땲�떎.";
		String content =
						"�솃�럹�씠吏�瑜� 諛⑸Ц�빐二쇱뀛�꽌 媛먯궗�빀�땲�떎." +
						"<br><br>" + 
						"�씤利� 踰덊샇�뒗 " + checkNum + "�엯�땲�떎." +
						"<br>" +
						"�빐�떦 �씤利앸쾲�샇瑜� �씤利앸쾲�샇 �솗�씤移몄뿉 湲곗엯�븯�뿬 二쇱꽭�슂.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);;
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);

		return num;
	}
}
