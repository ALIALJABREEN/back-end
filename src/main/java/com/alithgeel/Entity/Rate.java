package com.alithgeel.Entity;
import sun.security.krb5.internal.Ticket;

import javax.persistence.*;
@Entity
@Table(name = "Rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Rate_id") private Long rate_id;
    @Column(name = "Comments") private String comments;
    @Column(name = "Rate") private  int rate;
    @Column(name = "Is_delete") private boolean is_delete;

    @ManyToOne
    @JoinColumn(name = "review_ticket_id",referencedColumnName = "Ticket_id")
    private Tickets tickets;



    public Tickets getTickets() {
        return tickets;
    }
    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public Long getRate_id() {
        return rate_id;
    }

    public void setRate_id(Long rate_id) {
        this.rate_id = rate_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }
}
