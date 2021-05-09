package com.capuani.crippy.alerts;

import com.capuani.crippy.test.Test;
import com.capuani.crippy.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alert", schema = "public")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "alerts")
    private Set<User> subscribers = new HashSet<>();

    private String coin;

    private boolean activated;

    private long threshold;

    public Alert () {

    }

    public Alert(String coin, long threshold) {
        this.coin = coin;
        this.threshold = threshold;
        this.activated = false;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                ", subscribers=" + subscribers +
                ", coin='" + coin + '\'' +
                ", activated=" + activated +
                ", threshold=" + threshold +
                '}';
    }

    public String getCoin() {
        return coin;
    }

    public boolean isActivated() {
        return activated;
    }

    public long getThreshold() {
        return threshold;
    }
}
