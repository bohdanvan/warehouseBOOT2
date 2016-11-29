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


page 540 Spring в действии

public void updateSpittle(Spittle spittle) throws SpitterException {
        try {
        String url =
        "http://localhost:8080/Spitter/spittles/"+ spittle.getId();
        new RestTemplate().put(new URI(url), spittle);
        } catch (URISyntaxException e) {
        throw new SpitterUpdateException("Unable to update Spittle", e);
        }
        }

public void updateSpittle(Spittle spittle) throws SpitterException {
        restTemplate.put("http://localhost:8080/Spitter/spittles/{id}",
        spittle, spittle.getId());
        }

public void updateSpittle(Spittle spittle) throws SpitterException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", spittle.getId());
        restTemplate.put("http://localhost:8080/Spitter/spittles/{id}",
        spittle, params);
        }