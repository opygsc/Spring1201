package com.human.cafe1201;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLogin {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("pw") String pw) {
//		로그인 절차
//		1. 파라미터 받음	2. 쿼리 실행 후 결과값에 따라 팜, 서비스 단이 필요
//		현재는 테스트용으로 함
		if (id.equals("aaa") && pw.equals("bbb")) { // 쿼리 실행 후 아이디와 패스워드가 정상적인 경우 리턴받는 것으로 수정
//			로그인 성공인 경우 세션처리
			
			if (session.getAttribute("login") != null) {
				session.removeAttribute("login"); // 일종의 초기화, 한번 더 청소하고 가겠다는 의미
			}
			session.setAttribute("login", id); // 세션처리
			session.setAttribute("grade", "vip"); // 처리하고 싶은 변수를 선택하여 등록, 객체도 가능
		} else {
//			로그인 실패인 경우
		}
//		<-- 여기까지가 테스트용 나중에 DB연동 해야 함
		System.out.println("로그인 공사중");
		return "home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // 세션을 무력화
		return "home";
	}
}

// 인터셉터로 로그인을 잡으면 안됨, 그러면 영원히 로그인이 안될 것