package com.codecool.sportbuddyfinder.service.DAO;

import com.codecool.sportbuddyfinder.model.activity.Activity;

import java.util.Set;
import java.util.UUID;

public interface ActivityDAO {
    Set<Activity> getAllActivities();
    Activity getActivityById(UUID uuid);
    Activity addActivity(Activity activity);
    Activity deleteActivityById(UUID uuid);
    Activity updateActivityById(UUID uuid);
}
