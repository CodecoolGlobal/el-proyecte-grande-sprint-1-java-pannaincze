package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;
import com.codecool.sportbuddyfinder.service.ActivityService;
import com.codecool.sportbuddyfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/{id}")
    public Optional<Activity> getActivityById(@PathVariable long id) {
        return activityService.getActivityById(id);
    }
    @GetMapping("/categories")
    public Sport[] getAllSport(){
        return Sport.values();
    }

    @PostMapping("/create")
    public Activity addNewActivity(@RequestBody Activity activity) {
        return activityService.addNewActivityToDB(activity);
    }

    @DeleteMapping("/{id}")
    public boolean deleteActivityById(@PathVariable long id) {
        return activityService.deleteActivityById(id);
    }

//    @PutMapping("/update/{id}")
//    public Activity updateActivityById(@PathVariable long id, @RequestBody Activity activity) {
//        return activityService.updateActivityById(id, activity);
//    }

//    @PatchMapping("/update/{activityId}/{userId}")
//    public Activity addUserToActivity(@PathVariable UUID activityId, @PathVariable int userId) {
//        return activityService.addUserToActivity(activityId, userService.getUserById(userId));
//    }
}
