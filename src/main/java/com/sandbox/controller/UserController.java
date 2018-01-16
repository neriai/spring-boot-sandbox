package com.sandbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sandbox.entity.User;
import com.sandbox.service.UserService;

@ComponentScan
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService service;

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list() {
        return "user/list";
    }

    @RequestMapping(value="/list", method=RequestMethod.POST)
    public ModelAndView search(
        ModelAndView mav,
        @RequestParam("userName") String userName,
        @RequestParam("groupName") String groupName
    ) {
        mav.setViewName("user/list");
 
        mav.addObject("userName", userName);
        mav.addObject("groupName", groupName);
        
        List<User> result = service.findUsers(userName, groupName);

        mav.addObject("result", result);
        mav.addObject("resultSize", result.size());
      
        return mav;
    }
    
    @RequestMapping(value="/detail/{userId}", method=RequestMethod.GET)
    public ModelAndView detail(
        ModelAndView mav,
        @PathVariable("userId") Integer userId
    ) {
        User result = service.findByUser(userId);

        mav.addObject("result", result);
        mav.setViewName("user/detail");
        
        return mav;
    }
    
    @RequestMapping(value="/detail/{userId}", method=RequestMethod.POST)
    public String update(
        ModelAndView mav,
        @PathVariable("userId") Integer userId,
        @RequestParam("userName") String userName
    ) {
        service.updateUser(userId, userName);
        
        return "redirect:/user/list";
    }
}