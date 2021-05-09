package com.capuani.crippy.activity;

import com.capuani.crippy.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "activity", schema = "public")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public User getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
