/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tddbyexample;

/**
 *
 * @author Ekh
 */
public interface Expression {
    
    Money reduce(Bank bank, String to);
    
    Expression plus(Expression addend);
    
    Expression times(int multiplier);
    
}
