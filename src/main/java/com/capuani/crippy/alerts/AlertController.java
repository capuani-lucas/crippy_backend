package com.capuani.crippy.alerts;

import com.capuani.crippy.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "v1/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }


    @GetMapping
    List<Alert> getAlerts () {
        return alertService.getAlerts();
    }

    @GetMapping("/subscribers/{id}")
    Set<User> getSubscribersOfAlert (@PathVariable long id) {

        return alertService.getSubscribersOfAlert(id);

    }

    @PostMapping("/create/{coin}/{threshold}")
    Alert createAlert(@PathVariable String coin, @PathVariable long threshold) {

        return alertService.createAlert();

    }

    @PutMapping("/add_subscriber/{id}/{user_id}")
    Alert addSubscriber(@PathVariable long id, @PathVariable long userId) {
        return alertService.addSubscriber(id, userId);
    }

}
