//package com.warehouse.controller;
//
//import com.warehouse.model.OrderIncDel;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//
//public class GreetingController {
//
//    private static final String templ = "Count %s ";
//    private final AtomicLong counter = new AtomicLong();
//
//
//
//    //@GetMapping("/order/{id}")
//    public OrderIncDel order(@PathVariable String id) {
//        OrderIncDel orderIncDel = orderIncDelRepository.findOne(Long.valueOf(id));
//        orderIncDel.setName("counter is "+counter.incrementAndGet());
//        return orderIncDel;
//    }
//}
//
//
