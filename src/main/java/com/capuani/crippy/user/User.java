package com.capuani.crippy.user;

import com.capuani.crippy.activity.Activity;
import com.capuani.crippy.alerts.Alert;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class User {

    public User () {

    }

    public User (String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @ManyToMany
    @JoinTable(
            name = "user_alerts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "alert_id")
    )
    private Set<Alert> alerts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Activity> activity = new HashSet<>();

    private String name;

    private String email;


    public long getId() {
        return id;
    }

    public Set<Alert> getAlerts() {
        return alerts;
    }

    public Set<Activity> getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", alerts=" + alerts +
                ", activity=" + activity +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addAlert(Alert a) {
        this.alerts.add(a);
    }
}
