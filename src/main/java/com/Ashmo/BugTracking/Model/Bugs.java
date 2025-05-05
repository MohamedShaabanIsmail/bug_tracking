package com.Ashmo.BugTracking.Model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bugs {

    public Bugs(int id, String title, String description, String status, String priority, Users assignedTo,
            Users reportedBy, Date createdDate, Date updatedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.reportedBy = reportedBy;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String status; // e.g., "open", "in progress", "closed"
    private String priority; // e.g., "low", "medium", "high"
    
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Users assignedTo;
    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private Users reportedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date updatedDate;

    @OneToMany(mappedBy = "bug", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Comments> comments;

}
