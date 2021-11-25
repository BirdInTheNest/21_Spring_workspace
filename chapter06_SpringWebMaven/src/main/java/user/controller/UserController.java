package user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.ImageboardDTO;
import user.bean.UserDTO;
import user.service.UserService;

@Controller //@Controller는 @Component 역할까지 같이 한다
@RequestMapping(value="/user") //위에 걸면 메소드마다 중복되는 네임스페이스 user 생략해도 됨
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/writeForm", method=RequestMethod.GET) //user 네임스페이스, value=url
	public String writeForm() { //사용자 콜백 메소드, 메소드명을 url과 같게 한다
		return "/user/writeForm"; //user 폴더, 리턴타입이 String이므로, 파일명으로 반환
	}
	
	@RequestMapping(value="/checkId", method=RequestMethod.POST)
	@ResponseBody //@ResponseBody 사용하면 리턴값을 파일명이 아니라 단순 문자열로 인식한다
	public String checkId(@RequestParam String id) {
		return userService.checkId(id);
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	@ResponseBody //jsp 파일 리턴하는 것이 아니라, 바로 ajax 쪽으로 가게 한다
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@GetMapping(value="/list")
	public String list() {
		return "/user/list";
	}
	
//	@PostMapping(value="/getUserList")
//	@ResponseBody
//	public JSONObject getUserList() {
//		return userService.getUserList();
//	}
	
	/*
	메소드의 return형 앞에 @ResponseBody를 사용하고 해당 객체를 return하면
	ajax success 함수의 data에 해당객체가 자동으로 JSON 객체로 변환되어 반환되므로 파싱이 필요없습니다
	<dependency>
	    <groupId>org.codehaus.jackson</groupId>
	    <artifactId>jackson-mapper-asl</artifactId>
	    <version>버전</version>
	</dependency>
	
	https://www.nextree.co.kr/p11205/ 참고
	*/
	@PostMapping(value="/getUserList")
	@ResponseBody
	public List<UserDTO> getUserList() {
		return userService.getUserList();
	}
	
	@GetMapping("/modifyForm")
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	@PostMapping("/getUser")
	@ResponseBody
	public UserDTO getUser(@RequestParam String searchId) {
		return userService.getUser(searchId);
	}
	
	@PostMapping("/modify")
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
	
	@GetMapping("/deleteForm")
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public void delete(@RequestParam String searchId) {
		userService.delete(searchId);
	}
	
	@RequestMapping(value="/imageboardWriteForm", method=RequestMethod.GET)
	public String imageboardWriteForm() { 
		return "/user/imageboardWriteForm";
	}
	
	/*
	//name="img"가 1개인 경우
	@RequestMapping(value="/imageboardWrite", method=RequestMethod.POST)
	public String imageboardWrite(@ModelAttribute ImageboardDTO imageboardDTO,
								  @RequestParam MultipartFile img) {
		
		//imageboardWriteForm에서 넘어온 name 속성 값들은 DTO에 담아 넘어오는데,
		//img는 변수명이 다르기 때문에 DTO에 들어가지 않고, MultipartFile 클래스를 통해 실제 폴더에 *.tmp 임시파일로 올라간다.
		
		//파일위치를 가상폴더 storage로, 파일명을 원래이름으로 바꾼다
		String filePath = "D:\\Spring\\workspace\\chapter06_SpringWebMaven\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);
		
		//파일 복사 - img에서 가져와서 file에 내보내라
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		imageboardDTO.setImage1(fileName);
		
		return "/user/imageboardWrite";
	}
	*/
	
	/*
	//name="img"가 2개 이상인 경우
	@RequestMapping(value="/imageboardWrite", method=RequestMethod.POST)
	public String imageboardWrite(@ModelAttribute ImageboardDTO imageboardDTO,
								  @RequestParam MultipartFile[] img) {
		
		String filePath = "D:\\Spring\\workspace\\chapter06_SpringWebMaven\\src\\main\\webapp\\storage";
		String fileName;
		File file;
		
		//파일 복사
		if(img[0] != null) {
			fileName = img[0].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				FileCopyUtils.copy(img[0].getInputStream(), new FileOutputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			imageboardDTO.setImage1(fileName);
			
		}else {
			imageboardDTO.setImage1(""); //null값일 때 DTO에 들어가지 않게
		}
		
		//------------------------------------------
		if(img[1] != null) {
			fileName = img[1].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				FileCopyUtils.copy(img[1].getInputStream(), new FileOutputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			imageboardDTO.setImage2(fileName);
			
		}else {
			imageboardDTO.setImage2("");
		}
		
		return "/user/imageboardWrite";
	}
	*/
	
	/*
	//한번에 여러개의 파일을 선택한 경우 - 배열로 받아서 리스트에 담는다
	@RequestMapping(value="/imageboardWrite", method=RequestMethod.POST)
	public String imageboardWrite(@ModelAttribute ImageboardDTO imageboardDTO,
								  @RequestParam("img[]") List<MultipartFile> list) {
		
		String filePath = "D:\\Spring\\workspace\\chapter06_SpringWebMaven\\src\\main\\webapp\\storage";
		String fileName;
		File file;
		
		for(MultipartFile img : list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			imageboardDTO.setImage1(fileName);
			imageboardDTO.setImage2("");
		}//for
		
		return "/user/imageboardWrite";
	}
	*/
	
	//AJax 통신 - 한번에 여러개의 파일을 선택한 경우
	@RequestMapping(value="/imageboardWrite", method=RequestMethod.POST)
	@ResponseBody
	public void imageboardWrite(@ModelAttribute ImageboardDTO imageboardDTO,
								  @RequestParam("img[]") List<MultipartFile> list) {
		
		String filePath = "D:\\Spring\\workspace\\chapter06_SpringWebMaven\\src\\main\\webapp\\storage";
		String fileName;
		File file;
		
		for(MultipartFile img : list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			imageboardDTO.setImage1(fileName);
			imageboardDTO.setImage2("");
		}//for
		
		//DB
	}
	
}

