package com.yuriysurzhikov.gidassistant.controllers.interests;

import com.yuriysurzhikov.gidassistant.model.db.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestsRepository extends JpaRepository<Interest, String> {
    Interest findByName(String name);
}
