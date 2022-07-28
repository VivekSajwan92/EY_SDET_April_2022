package org.example;

public class Payment {

    private Card card;

    public Payment(Card card) {
        this.card = card;
    }

    public void paymentForBoughtItems(long amount){
        System.out.println("payment through the debit card");
    }

    public static void main(String[] args) {
        Card debitCard = new DebitCard();
        Card creditCard = new CreditCard();
        Payment payment=new Payment(creditCard);
        payment.paymentForBoughtItems(500);
    }
}
