package com.fengtuo.healthcare.web.controller;

import com.fengtuo.healthcare.model.User;
import com.fengtuo.healthcare.repository.UserRepository;
import com.fengtuo.healthcare.web.form.UserInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/25/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/basicInfo")
public class BasicInfoController extends BaseController{
    private static final String BASIC_INFO = "basicInfo";

    private UserRepository userRepository;

    @Autowired
    public BasicInfoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String index(ModelMap model, HttpSession session) {
        User currentUser = getCurrentUser(session);
        model.addAttribute("currentUser", currentUser);
        return BASIC_INFO;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(UserInfoForm registerForm, HttpSession session) {
        User user = registerForm.toUser();
        userRepository.save(user);
        session.setAttribute("currentUser", user);
        return "redirect:basicInfo";
    }
}

