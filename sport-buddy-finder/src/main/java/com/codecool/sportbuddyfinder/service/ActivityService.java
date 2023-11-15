package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.exception.ActivityNotFoundException;
import com.codecool.sportbuddyfinder.exception.UserNotFoundException;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.repository.ActivityRepository;
import com.codecool.sportbuddyfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityById(long activityId) {
        return activityRepository.findById(activityId);
    }

    public Optional<List<Activity>> findActivitiesByUserId(long id) {
        return activityRepository.findByUser_Id(id);
    }

    public Activity addNewActivityToDB(Activity activity) {
        activity.setUser(userRepository.findById(activity.getUser().getId()).get());
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Activity updatedActivity, long id) {
        return activityRepository.findById(id)
                .map(activity -> {
                    activity.setTitle(updatedActivity.getTitle());
                    activity.setDescription(updatedActivity.getDescription());
                    activity.setSport(updatedActivity.getSport());
                    activity.setLocation(updatedActivity.getLocation());
                    activity.setMinPeopleToFind(updatedActivity.getMinPeopleToFind());
                    activity.setMaxPeopleToFind(updatedActivity.getMaxPeopleToFind());
                    activity.setPostStatus(updatedActivity.getPostStatus());

                    return activityRepository.save(activity);
                })
                .orElseGet(() -> {
                    updatedActivity.setId(id);
                    return activityRepository.save(updatedActivity);
                });
    }

    public boolean deleteActivityById(long activityId) {
        activityRepository.deleteById(activityId);
        return true;
    }

    public Activity addUserToParticipants(long id, long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        Activity activity = activityRepository.findById(id)
                .orElseThrow(ActivityNotFoundException::new);

        activity.getAppliedUsers().add(user);

        return activityRepository.save(activity);
    }

    public Activity removeUserFromParticipants(long id, long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        Activity activity = activityRepository.findById(id)
                .orElseThrow(ActivityNotFoundException::new);

        activity.getAppliedUsers().remove(user);

        return activityRepository.save(activity);
    }

}
