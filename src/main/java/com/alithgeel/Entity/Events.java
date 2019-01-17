package com.alithgeel.Entity;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Events")
public class Events {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Event_id ")
    private Long event_id;

    @NotNull(message = "The Event can not be Null")
    @Size(min = 3 , max = 25,message = "the Event Name must be between 3 to 25 characters")
    @Column(name = "EventName")
    private String Event_name;

    @NotNull(message = "The City can not be Null")
    @Size(min = 3, max = 15,message = "the city must be between 3 to 15 characters")
    @Column(name = "City")
    private  String city;

    @NotNull
    @Size(min = 1, max = 250,message = "the city must be between 1 to 250 characters")
    @Column(name = "Description")
    private String description;

    @NotNull(message = "The Capacity can not be Null")
    @Max(value = 300,message = "The  Max Capacity of Event is 300")
    @Column(name = "Capacity")
    private int capacity;

    @Column(name = "ETime")
    private String time;
    @Column(name = "EDate")
    private Date date;
    @Column(name = "Approved")
    private  boolean approved;
    @Column(name = "Deleting")
    private boolean deleting;
    @Column(name = "Count")
    private int count=0;


    @OneToMany(mappedBy = "events",fetch = FetchType.EAGER)
    private List<Comment> eventcomment;

    @ManyToOne
    @JoinColumn(name ="event_user_id",referencedColumnName = "Users_id")
    private Users users;







    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Comment> getEventcomment() {
        return eventcomment;
    }

    public void setEventcomment(List<Comment> eventcomment) {
        this.eventcomment = eventcomment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isDeleting() {
        return deleting;
    }

    public void setDeleting(boolean deleting) {
        this.deleting = deleting;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEvent_name(String event_name) {
        Event_name = event_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
