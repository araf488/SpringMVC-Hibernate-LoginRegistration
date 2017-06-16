package com.bari.springmvc.controller;

import com.bari.springmvc.model.User;
import com.bari.springmvc.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;
    
    @RequestMapping("/registration")
    public String listUser(Map<String, Object> map) {
        map.put("user", new User());
        map.put("userList", userService.listUser());
        return "registration";
    }
    
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("user") User user, BindingResult result) {
        if (user.getId() == null) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/registration";
    }
    
    @RequestMapping("/delete/{pid}")
    public String deleteUser(@PathVariable("pid") Integer pid) {
        userService.removeUser(pid);
        return "redirect:/registration";
    }
    
    @RequestMapping("/edit/{pid}")
    public String editUser(@PathVariable("pid") Integer pid, Map<String, Object> map) {
        map.put("user", userService.getUserById(pid));
        map.put("userList", userService.listUser());
        return "registration";
    }
}
