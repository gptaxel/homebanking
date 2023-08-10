package com.mindhub.homebanking.repositories;


import java.util.List;

import com.mindhub.homebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RepositoryRestResource

//@RestController


public interface ClientRepository extends JpaRepository<Client, Long> {


}

//public interface ClientRepository { }
