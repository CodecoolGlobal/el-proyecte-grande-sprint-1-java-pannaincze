package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Optional<Activity> findById(long activityId);
    void deleteById(long activityId);
    Optional<List<Activity>> findByUser_Id(long userId);
    Optional<List<Activity>> findActivitiesByUserId(long userId);


//    Optional<Activity> updateById(long id, Activity activity);
//    Activity addNewActivity(Activity activity);
//    UUID deleteActivityById(UUID uuid);
//    Activity updateActivityById(UUID uuid);
//    Activity addUserToActivity(UUID activityId, User user);

}
