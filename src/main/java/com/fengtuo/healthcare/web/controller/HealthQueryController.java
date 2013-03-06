package com.fengtuo.healthcare.web.controller;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/healthQuery")
public class HealthQueryController {
    private static final String HEALTH_QUERY = "healthQuery";

    @RequestMapping(method= RequestMethod.GET)
    public String index(ModelMap model) {
        return HEALTH_QUERY;
    }
}
