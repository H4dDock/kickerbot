package com.koval.KickerBot.model;

import javax.persistence.*;

@Table(name = "players_duties")
@Entity
public class PlayersDuties {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debtor_id", referencedColumnName = "id", nullable = false)
    private Player debtor;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id", nullable = false)
    private Player borrower;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duty_id", referencedColumnName = "id", nullable = false)
    private Duty duty;
    @Column(nullable = false)
    private Long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getDebtor() {
        return debtor;
    }

    public void setDebtor(Player debtor) {
        this.debtor = debtor;
    }

    public Player getBorrower() {
        return borrower;
    }

    public void setBorrower(Player borrower) {
        this.borrower = borrower;
    }

    public Duty getDuty() {
        return duty;
    }

    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
