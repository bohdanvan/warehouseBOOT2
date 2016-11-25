package com.warehouse.controller;

import com.warehouse.model.OrderIncDel;
import com.warehouse.model.User;
import com.warehouse.model.UserRepository;
import com.warehouse.service.IncDelRepository;
import com.warehouse.service.LangRepository;

import com.warehouse.service.OrderIncDelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by user on 30.10.2016.
 */
@RestController
public class GreetingController {

    private static final String templ = "Count %s ";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IncDelRepository incDelRepository;
    @Autowired
    OrderIncDelRepository orderIncDelRepository;
    @Autowired
    LangRepository langRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession httpSession;



    @RequestMapping("/resource")
    public Map<String, Object> resource() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }


    @GetMapping("/order")
    public OrderIncDel orderGET() {
//        OrderIncDel orderIncDel = orderIncDelRepository.findOne(Long.valueOf(id));
        OrderIncDel orderIncDel = new OrderIncDel();
        orderIncDel.setProductName("progr name : counter is " + counter.incrementAndGet());
        orderIncDel.setUrl(String.format(templ, counter.incrementAndGet()));
        return orderIncDel;
    }


    @GetMapping("/order/{id}")
    public OrderIncDel order(@PathVariable String id) {
        OrderIncDel orderIncDel = orderIncDelRepository.findOne(Long.valueOf(id));
        orderIncDel.setProductName("progr name : counter is " + counter.incrementAndGet());
        orderIncDel.setUrl(String.format(templ, counter.incrementAndGet()));
        return orderIncDel;
    }

    @PostMapping("/order/{id}")
    public OrderIncDel orderSave(@PathVariable String id) {
        OrderIncDel orderIncDel = orderIncDelRepository.findOne(Long.valueOf(id));

        return orderIncDel;
    }


//    @RequestMapping("/checkIsUserRegistr/{login}")
//    public User isUserReg(@PathVariable String login) {
//
//        User user = new User();
//        user.setUserName("seet name like req login "+ login);
//
//        try {
//            user = userRepository.findByUserName(login);
//        } catch (Exception e) {
//            user.setUserName("exeption name");
//        }
//
//        return userRepository.findByUserName(login);
//    }

    @RequestMapping("/checkIsUserRegistr/{login}")
    public Collection<User> userCollection (@PathVariable String login) {


        return userRepository.findAll();
    }

}


