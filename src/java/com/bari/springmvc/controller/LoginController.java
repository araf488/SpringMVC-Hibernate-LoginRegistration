package com.bari.springmvc.controller;

import com.bari.springmvc.model.User;
import com.bari.springmvc.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new User());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") User login) {
        ModelAndView mav = null;
        User user = userService.loginUsers(login);
        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("email", user.getEmail());
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Email or Password is wrong!!");
        }
        return mav;
    }
}
