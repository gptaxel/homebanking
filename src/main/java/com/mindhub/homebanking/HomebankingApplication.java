package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.mindhub.homebanking.models.Account;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository) {
		return (args) -> {
			// save a couple of customers

			/*Client chloe = clientRepository.save(new Client("Chloe", "O'Brian", "chloe@mindhub.com"));
			Client kim = clientRepository.save(new Client("Kim", "Bauer", "kimb@mindhub.com"));
			Client david =  clientRepository.save(new Client("David", "Palmer", "davidp@mindhub.com"));
			Client michelle = clientRepository.save(new Client("Michelle", "Dessler", "michell@mindhub.com"));*/


			Client jack = new Client("Jack", "Bauer", "jack@mindhub.com");
			Client melba = new Client("Melba", "Morel", "melba@mindhub.com");

			clientRepository.save(jack);
			clientRepository.save(melba);
		//saving accounts

			Account account1 = new Account ("VIN001", LocalDate.now(), 5000D);
			Account account2 = new Account ("VIN002",LocalDate.now().plusDays(1) , 7500D);
			Account account3 = new Account("VIN003", LocalDate.now(), 6000D);
			Account account4 = new Account("VIN004", LocalDate.now(), 500D);
			Account account5 = new Account("VIN005", LocalDate.now(), 7000D);


			//adding accounts

				melba.addAccount(account1);
				melba.addAccount(account2);
				jack.addAccount(account3);
				jack.addAccount(account4);
				jack.addAccount(account5);

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);
			accountRepository.save(account5);

		};
	}

}







		//Recuerda que una cuenta está asociada a un cliente por lo cual debes asociar ambas
		//  cuentas con el cliente Melba. Crea otras cuentas para el segundo cliente.




	//  accountRepository.save(new Account ("VIN001", LocalDate.now(), 5000D));
	//	accountRepository.save(new Account ("VIN002",LocalDate.now().plusDays(1) , 7500D));
























/*
	Client jack = clientRepository.save(new Client("Jack", "Bauer", "jack@mindhub.com"));
	Client chloe = clientRepository.save(new Client("Chloe", "O'Brian", "chloe@mindhub.com"));
	Client kim = clientRepository.save(new Client("Kim", "Bauer", "kimb@mindhub.com"));
	Client david =  clientRepository.save(new Client("David", "Palmer", "davidp@mindhub.com"));

	Client melba = clientRepository.save(new Client("Melba", "Morel", "melba@mindhub.com"));
	Client michelle = clientRepository.save(new Client("Michelle", "Dessler", "michell@mindhub.com"));


	//saving accounts

	Account account1 = accountRepository.save(new Account ("VIN001", LocalDate.now(), 5000D));
	Account account2 = accountRepository.save(new Account ("VIN002",LocalDate.now().plusDays(1) , 7500D));
	Account account3 = accountRepository.save(new Account("VIN003", LocalDate.now(), 6000D));
	Account account4 = accountRepository.save(new Account("VIN004", LocalDate.now(), 500D));
	Account account5 = accountRepository.save(new Account("VIN005", LocalDate.now(), 7000D));

//adding accounts

				melba.addAccount(account1);
						melba.addAccount(account2);
						jack.addAccount(account3);
						jack.addAccount(account4);
						jack.addAccount(account5);

						clientRepository.save(melba);
						clientRepository.save(jack);
*/
