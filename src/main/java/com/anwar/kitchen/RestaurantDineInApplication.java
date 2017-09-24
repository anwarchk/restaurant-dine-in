package com.anwar.kitchen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;

@SpringBootApplication
@RefreshScope
public class RestaurantDineInApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantDineInApplication.class, args);
    }

    @RestController
    static class MenuController {

        @Value("${restaurant.name}")
        private String name;

        @Value("${takeout.fee:0.00}")
        private String fee;

        @Value("${chef.special:Meh, I dont' like the special anyway}")
        private String special;

        @GetMapping("/name")
        public String getRestaurantName() {
            return name;
        }

        @GetMapping("/special")
        public String getSpecial() {
            return special;
        }

        @GetMapping("/fee")
        public String getTakeOutFee() {
            return NumberFormat.getCurrencyInstance().format(Double.valueOf(fee));
        }
    }
}
