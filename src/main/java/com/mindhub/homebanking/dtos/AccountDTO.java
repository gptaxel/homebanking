package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;

public class AccountDTO {
    private long id;
    private String number;
    private LocalDate creationDate;
    private Double balance;

    //BUG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private ClientDTO owner;

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    public AccountDTO(Account account){
        this.id=account.getId();
        this.number=account.getNumber();
        this.creationDate=account.getCreationDate();
        this.balance=account.getBalance();

    }




   /* public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }*/

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



    public ClientDTO getOwner() {
        return owner;
    }

    public void setOwner(ClientDTO owner) {
        this.owner = owner;
    }


}




