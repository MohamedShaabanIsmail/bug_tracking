package com.Ashmo.BugTracking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashmo.BugTracking.Model.Bugs;
import com.Ashmo.BugTracking.Reposatory.BugsRepo;

@Service
public class BugsService {

    @Autowired
    private BugsRepo bugsRepo;
    
    public List<Bugs> getAllBugs() {
        return bugsRepo.findAll();
    }

    public Bugs getBugById(int id) {
        return bugsRepo.findById(id).orElse(null);
    }

    public Bugs createOrUpdateBug(Bugs bug) {
        return bugsRepo.save(bug);
    }

    public List<Bugs> getBugsByStatus(String status) {
        return bugsRepo.findByStatus(status);
    }

    public List<Bugs> getBugsByPriority(String priority) {
        return bugsRepo.findByPriority(priority);
    }
    
}
