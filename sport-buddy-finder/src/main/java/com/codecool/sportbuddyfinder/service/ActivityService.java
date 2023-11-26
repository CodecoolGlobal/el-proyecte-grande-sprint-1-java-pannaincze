package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.exception.ActivityNotFoundException;
import com.codecool.sportbuddyfinder.exception.UserNotFoundException;
import com.codecool.sportbuddyfinder.model.DTO.activity.ActivityCardDTO;
import com.codecool.sportbuddyfinder.model.DTO.activity.DisplayActivityDTO;
import com.codecool.sportbuddyfinder.model.DTO.activity.NewActivityDTO;
import com.codecool.sportbuddyfinder.model.DTO.activity.UpdateActivityDTO;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.repository.ActivityRepository;
import com.codecool.sportbuddyfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public List<ActivityCardDTO> getAllActivities() {
        return activityRepository.findAll().stream().map(ActivityCardDTO::new).toList();
    }

    public DisplayActivityDTO getActivityById(long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException(activityId));
        return new DisplayActivityDTO(activity);
    }

    public List<ActivityCardDTO> findActivitiesByUserId(long id){
        return activityRepository.findActivitiesByUserId(id)
                .orElseThrow()
                .stream().map(ActivityCardDTO::new).toList();
    }

    public Activity addNewActivityToDB(NewActivityDTO newActivity) {
        User user = userRepository.findById(newActivity.getUserId()).orElseThrow(() -> new UserNotFoundException(newActivity.getUserId()));
        Activity activity = Activity.builder()
                .title(newActivity.getTitle())
                .description(newActivity.getDescription())
                .sport(newActivity.getSport())
                .location(newActivity.getLocation())
                .minPeopleToFind(newActivity.getMinPeopleToFind())
                .maxPeopleToFind(newActivity.getMaxPeopleToFind())
                .user(user)
                .image(newActivity.getImage())
                .build();

        return activityRepository.save(activity);
    }

    public Activity updateActivity(UpdateActivityDTO updatedActivity, long id) {
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
                //TODO
                .orElseThrow();

    }

    public boolean deleteActivityById(long activityId) {
        activityRepository.deleteById(activityId);
        return true;
    }

    public Activity addUserToParticipants(long activityId, long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException(activityId));

        activity.getAppliedUsers().add(user);

        return activityRepository.save(activity);
    }

    public Activity removeUserFromParticipants(long activityId, long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException(activityId));

        activity.getAppliedUsers().remove(user);

        return activityRepository.save(activity);
    }

}
