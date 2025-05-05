package com.Ashmo.BugTracking.Reposatory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ashmo.BugTracking.Model.Bugs;

@Repository
public interface BugsRepo extends JpaRepository<Bugs, Integer> {

    @Query("SELECT new Bugs(b.id, b.title, b.description, b.status, "
        +"b.priority, b.assignedTo, b.reportedBy, b.createdDate, b.updatedDate) FROM Bugs b")
    List<Bugs> findAll();

    List<Bugs> findByStatus(String status);
    
    List<Bugs> findByPriority(String priority);
    
}
