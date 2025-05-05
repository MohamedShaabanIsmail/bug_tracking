package com.Ashmo.BugTracking.Service;

import java.util.Date;
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

    public Bugs createBug(Bugs bug) {
        bug.setCreatedDate(new Date(System.currentTimeMillis()));
        bug.setStatus("new");
        return bugsRepo.save(bug);
    }

    public Bugs updateBug(Bugs bug) {
        return bugsRepo.save(bug);
    }

    public List<Bugs> getBugsByStatus(String status) {
        return bugsRepo.findByStatus(status);
    }

    public List<Bugs> getBugsByPriority(String priority) {
        return bugsRepo.findByPriority(priority);
    }

    public boolean deleteBug(int id) {
        if (bugsRepo.existsById(id)){
            bugsRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
}
