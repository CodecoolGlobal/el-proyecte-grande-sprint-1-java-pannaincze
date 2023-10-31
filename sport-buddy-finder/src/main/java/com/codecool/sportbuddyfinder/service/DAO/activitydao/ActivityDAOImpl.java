package com.codecool.sportbuddyfinder.service.DAO.activitydao;

import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import org.springframework.stereotype.Repository;

import java.util.*;

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
        // return activities.stream().filter(activity -> activity.getUuid().equals(uuid)).findFirst().orElseThrow();
        return null;
    }


    @Override
    public Activity addNewActivity(Activity activity) {
        activities.add(activity);
        return activity;
    }

    @Override
    public UUID deleteActivityById(UUID uuid) {
        // activities.removeIf(activity -> activity.getUuid().equals(uuid));
        return null;
    }

    @Override
    public Activity updateActivityById(UUID uuid) {
        return null;
    }

    @Override
    public Activity addUserToActivity(UUID activityId, User user) {
        for (Activity activity : activities) {
            /*if (activity.getUuid().equals(activityId)) {
                if (activity.addUserToAppliedSet(user)) {
                    activity.addUserToAppliedSet(user);
                    return activity;
                }
            }*/
        }

        return null;
    }


}
