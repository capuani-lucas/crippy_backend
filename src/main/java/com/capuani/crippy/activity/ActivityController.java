package com.capuani.crippy.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/activity")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController (ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/{id}")
    Activity getActivity (@PathVariable long id) {
        return activityService.getActivity(id);
    }




}
