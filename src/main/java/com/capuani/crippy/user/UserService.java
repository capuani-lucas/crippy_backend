package com.capuani.crippy.user;

import com.capuani.crippy.alerts.Alert;
import com.capuani.crippy.alerts.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AlertRepository alertRepository;

    public UserService(UserRepository userRepository, AlertRepository alertRepository) {
        this.userRepository = userRepository;
        this.alertRepository = alertRepository;
    }


    public User getUserByID(long id) {
        return userRepository.findById(id).get();
    }

    public User createUser(String name, String email) {
        return userRepository.save(new User(name, email));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUserAlert(long id, long userId) {

        User u = userRepository.findById(userId).get();
        Alert a = alertRepository.findById(id).get();

        u.addAlert(a);

        return userRepository.save(u);

    }
}
