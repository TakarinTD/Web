package com.example.easynotes.controller;

import static com.example.easynotes.constant.SystemConstant.ACTIVE_STATUS;
import com.example.easynotes.exception.*;
import com.example.easynotes.model.*;
import com.example.easynotes.repository.*;
import com.example.easynotes.service.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Query;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    NoteRepository noteRepository;

    @GetMapping ("/admin")
    public String admin (Model model) {
        //User user = (User) userRepository.findAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findOneByUserNameAndStatus(auth.getName(), ACTIVE_STATUS);
        model.addAttribute("userId", user.getId());
        model.addAttribute("users", userRepository.findAll());
        return "/admin";
    }

    @PostMapping ("/editUser")
    @ResponseBody
    public ResponseEntity edit (@RequestBody User user) {
        if ((user.getStatus() != 0 && user.getStatus() != 1) || (!user.getRoleName().equals("admin") && !user.getRoleName().equals("user"))) {
            System.out.println(user.getRoleName());
            System.out.println(user.getStatus());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        else{
            Role userRole = roleRepository.findByRole(user.getRoleName());
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            user.setFullName(getUserById(user.getId()).getFullName());
            user.setPassword(getUserById(user.getId()).getPassword());
            user.setUserName(getUserById(user.getId()).getUserName());
            try {
                return ResponseEntity.ok(userRepository.save(user));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
            }
        }
    }

    @PostMapping (path = "/editInfo", consumes = "application/json")
    @ResponseBody
    public ResponseEntity editInfo (@RequestBody User user) {
        System.out.println(user);
        if (user.getFullName().equals("")) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        else{
            Role userRole = roleRepository.findByRole(user.getRoleName());
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            user.setRoleName(getUserById(user.getId()).getRoleName());
            user.setPassword(getUserById(user.getId()).getPassword());
            user.setUserName(getUserById(user.getId()).getUserName());
            user.setStatus(getUserById(user.getId()).getStatus());
            try {
                return ResponseEntity.ok(userRepository.save(user));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
            }
        }
    }

    @GetMapping ("/findUser/{id}")
    @ResponseBody
    public User getUserById (@PathVariable (value = "id") Long userId) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return user;
    }


    @RequestMapping (value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login () {
        ModelAndView model = new ModelAndView();
        model.setViewName("/login");
        return model;
    }

    @GetMapping ("/home_page")
    public ModelAndView home_page () {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findOneByUserNameAndStatus(auth.getName(), ACTIVE_STATUS);
        model.addObject("role", userRepository.findUserRole(user.getId()));
        model.addObject("user", user);
        model.setViewName("/home_page");
        return model;
    }

    @RequestMapping (value = {"/signup"}, method = RequestMethod.GET)
    public ModelAndView signup () {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("/signup");

        return model;
    }

    @RequestMapping (value = {"/signup"}, method = RequestMethod.POST)
    public ModelAndView createUser (@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findOneByUserNameAndStatus(user.getUserName(), ACTIVE_STATUS);

        if (userExists != null) {
            bindingResult.rejectValue("userName", "error.userName", "This userName already exists!");
        }
        if (! bindingResult.hasErrors()) {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
        }

        //securityService.autoLogin(user.getUserName(), user.getPassword());

        model.setViewName("/signup");

        return model;
    }

    @RequestMapping (value = {"/access_denied"}, method = RequestMethod.GET)
    public ModelAndView accessDenied () {
        ModelAndView model = new ModelAndView();
        model.setViewName("/access_denied");
        return model;
    }
}
