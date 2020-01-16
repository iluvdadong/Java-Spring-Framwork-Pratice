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
	
	
	@GetMapping("/loginform") //JSP 찾는 것 => 포워딩
	public String loginform() {
		
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
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/boards";
	}
}
