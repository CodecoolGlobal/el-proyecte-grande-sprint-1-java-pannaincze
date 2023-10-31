package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;
import com.codecool.sportbuddyfinder.service.ActivityService;
import com.codecool.sportbuddyfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("activities")
public class ActivityController {
    private final ActivityService activityService;
    private final UserService userService;

    @Autowired
    public ActivityController(ActivityService activityService, UserService userService) {
        this.activityService = activityService;
        this.userService = userService;
    }

    @GetMapping("/")
    public Set<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable UUID id) {
        return activityService.getActivityById(id);
    }
    @GetMapping("/categories")
    public Sport[] getAllSport(){
        return Sport.values();
    }

    @PostMapping("/create")
    @ResponseBody
    public Activity addNewActivity(@RequestBody Activity activity) {
        return activityService.addNewActivity(activity);
    }

    @DeleteMapping("/{id}")
    public UUID deleteActivityById(@PathVariable UUID id) {
        return activityService.deleteActivityById(id);
    }

    @PatchMapping("/update/{id}")
    public Activity updateActivityById(@PathVariable UUID id) {
        return activityService.updateActivityById(id);
    }

    @PatchMapping("/update/{activityId}/{userId}")
    public Activity addUserToActivity(@PathVariable UUID activityId, @PathVariable int userId) {
        return activityService.addUserToActivity(activityId, userService.getUserById(userId));
    }
}
