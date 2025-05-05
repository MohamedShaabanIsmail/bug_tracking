package com.Ashmo.BugTracking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashmo.BugTracking.Model.Users;
import com.Ashmo.BugTracking.Reposatory.UsersRepo;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepository;
    
    public void addUser(Users user) {
        usersRepository.save(user);
    }

    public Users getUserById(int id) {
        return usersRepository.findById(id).orElse(null);
    }
    
}
