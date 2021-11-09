package com.zeuschiu.generation.javaserver.controllers;

import com.zeuschiu.generation.javaserver.modules.UserDb;
import com.zeuschiu.generation.javaserver.modules.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private static UserRepository userRepository;
}
