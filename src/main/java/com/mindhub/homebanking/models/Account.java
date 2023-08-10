package com.mindhub.homebanking.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

import javax.persistence.*;


@Entity

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String number;
    private LocalDate creationDate;

    private Double balance;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="owner_id")
    private Client owner;

    public Account() { }

    public Account (String number, LocalDate myDateObj, Double balance) {
        this.number = number;
        this.creationDate = myDateObj;
        this.balance = balance;
    }


    @JsonIgnore
    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }


    public Double getBalance() {
        return balance;
    }

}

