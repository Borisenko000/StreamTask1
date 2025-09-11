package edu.polina.generic6;

/*
Money (валюта как строка, сумма в «центах» как long).
 merge разрешён только при совпадении валют; иначе — IllegalArgumentException.
 */

public class Money implements Mergeable<Money>{
    String valute;
    long cents;

    public Money(String valute, long cents) {
        this.valute = valute;
        this.cents = cents;
    }

    @Override
    public Money merge(Money other) {
        if ((this.valute).equals(other.valute)) {
            return new Money(this.valute, this.cents + other.cents);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Money: cents = " + cents;
    }
}
