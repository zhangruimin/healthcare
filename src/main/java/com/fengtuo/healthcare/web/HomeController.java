package com.fengtuo.healthcare.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/25/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/home.do")
public class HomeController {
    private static final String HOME = "jsp/home.jsp";

    @RequestMapping(method= RequestMethod.GET)
    public String helloWorld(ModelMap model) {
        model.addAttribute("message", "Hello World!");
        return HOME;
    }
}
