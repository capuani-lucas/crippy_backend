package com.capuani.crippy.alerts;

import com.capuani.crippy.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }


    public List<Alert> getAlerts() {

        return alertRepository.findAll();

    }


    public Alert createAlert() {
        return alertRepository.save(new Alert("btc", 50000));
    }

    public Alert addSubscriber(long id, long userId) {

        Alert a = alertRepository.findById(id).get();

        return a;
//        a.addSubscriber();

    }

    public Set<User> getSubscribersOfAlert(long id) {

        Alert a = alertRepository.findById(id).get();

        return  a.getSubscribers();

    }
}
