package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.repository.ActivityRepository;
import com.codecool.sportbuddyfinder.repository.UserRepository;
import com.codecool.sportbuddyfinder.service.DAO.activitydao.ActivityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final RestTemplate restTemplate;
    private final ActivityDAO activityDAO;
    private final UserRepository userRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, RestTemplate restTemplate, ActivityDAO activityDAO, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.restTemplate = restTemplate;
        this.activityDAO = activityDAO;
        this.userRepository = userRepository;
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
    public Optional<Activity> getActivityById(long activityId) {
        return activityRepository.findById(activityId);
    }
    public Activity addNewActivityToDB(Activity activity) {
        activity.setUser(userRepository.findById(activity.getUser().getId()).get());
        return activityRepository.save(activity);
    }
    public boolean deleteActivityById(long activityId) {
        activityRepository.deleteById(activityId);
        return true;
    }

    //    public Activity updateActivityById(long activityId, Activity activity) {
//        Activity updatedActivity = activityRepository.updateById(activityId, activity).orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + activityId));
//
//        activity.setId(updatedActivity.getId());
//        activity.setTitle(activity.getTitle());
//        activity.setDescription(activity.getDescription());
//        activity.setSport(activity.getSport());
//        activity.setLocation(activity.getLocation());
//        activity.setMinPeopleToFind(activity.getMinPeopleToFind());
//        activity.setMaxPeopleToFind(activity.getMaxPeopleToFind());
//        activity.setUser(activity.getUser());
//        activity.setPostStatus(activity.getPostStatus());
//        //needs fix
//        //activity.addUsersToAppliedSet(activity.getAppliedUsers());
//
//        return activityRepository.save(updatedActivity);
//    }
//    public Activity addUserToActivity(UUID activityId, User user) {
//        return activityDAO.addUserToActivity(activityId, user);
//    }
}
