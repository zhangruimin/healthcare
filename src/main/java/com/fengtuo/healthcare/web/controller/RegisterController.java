package com.fengtuo.healthcare.web.controller;

import com.fengtuo.healthcare.model.User;
import com.fengtuo.healthcare.repository.UserRepository;
import com.fengtuo.healthcare.web.form.LoginForm;
import com.fengtuo.healthcare.web.form.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/25/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Map model) {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(RegisterForm registerForm, HttpSession session) {
        User user = registerForm.toUser();
        userRepository.save(user);
        session.setAttribute("currentUser", user);
        return "redirect:realTimeData";
    }
}
