package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SumDTO;

@Controller //HandlerMapping은 요청된 URL과 @Controller 찾아서 매핑한다
public class SumController {

	@RequestMapping(value="/input.do", method=RequestMethod.GET) //value=url
	public String input() { //사용자 콜백 메소드, 메소드명을 url과 같게 한다
		return "/sum/input"; //리턴타입이 String이므로, 파일명으로 반환
	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public String result() {
//		return "/sum/result";
//	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam String x, @RequestParam String y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public ModelAndView result(@RequestParam(required=false, defaultValue="0") String x, 
//							   @RequestParam(required=false, defaultValue="0") String y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public String result(@RequestParam Map<String, String> map, ModelMap modelMap) {
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//		return "/sum/result";
//	}
	
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		//model.addAttribute("x", sumDTO.getX());
		//model.addAttribute("y", sumDTO.getY());
		
		model.addAttribute("sumDTO", sumDTO); //한번에 보내도 된다
		
		return "/sum/result";
	}
}
