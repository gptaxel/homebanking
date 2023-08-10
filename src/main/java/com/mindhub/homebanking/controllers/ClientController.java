package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    //servlet
    @RequestMapping("/clients")
    public List<ClientDTO> getClients() {
        return clientRepository.findAll().stream().map(ClientDTO::new).collect(toList());
    }

    @RequestMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable Long id) {

        return  clientRepository.findById(id).map(ClientDTO::new).orElse(null);

    }

}


   /* @RequestMapping("/clients{id}")
    public List<ClientDTO> getClient(@PathVariable Long id) {

        return  clientRepository.findById(id).map(ClientDTO::new).orElse(null);

    }*/



//return Collections.singletonList(clientRepository.findById(id).map(ClientDTO::new).orElse(null));

//return clientRepository.findById(id).map(ClientDTO::new).orElse(null);

//return clientRepository.findById(id).map(ClientDTO::new).orElse(null);



   /* public ClientDTO getClient(@PathVariable Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        return clientOptional.map(client -> new ClientDTO(client.getId(), client.getName()))
                .orElse(null);
    }
*/


// return clientRepository.findAll().stream().map(client -> new ClientDTO(client)).collect(toList());