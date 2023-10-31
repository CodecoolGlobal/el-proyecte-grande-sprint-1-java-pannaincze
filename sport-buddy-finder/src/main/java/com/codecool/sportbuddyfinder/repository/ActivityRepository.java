package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
//Set<Activity> getAllActivities();
//    Activity getActivityById(UUID uuid);
//    Activity addNewActivity(Activity activity);
//    UUID deleteActivityById(UUID uuid);
//    Activity updateActivityById(UUID uuid);
//    Activity addUserToActivity(UUID activityId, User user);

}
