package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.Set;

import static com.mindhub.homebanking.models.TransactionType.CREDIT;
import static com.mindhub.homebanking.models.TransactionType.DEBIT;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository,
									  TransactionRepository transactionRepository, LoanRepository loanRepository,
									  ClientLoanRepository clientLoanRepository) {
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

				/*clientRepository.save(melba);
				clientRepository.save(jack);*/


		//transactions

			Transaction transaction1 = new Transaction(DEBIT, -2500D, "Taxes", LocalDateTime.now());
			Transaction transaction2 = new Transaction(DEBIT, -7500D, "Payments", LocalDateTime.now());
			Transaction transaction3 = new Transaction(CREDIT, 8500D, "Expenses", LocalDateTime.now());
			Transaction transaction4 = new Transaction(CREDIT, 7000D, "Payments", LocalDateTime.now());
			Transaction transaction5 = new Transaction(DEBIT, -10000D, "Payments", LocalDateTime.now());
			Transaction transaction6 = new Transaction(DEBIT, -300D, "Payments", LocalDateTime.now());
			Transaction transaction7 = new Transaction(CREDIT, 77500.50D, "Payments", LocalDateTime.now());
			Transaction transaction8 = new Transaction(DEBIT, -75.00D, "Expenses", LocalDateTime.now());
			Transaction transaction9 = new Transaction(CREDIT, 500D, "Payments", LocalDateTime.now());
			Transaction transaction10 = new Transaction(DEBIT, -22000D, "Taxes", LocalDateTime.now());
			Transaction transaction11 = new Transaction(DEBIT, -3000D, "Payments", LocalDateTime.now());



		//adding transactions
			account1.addTransaction(transaction1);
			account1.addTransaction(transaction2);
			account1.addTransaction(transaction3);
			account2.addTransaction(transaction4);
			account2.addTransaction(transaction5);
			account3.addTransaction(transaction6);
			account3.addTransaction(transaction7);
			account4.addTransaction(transaction8);
			account4.addTransaction(transaction9);
			account5.addTransaction(transaction10);
			account5.addTransaction(transaction11);


			//save transactions

			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);
			transactionRepository.save(transaction4);
			transactionRepository.save(transaction5);
			transactionRepository.save(transaction6);
			transactionRepository.save(transaction7);
			transactionRepository.save(transaction8);
			transactionRepository.save(transaction9);
			transactionRepository.save(transaction10);
			transactionRepository.save(transaction11);


				/*accountRepository.save(account1);
				accountRepository.save(account2);
				accountRepository.save(account3);
				accountRepository.save(account4);
				accountRepository.save(account5);*/

// Ejemploooooo

				Client axel = new Client ("Axel", "Riveros", "riverosaxeln@gmail.com");

			System.out.println(axel);
			clientRepository.save(axel);
			System.out.println(axel);

			Account x = new Account("VIN00X", LocalDate.now(), 5000D);

			axel.addAccount(x);

			accountRepository.save(x);

			//Crear Transaccion nueva

			//Agregar transaccion a la cuenta

			//Guardar la transaccion


		//PRESTAMOS - Data Prueba

			Loan mortgage = new Loan("Hipotecario", 500000D, Set.of(12, 24, 36, 48, 60));
			Loan personal = new Loan("Personal", 100000D, Set.of(6, 12, 24));
			Loan automotive = new Loan("Automotriz", 300000D, Set.of(6, 12, 24, 36));



				loanRepository.save(mortgage);
				loanRepository.save(personal);
				loanRepository.save(automotive);


			ClientLoan hipotecario1 = new ClientLoan( 400000D, 60);
			ClientLoan personal1 = new ClientLoan( 50000D, 12);

			ClientLoan personal2 = new ClientLoan( 100000D, 24);
			ClientLoan automotriz = new ClientLoan( 200000D, 36);


		//Añadir prestamos

			//hipotecario1.addClient(melba);

			melba.addClientLoan(hipotecario1);
			//hipotecario1.addLoan(mortgage);
			mortgage.addClientLoan(hipotecario1);

			clientLoanRepository.save(hipotecario1);


			//personal1.setClient(melba);
			melba.addClientLoan(personal1);

			//personal1.setLoan(personal);
			personal.addClientLoan(personal1);
			clientLoanRepository.save(personal1);


			//personal2.setClient(jack);
			jack.addClientLoan(personal2);

			//personal2.setLoan(personal);
			personal.addClientLoan(personal2);
			clientLoanRepository.save(personal2);


			//automotriz.setClient(jack);
			jack.addClientLoan(automotriz);

			//automotriz.setLoan(automotive);
			automotive.addClientLoan(automotriz);
			clientLoanRepository.save(automotriz);


		};
	}

}






	/*La relación debe ser muchos a muchos ya que un cliente puede solicitar muchos préstamos y
	un préstamo puede ser solicitado por muchos clientes. A diferencia de las transacciones en
		que existe una transacción única asociada por cuenta, en este esquema el préstamo define
		las bases de uno, como el monto máximo que se permite solicitar, la cantidad de pagos en
		que se puede pagar y el nombre. Es cuando se asocia a un cliente que se define el monto
		exacto solicitado por el cliente y en cuantas cuotas lo pagará. Así no tiene que repetirse toda
		la información del préstamo por cada cliente.*/



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
