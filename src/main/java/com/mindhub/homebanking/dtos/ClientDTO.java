package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {
        private Long id;
        private String firstName;
        private String lastName;
        private String clientEmail;

        //Set<Account> accounts = new HashSet<>();

        private Set<AccountDTO> accounts = new HashSet<>();




        public ClientDTO(Client client) {

                this.id = client.getId();

                this.firstName = client.getFirstName();

                this.lastName = client.getLastName();

                this.clientEmail = client.getClientEmail();


                this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());

        }

        public void Client() {
        }

        public void Client(String first, String last) {
                firstName = first;
                lastName = last;
        }


        public void Client(String first, String last, String email) {
                firstName = first;
                lastName = last;
                clientEmail = email;
        }



        public String getFirstName() {
                return firstName;
        }


        public String getLastName() {
                return lastName;
        }



        public String getClientEmail() {
                return clientEmail;
        }



        public String toString() {
                return firstName + " " + lastName + " " + clientEmail;
        }


        public Long getId() {
                return id;
        }


        public Set<AccountDTO> getAccounts() {
                return accounts;
        }





        //ESto no va en el DTO solo en la clase
       /* public void addAccount(AccountDTO account) {
                account.setOwner(this);
                accounts.add(account);
        }*/
};









//this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());

               /* Para usar las cuentas primero llamo las cuentas de client y las paso a stream(.stream) el cual es un objeto iterable
                al cual se le pueden aplicar metedos tales como .map .filter, es parecido a un array de JS, una vez echo eso se hace un map
                y le digo al map que tome cada cuenta y creee una AccountDTO y como sigue siendo un archivo stream y mi propiedad accaounts me pide
                una collecion tipo Set uso el collects .toset() para que sea del tipo que me pide Account por que java es un lenguaje fuertemente tipado.*/


