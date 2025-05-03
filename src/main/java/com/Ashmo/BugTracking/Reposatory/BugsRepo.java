package com.Ashmo.BugTracking.Reposatory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ashmo.BugTracking.Model.Bugs;

@Repository
public interface BugsRepo extends JpaRepository<Bugs, Integer> {

    List<Bugs> findByStatus(String status);
    
    List<Bugs> findByPriority(String priority);
    
}
