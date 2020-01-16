package examples.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import examples.springmvc.dto.User;
import examples.springmvc.service.UserService;

@Controller
@RequestMapping(path = "/users")
public class UsersController {
	@Autowired
	private UserService userService;
	
	//요청이 달라질 때는 Redirect로 가야함
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session) {
		User user = userService.getUser(userId);
		if(user != null && password.equals(user.getPassword())) {
			//사용자가 입력한 정보와 DB에서 얻어온 정보가 일치할 때...
			//상태정보를유지해줌.
			user.setPassword("");
			session.setAttribute("login", user);
			return "redirect:/users";
		} else {
			//로그인에 실패한 경우
			return "redirect:/users/loginform";
		}
	}
	
	
	@GetMapping("/loginform") //JSP 찾는 것 => 포워딩
	public String loginform() {
		return "users/loginform";
		
	}
	
	@GetMapping
	public String getUsers(Model model) {
		model.addAttribute("list", userService.getUsers());
		return "users/list";
	}
	@GetMapping("/joinform")
	public String joinForm() {
		return "users/joinform";
	}
	
	@PostMapping("/join")
	public String join(User user) {
		userService.addUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) { //session remove하기!
		//ex.쇼핑하다가 로그아웃할때 장바구니가 남아있으면 login정보만 없앤 것임!
		session.removeAttribute("login");
		return "redirect:/boards"; //users요청했는데 로그인 안돼있으면 그냥 폼 나옴
	}
}
