package com.fengtuo.healthcare.web.controller;

import com.fengtuo.healthcare.model.*;
import com.fengtuo.healthcare.repository.DigitRecordRepository;
import com.fengtuo.healthcare.repository.UserRepository;
import com.fengtuo.healthcare.web.dto.DigitRecordDto;
import com.fengtuo.healthcare.web.dto.WaveRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/25/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private static final String DEVICES = "devices";
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "devices",method= RequestMethod.GET)
    public String getDevices(ModelMap model, @RequestParam String userId) {
        User user = userRepository.findById(userId);
        model.put("devices", user.getDevices());
        return DEVICES;
    }

    @RequestMapping(value = "devices",method= RequestMethod.POST)
    public String addDevice(ModelMap model, @RequestParam String deviceId, @RequestParam DeviceType deviceType) {
        User user = userRepository.findById("1");
        user.addDevice(new Device(deviceId,deviceType));
        userRepository.save(user);
        return "redirect:devices?userId=1";
    }

    @RequestMapping(value = "createUser",method= RequestMethod.GET)
    public @ResponseBody
    String createUser(ModelMap model, @RequestParam String userId, @RequestParam String userName,@RequestParam String password) {
        User user = new User();
        user.setId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        userRepository.save(user);
        return "Success";
    }
}
