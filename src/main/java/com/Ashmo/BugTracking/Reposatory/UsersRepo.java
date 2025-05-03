package com.Ashmo.BugTracking.Reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ashmo.BugTracking.Model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>{
    
}
