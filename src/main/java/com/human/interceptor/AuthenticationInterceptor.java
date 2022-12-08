package com.human.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter{ // 인터셉터 기능을 활용하기 위해 상속받음

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		로그인을 안한 경우는 로그인을 하도록 함,		/글쓰기, 글 자세히보기는 로그인을 해야만 접근할 수 있음
//		세션을 검사 후..
//		클라이언트마다 세션이 있음, 클라이언트가 보낸 쿠키의 아이디와 일치하는 세션의 객체를 가져와라
		HttpSession session = request.getSession();
//		가져온 세션에서 login 변수를 찾아서 리턴받아라, 그런데 login 변수의 리턴타입을 모르니 모든 변수의 최상위인 Object로 받음
		Object obj = session.getAttribute("login");
		if (obj == null) { // 로그인 안한 경우
			response.sendRedirect(request.getContextPath() + "/"); // 컨트롤러로 / 경로 바꿈
			return false;
		}
		return true; // 원래 가고싶은 경로로 가라
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("PostHandle start");
		System.out.println("PostHandle end");
		super.postHandle(request, response, handler, modelAndView);
	}
}

// 인터셉터 동작 공부중