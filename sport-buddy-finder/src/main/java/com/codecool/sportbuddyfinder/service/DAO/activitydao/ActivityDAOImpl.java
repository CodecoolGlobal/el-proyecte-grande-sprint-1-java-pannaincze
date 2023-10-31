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
    public Activity addNewActivity(Activity activity) {
        activities.add(activity);
        return activity;
    }

}
