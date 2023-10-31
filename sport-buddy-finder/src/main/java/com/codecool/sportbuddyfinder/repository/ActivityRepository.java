package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {


}
