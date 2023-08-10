package com.mindhub.homebanking.models;

import com.mindhub.homebanking.repositories.ClientRepository;
import org.hibernate.annotations.GenericGenerator;
//import org.springframework.data.annotation.Id;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;


@RestController

@SpringBootApplication
@Entity
//
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @OneToMany(mappedBy="owner", fetch=FetchType.EAGER)
    Set<Account> accounts = new HashSet<>();

    private String firstName;
    private String lastName;
    private String clientEmail;

    //@javax.persistence.Id



    public Client() {
    }

    public Client(String first, String last) {
        firstName = first;
        lastName = last;
    }


    public Client(String first, String last, String email) {
        firstName = first;
        lastName = last;
        clientEmail = email;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String toString() {
        return firstName + " " + lastName + " " + clientEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    //------------

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        account.setOwner(this);
        accounts.add(account);
    }


}



       /* package com.mindhub.homebanking.models;

        import com.mindhub.homebanking.repositories.ClientRepository;
        import org.hibernate.annotations.GenericGenerator;
        //import org.springframework.data.annotation.Id;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.persistence.Entity;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RestController;

        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;*/
