package com.alithgeel.Entity;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "Tickets ")
public class Tickets {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ticket_id")
    private Long ticket_id;
    @Column(name = "Deleting")
    private boolean deleting;
    @Column(name = "attend")
    private  boolean attend;
    private Date ticketdate;
    private String tickettime;
    private String event_name;
    private int rate;
    private String comment;
    private boolean rated;


    @ManyToOne
    @JoinColumn(name ="ticket_user_id",referencedColumnName = "Users_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "ticket_event_id",referencedColumnName = "Event_id")
    private Events events;


    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }


    public String getTickettime() {
        return tickettime;
    }

    public void setTickettime(String tickettime) {
        this.tickettime = tickettime;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public boolean isDeleting() {
        return deleting;
    }

    public void setDeleting(boolean deleting) {
        this.deleting = deleting;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }

    public Date getTicketdate() {
        return ticketdate;
    }

    public void setTicketdate(Date ticketdate) {
        this.ticketdate = ticketdate;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }
}
