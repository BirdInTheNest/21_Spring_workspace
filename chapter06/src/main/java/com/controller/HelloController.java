package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller //HandlerMapping이 요청된 url과 @Controller 있는 클래스를 연결한다
public class HelloController {

	/*
	//@RequestMapping(value="/hello.do", method=RequestMethod.GET) //value=url, value 생략 가능
	@GetMapping("/hello.do") //@PostMapping
	public ModelAndView hello(){ //사용자가 만든 콜백 메소드, 메소드명을 hello.do와 같게 만든다. 다르게 해도 됨
		ModelAndView mav = new ModelAndView(); //데이터를 싣자, request 역할을 대신 함
		mav.addObject("result", "Enjoy the trip wherever this ends!!"); //변수명 값
		//mav.setViewName("hello"); //파일명만 쓴다, 확장자는 Resolver가 관리 -> /view/hellp.jsp
		mav.setViewName("/view/hello");
		return mav;
	}
	*/
	
	//리턴 타입이 String 이면, 단순 문자열로 인식하는 것이 아니라 파일명으로 인식한다 (스프링의 특징)
	//@ResponseBody 사용하면 단순 문자열로 인식한다

	@GetMapping(value="/hello.do", produces="text/html;charset=UTF-8") //@ResponseBody로 한글이 깨질 때 사용
	public @ResponseBody String hello() {
		return "둥실둥실 두둥실"; //화면에 뿌린다
	}
	
	
}
