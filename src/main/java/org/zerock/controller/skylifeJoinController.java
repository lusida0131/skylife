package org.zerock.controller;


import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.pay.domain.OrderVO;
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
import org.zerock.mapper.OrderMapper;
import org.zerock.mapper.skylifeMapper;
import org.zerock.service.KakaoAPI;
import org.zerock.service.KakaoService;
import org.zerock.service.skylifeService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping
@AllArgsConstructor
@Log4j
public class skylifeJoinController {
	
	@Setter(onMethod_ = { @Autowired })
	private OrderMapper om;
	@Autowired
	private JavaMailSender mailSender;
	@Inject
	private skylifeService service;
	private KakaoAPI kakao;

	@Autowired
	private KakaoService kakaoService;
	@Autowired
	private skylifeMapper skylifeMapper;

	
	private static final Logger logger = LoggerFactory.getLogger(skylifeJoinController.class);
	private static final String String = null;

	
	
	// 약관동의 폼
	@GetMapping("/auth/joinAgree")
	public String joinAgree() {
		return "/auth/joinAgree";
	}
	
	// 회원 가입 폼
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "/auth/joinForm";
	}
	// 회원 가입 폼
	@PostMapping("/auth/joinForm")
	public String joinForm(skylifeVO skylifevo, RedirectAttributes redirectAttributes) {
		String hashedPw = BCrypt.hashpw(skylifevo.getPw(), BCrypt.gensalt());
		skylifevo.setPw(hashedPw);
		service.register(skylifevo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");

		return "redirect:/auth/loginForm";
	}
	
	// 로그인 폼
	@GetMapping("/auth/loginForm")
	public String login() {
		return "/auth/loginForm";
	}
	// 로그인 폼
	@PostMapping("/auth/loginForm")
	public String loginForm(HttpSession session, skylifeVO skylifevo, Model model) throws Exception {
		skylifeVO user = service.Login(skylifevo);
		if (user != null && BCrypt.checkpw(skylifevo.getPw(), user.getPw())) {
			session.setAttribute("user", user);

			return "redirect:/";
		} else {
			return "redirect:/auth/loginForm";
		}
	}
	
	// 로그아웃 
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
    	log.info("logout user: " + session.getAttribute("user"));
		session.invalidate();

		return "redirect:/";
	}

	// 카카오 로그인 폼
	@RequestMapping(value = "/auth/loginForm")
	public String login(@RequestParam("code") String code, HttpSession session) {
		String access_Token = kakao.getAccessToken(code);
		HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
		System.out.println("login Controller : " + userInfo);
		
		// 클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
		if (userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			
			session.setAttribute("access_Token", access_Token);
			
			log.info(userInfo.get("email"));
		}
		return "redirect:/";
	}

	// 아이디 중복 체크
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {

		String id = request.getParameter("id");
		int result = service.idCheck(id);
		return Integer.toString(result);
	}

	/****************** 이메일 중복체크 ***********************/
	@RequestMapping(value = "/emailhave", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String emailhave(HttpServletRequest request) {

		String email = request.getParameter("email");
		int result = service.emailhave(email);
		return Integer.toString(result);
	}
 
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("auth/index : ");
		return "/";
	}

	// 회원 가입 이메일 전송
	@RequestMapping(value = "/auth/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {
		/* 난수 생성 */
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호" + checkNum);

		/* 메일 보내기 */
		String setFrom = "SkyLifeKorea@gmail.com";
		String toMail = email;
		String title = "회원가입 인증메일입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			;
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);

		return num;
	}

	////////////////////////////////////////////////////////
	// 회원 목록
	@RequestMapping(value = "/page/memView", method = RequestMethod.GET)
	public String memView() throws Exception {
		return "/page/memView";
	}

	// 회원 수정폼
	@RequestMapping(value = "/page/memUpdate", method = RequestMethod.GET)
	public String memUpdateView() throws Exception {
		return "/page/memUpdate";
	}

	// 회원 수정 기능
	@RequestMapping(value = "/memUpdate", method = RequestMethod.POST)
	public String memUpdate(skylifeVO vo, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		String hashedPw = BCrypt.hashpw(vo.getPw(), BCrypt.gensalt());
		vo.setPw(hashedPw);
		service.memUpdate(vo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");

		session.invalidate();

		return "redirect:/";
	}
	
	// 회원 탈퇴
	@GetMapping("/memRemove")
	public String remove1(@RequestParam("id") String id, HttpSession session, RedirectAttributes rttr) {
		log.info("remove..." + id);
		if (service.remove(id)) {
			rttr.addFlashAttribute("result", "success");
		} else {
			System.out.println("remove failed");
		}
		session.invalidate();
		return "redirect:/";
	}

	///////////////////////////////////////////////////////////
	// 아이디/비밀번호 찾기
	@GetMapping("/page/findPw")
	public String findPw() throws Exception {
		return "/page/findPw";
	}

	// 임시 비밀번호 전송 폼
	@RequestMapping(value = "page/emailPW", method = RequestMethod.GET)
	@ResponseBody
	public String FindEmail(String email, skylifeVO vo, RedirectAttributes redirectAttributes) throws Exception {
		/* 난수 생성 */
		Random random = new Random();
		int newPW = random.nextInt(888888) + 111111;
		logger.info("임시 비밀번호" + newPW);

		/* 메일 보내기 */
		String setFrom = "SkyLifeKorea@gmail.com";
		String toMail = email;
		String title = "[SkyLife] 비밀번호변경 인증 이메일 입니다";
		String content = "안녕하세요. 회원님 홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "임시 비밀번호는 " + newPW + "입니다." + "<br>"
				+ "해당 임시번호로 인증번호 로그인하여 비밀번호를 변경해주세요.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			;
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String nPass = Integer.toString(newPW);
		/////////////////////// 비밀번호 변경//////////////////////////
		log.info("임시 비밀번호로 변경");
		String changePW = BCrypt.hashpw(nPass, BCrypt.gensalt());
		vo.setPw(changePW);
		service.updatePW(vo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");
		///////////////////////////////////////////////////////////
		return nPass;
	}

	// 아이디 찾기
	@GetMapping("/page/findID")
	public String findID() throws Exception {
		return "/page/findID";
	}

	// 아이디 찾기
	@PostMapping("/page/getID")
	public String getID(HttpServletResponse response, @RequestParam("email") String email, Model md) throws Exception {
		md.addAttribute("id", service.findID(response, email));
		return "/page/getID";
	}

	// 관리회원 목록
	@GetMapping("/admin/member_list")
	public String boardList(skylifeVO mvo, Model model) {
		log.info("call board list");
		List<skylifeVO> list = service.list(mvo);
		model.addAttribute("list", list);

		return "/admin/member_list";
	}

	// 회원 매출 조회
	@GetMapping("/admin/money_list")
	public String paymentList(HttpSession session, Model model) {

		ArrayList<OrderVO> plist = om.moneylist();
		model.addAttribute("pmlist", plist);
		log.info("movement payment list: " + plist);

		return "/admin/money_list";
	}
	
	//회원 삭제
	@GetMapping("/remove")
	public String remove(@RequestParam("id") String id, RedirectAttributes rttr) {
		log.info("remove..." + id);
		if (service.remove(id)) {
			rttr.addFlashAttribute("result", "success");
		} else {
			System.out.println("remove failed");
		}
		return "redirect:/admin/member_list";
	}
	
	// 구글 로그인
	@ResponseBody
	@RequestMapping(value = "/loginGoogle", method = RequestMethod.POST)
	public String loginGooglePOST(skylifeVO vo, HttpSession session, RedirectAttributes rttr, skylifeVO mvo) throws Exception{
		skylifeVO returnVO = service.loginMemberByGoogle(vo);
		String mvo_ajaxid = mvo.getId(); 
		System.out.println("C: 구글아이디 포스트 db에서 가져온 vo "+ vo);
		System.out.println("C: 구글아이디 포스트 ajax에서 가져온 id "+ mvo_ajaxid);
		
		//아이디가 DB에 존재하지 않는 경우
		if(returnVO == null) { 
			//구글 회원가입
			service.joinMemberByGoogle(vo);	
			
			//구글 로그인
			returnVO = service.loginMemberByGoogle(vo);
			log.info("returnVO: " + returnVO);
			session.setAttribute("user", returnVO);	
			rttr.addFlashAttribute("mvo", returnVO);
		}
		
		//아이디가 DB에 존재하는 경우
		if(mvo_ajaxid.equals(returnVO.getId())){ 
			//구글 로그인
			service.loginMemberByGoogle(vo);
			session.setAttribute("user", returnVO);			
			rttr.addFlashAttribute("mvo", returnVO);
		} else {		//아이디가 DB에 존재하지 않는 경우
			//구글 회원가입
			service.joinMemberByGoogle(vo);	
			
			//구글 로그인
			returnVO = service.loginMemberByGoogle(vo);
			session.setAttribute("user", returnVO);			
			rttr.addFlashAttribute("mvo", returnVO);
		}		
		return "redirect:/";
	}
	
	// 카카오 로그인
	@GetMapping("/auth/kakao/callback")
    public String home(@RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception{

		String access_Token = kakaoService.getAccessToken(code);
		HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);

		System.out.println("이메일: " + userInfo.get("email")); // 아이디
		System.out.println("이름: " + userInfo.get("nickname")); // 이름 
		//System.out.println("프로필: " + userInfo.get("profile_image"));

		String id = String.valueOf(userInfo.get("email"));
		String email = String.valueOf(userInfo.get("email"));
		String name = String.valueOf(userInfo.get("nickname"));

		skylifeVO kvo = new skylifeVO(id, name, email);
		
		if(skylifeMapper.readMemberWithKakaoID(id) == null) {
			// 회원 database에 없는 경우
			skylifeMapper.joinMemberByKakao(kvo);  // 회원가입
		}
		session.setAttribute("user", kvo);

		return "redirect:/";
	}
	
}