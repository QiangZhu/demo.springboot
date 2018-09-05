package com.zq.bigdata.controller;

import com.zq.bigdata.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/delivery")
    public String delivery(@RequestParam(name="ip", required=false, defaultValue="") String ip, Model model) {
        deliveryService.deliver();
        model.addAttribute("ip", ip);
        return "delivery";
    }
}
