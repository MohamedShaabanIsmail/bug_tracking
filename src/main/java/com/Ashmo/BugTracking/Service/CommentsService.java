package com.Ashmo.BugTracking.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashmo.BugTracking.Model.Comments;
import com.Ashmo.BugTracking.Reposatory.CommentsRepo;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepo commentRepo;
    
    public Comments createComment(Comments comment) {
        comment.setCreatedDate(new Date(System.currentTimeMillis()));
        return commentRepo.save(comment);
    }

    public boolean deleteComment(int id) {
        if (commentRepo.existsById(id)) {
            commentRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Comments> getCommentsByBugId(int bugId) {
        return commentRepo.findByBugId(bugId);
    }

    public Comments getCommentById(int id) {
        return commentRepo.findById(id).orElse(null);
    }
    
}
