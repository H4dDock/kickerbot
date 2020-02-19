package com.koval.KickerBot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "players-duties")
@Entity
public class PlayersDuties {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debtor_id", referencedColumnName = "id", nullable = false)
    private Player debtor;
    @Column(nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id", nullable = false)
    private Player borrower;
    @Column(nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
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
