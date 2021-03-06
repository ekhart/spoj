/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tddbyexample;

/**
 *
 * @author Ekh
 */
public class Sum implements Expression {
    Expression augend, addend;

    Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount 
                    + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return null;
    }
    
    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
