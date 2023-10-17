package com.codecool.sportbuddyfinder.service.DAO;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class ActivityDAOImpl implements ActivityDAO {
    private final Set<Activity> activities;

    public ActivityDAOImpl() {
        this.activities = new HashSet<>();
    }

    @Override
    public Set<Activity> getAllActivities() {
        return activities;
    }

    @Override
    public Activity getActivityById(UUID uuid) {
        return activities.stream().filter(activity -> activity.getUuid().equals(uuid)).findFirst().orElseThrow();
    }

    @Override
    public Activity addNewActivity(Activity activity) {
        activities.add(activity);
        return activity;
    }

    @Override
    public UUID deleteActivityById(UUID uuid) {
        activities.removeIf(activity -> activity.getUuid().equals(uuid));
        return uuid;
    }

    @Override
    public Activity updateActivityById(UUID uuid) {
        return null;
    }
}
