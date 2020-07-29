package com.ascending.training.controller;

import com.ascending.training.model.User;
import com.ascending.training.service.JWTService;
import com.ascending.training.service.UserService;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class AuthController {
    @Autowired private UserService userService;
    @Autowired private JWTService jwtService;

    private String errorMsg = "The email or password is not correct.";
    private String tokenKeyword = "Authorization";
    private String tokenType = "Bearer";

    private Logger logger = LoggerFactory.getLogger(getClass());



    //http://localhost:8080/auth
    //{
    //	"email": "dwang@training.ascendingdc.com",
    //	"password":"123456789"
    //}
    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String authentication(@RequestBody User user){
        logger.debug("username is" + user.getEmail() + "password is" + user.getPassword());
        try{
            User u = userService.getUserByCredentials(user.getEmail(),user.getPassword());
            String token = jwtService.generateToken(u);
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

