package com.codecool.sportbuddyfinder.service.DAO.activitydao;

import com.codecool.sportbuddyfinder.model.activity.Activity;

import java.util.Set;
import java.util.UUID;

public interface ActivityDAO {
    Set<Activity> getAllActivities();
    Activity getActivityById(UUID uuid);
    Activity addNewActivity(Activity activity);
    UUID deleteActivityById(UUID uuid);
    Activity updateActivityById(UUID uuid);
}
