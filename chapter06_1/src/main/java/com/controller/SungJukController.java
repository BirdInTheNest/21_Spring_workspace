package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

@Controller //@Controller는 @Component 역할까지 같이 한다
public class SungJukController {
	
	@RequestMapping(value="/sungJuk/input.do", method=RequestMethod.GET) //sungJuk 네임스페이스, value=url
	public String input() { //사용자 콜백 메소드, 메소드명을 url과 같게 한다
		return "/sungJuk/input"; //sungJuk 폴더, 리턴타입이 String이므로, 파일명으로 반환
	}
	
	@PostMapping(value="/sungJuk/result.do")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) {
		int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
		double avg = tot / 3.0;
		
		sungJukDTO.setTot(tot);
		sungJukDTO.setAvg(avg);
		
		model.addAttribute("sungJukDTO", sungJukDTO);
		return "/sungJuk/result";
	}
	
}
