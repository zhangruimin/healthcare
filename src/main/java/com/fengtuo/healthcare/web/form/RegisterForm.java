package com.fengtuo.healthcare.web.form;

import com.fengtuo.healthcare.model.Career;
import com.fengtuo.healthcare.model.Gender;
import com.fengtuo.healthcare.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/18/13
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterForm {
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Gender gender;
    private Career career;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser(){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setAge(age);
        user.setHeight(height);
        user.setWeight(weight);
        user.setGender(gender);
        user.setCareer(career);
        return user;
    }
}
