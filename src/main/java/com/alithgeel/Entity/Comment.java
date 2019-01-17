package com.alithgeel.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comment")
public class Comment {
    @JsonIgnore
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column  private long id;
    @Size(min = 1,max = 40,message = "the max comment is 5 characters")
    @Column  private String comment;
    @Column  private LocalDateTime localDateTime;
     @Column  private boolean deleting;


    @ManyToOne
    @JoinColumn(name ="comment_user_id",referencedColumnName = "Users_id")
    @JsonIgnore
    private Users users;
    @ManyToOne
    @JoinColumn(name = "comment_event_id",referencedColumnName = "Event_id")
    @JsonIgnore
    private Events events;


    public boolean isDeleting() {
        return deleting;
    }

    public void setDeleting(boolean deleting) {
        this.deleting = deleting;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
