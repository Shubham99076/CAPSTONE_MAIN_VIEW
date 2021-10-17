package com.project.api;

import static com.project.util.Route.USER;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.project.data.model.UserInfo;
import com.project.data.model.UserRole;
import com.project.data.repository.RoleRepository;
import com.project.data.repository.UserRepository;
import com.project.service.UserService;
import com.project.util.Route;

@Controller
@RequestMapping(USER)
public class UserController {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String index() {
		return "index";
	}

	@PostConstruct
	public void addRoles() {

		if (roleRepository.findAll().isEmpty()) {
			UserRole roleAdmin = new UserRole("ADMIN");
			UserRole roleUser = new UserRole("USER");
			List<UserRole> roles = new ArrayList<>();
			roles.add(roleAdmin);
			roles.add(roleUser);

			roleRepository.saveAll(roles);

			if (userRepository.findAll().isEmpty()) {
				UserInfo user = new UserInfo();
				user.setUname("admin");
				user.setPassword("admin");
				user.setRole(roleAdmin);
				userRepository.save(user);
			}
		}
	}

	@GetMapping("/create")
	public ModelAndView createUserView() {
		ModelAndView mv = new ModelAndView("create");
		return mv;
	}

	@GetMapping("/user-management")
	public ModelAndView userManagementView() {
		ModelAndView mv = new ModelAndView("user_management");
		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView editUserView(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edit");
		UserInfo userInfo = userService.getUser(id);
		mv.addObject("user", userInfo);
		return mv;
	}

	@GetMapping("/display")
	public ModelAndView DisplayUsers() {
		ModelAndView mv = new ModelAndView("users");
		mv.addObject("users", userService.allUser());
		return mv;
	}

	@GetMapping("/unauth_user")
	public ModelAndView unauthUserPage() {
		ModelAndView mv = new ModelAndView("unauth_user");
		return mv;
	}

	@PostMapping(Route.SIGNIN)
	public RedirectView signIn(@ModelAttribute UserInfo user, RedirectAttributes attr) {

		Optional<UserInfo> userOp = userService.getUserByUserIdAndPassword(user);

		RedirectView mv;
		if (userOp.isPresent()) {
			UserInfo userInfo = userOp.get();
			if (userInfo.getRole().getRoleName().equals("ADMIN"))
				mv = new RedirectView("user-management");
			else
				mv = new RedirectView("unauth_user");
		} else {
			mv = new RedirectView("/user/login", true);
			attr.addFlashAttribute("error", "Incorrect password");
		}
		return mv;
	}

	@PostMapping("/register")
	public ModelAndView regsiterUser(@ModelAttribute UserInfo user) {

		ModelAndView view = new ModelAndView("redirect:/user/display");
		userService.addUser(user);
		return view;
	}

	@PostMapping("/update")
	public ModelAndView updateUser(@ModelAttribute UserInfo user) {

		ModelAndView view = new ModelAndView("redirect:/user/display");
		userService.updateUser(user);
		return view;
	}

	//
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("redirect:/user/display");
		userService.deleteUser(id);
		return view;
	}

}
