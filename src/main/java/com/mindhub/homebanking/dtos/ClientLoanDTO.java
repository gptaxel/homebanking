package com.mindhub.homebanking.dtos;


import com.mindhub.homebanking.models.ClientLoan;

public class ClientLoanDTO {
    private Long id;
    private Long loan;
    private String name;

    private Double amount;
    private Integer payments;






    public ClientLoanDTO() {

    }

    /*public ClientLoanDTO(Long id, Long loan, String name, Double amount, Integer payments) {
            this.id = id;
            this.loan = loan;
            this.name = name;
            this.amount = amount;
            this.payments = payments;
        }*/
    public ClientLoanDTO(ClientLoan clientLoan){
        this.id=clientLoan.getId();
        this.loan=clientLoan.getLoan().getId();
        this.name=clientLoan.getLoan().getName();
        this.amount=clientLoan.getAmount();
        this.payments=clientLoan.getPayment();

    }


    public Long getId() {
        return id;
    }


    public Long getLoan() {
        return loan;
    }


    public String getName() {
        return name;
    }


    public Double getAmount() {
        return amount;
    }


    public Integer getPayments() {
        return payments;
    }
}
