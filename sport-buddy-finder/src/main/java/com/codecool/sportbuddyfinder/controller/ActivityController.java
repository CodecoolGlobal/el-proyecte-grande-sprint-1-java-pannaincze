package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.DTO.NewActivityDTO;
import com.codecool.sportbuddyfinder.model.DTO.UpdateActivityDTO;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;
import com.codecool.sportbuddyfinder.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/{id}")
    public Optional<Activity> getActivityById(@PathVariable long id) {
        return activityService.getActivityById(id);
    }

    @GetMapping("/user-id/{user_id}")
    public Optional<List<Activity>> getActivitiesByUserId(@PathVariable long user_id) {
        return activityService.findActivitiesByUserId(user_id);
    }
    @GetMapping("/categories")
    public Sport[] getAllSport(){
        return Sport.values();
    }

    @PostMapping("/create")
    public Activity addNewActivity(@RequestBody NewActivityDTO activity) {
        return activityService.addNewActivityToDB(activity);
    }

    @PutMapping("/update/{id}")
    public Activity updateActivity(@RequestBody UpdateActivityDTO updatedActivity, @PathVariable long id) {
        return activityService.updateActivity(updatedActivity, id);
    }
    @PutMapping("/update/{id}/{userId}")
    public Activity addUserToParticipants(@PathVariable long id, @PathVariable long userId) {
        return activityService.addUserToParticipants(id, userId);
    }
    @DeleteMapping("/update/{id}/{userId}")
    public Activity removeUserFromParticipants(@PathVariable long id, @PathVariable long userId) {
        return activityService.removeUserFromParticipants(id, userId);
    }

    @DeleteMapping("/{id}")
    public boolean deleteActivityById(@PathVariable long id) {
        return activityService.deleteActivityById(id);
    }
}
