package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.service.DAO.activitydao.ActivityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class ActivityService {
    private final ActivityDAO activityDAO;

    @Autowired
    public ActivityService(ActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }

    public Set<Activity> getAllActivities() {
        return activityDAO.getAllActivities();
    }
    public Activity getActivityById(UUID uuid) {
        return activityDAO.getActivityById(uuid);
    }
    public Activity addNewActivity(Activity activity) {
        return activityDAO.addNewActivity(activity);
    }
    public UUID deleteActivityById(UUID uuid) {
        return activityDAO.deleteActivityById(uuid);
    }
    public Activity updateActivityById(UUID uuid) {
        return activityDAO.updateActivityById(uuid);
    }
    public Activity addUserToActivity(UUID activityId, User user) {
        return activityDAO.addUserToActivity(activityId, user);
    }
}
