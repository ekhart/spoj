/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tddbyexample;

/**
 *
 * @author Ekh
 */
public class Money implements Expression {

    protected int amount;
    protected String currency;
    
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && currency.equals(money.currency);
    }
    
    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }
    
    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }
    
    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
    
    public String currency() {
        return currency;
    }
    
    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
    
    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
