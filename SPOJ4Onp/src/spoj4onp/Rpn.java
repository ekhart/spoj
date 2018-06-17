/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj4onp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ekh
 */
public class Rpn {
    Queue<String> output;
    Deque<String> operators;
    String rpn;
    int i;
    
    public Rpn(String infixToParse) {
        output = new LinkedList<>();
        operators = new ArrayDeque<>();
        i = 0;
        rpn = parse(infixToParse);
    }

    @Override
    public String toString() {
        return rpn;
    }
    
    private String parse(String line) {
        String result = "";
        Token token;
        for (; hasNextToken(line); i += token.length()) {
            token = new Token(line, i);
            
            if (token.type == Token.Type.NUMBER)
                output.add(token.toString());
            else if (token.type == Token.Type.OPERATOR){
                while (!operators.isEmpty()) { 
                    Token last = new Token(operators.pop());
                    if (last.operator == null) {
                        operators.push(last.toString());
                        break;
                    }
                    if ((token.operator.associativity == Token.Operator.Associativity.Left && token.operator.precedence == last.operator.precedence)
                            ||
                        token.operator.precedence < last.operator.precedence)
                        output.add(last.toString());
                }
                operators.push(token.toString());
            } else if (token.type == Token.Type.LEFT_PAR)
                operators.push(token.toString());
            
            result += token;
        }
        return result;
    }
    
    private boolean hasNextToken(String line) {
        return this.i < line.length();
    }
}

interface CharType {
    boolean isType(char c);
}

class Token {
    private String token;
    Type type;
    Operator operator;

    public Token(String line, int i) {
        char c = line.charAt(i);
        type = Type.Of(c);
        if (type == Type.OPERATOR || type == Type.LEFT_PAR || type == Type.RIGHT_PAR) {
            token = Character.toString(c);
            if (type == Type.OPERATOR)
                operator = new Operator(c);
        } else if (type == Type.NUMBER)
            token = getNumber(line, i);
        else if (type == Type.VAR)
            token = getVariable(line, i);
        else 
            token = "";
    }
    
    public Token(String line) {
        this(line, 0);
    }
    
    public int length() {
        return token.length();
    }

    @Override
    public String toString() {
        return token;
    }
    
    private static String getNumber(String line, int i) {
        return getType(line, i, new CharType() {
            @Override
            public boolean isType(char c) {
                return Character.isDigit(c);
            }
        });
    }
    
    private static String getVariable(String line, int i) {
        return getType(line, i, new CharType() {
            @Override
            public boolean isType(char c) {
                return Character.isLetter(c);
            }
        });
    }
    
    @SuppressWarnings("empty-statement")
    private static String getType(String line, int i, CharType character) {
        String type = "";
        for (char c = line.charAt(i); character.isType(c); c = line.charAt(++i))
            type += c;
        return type;
    }
    
    enum Type { 
        OPERATOR, LEFT_PAR, RIGHT_PAR, NUMBER, VAR, NONE;

        static Type Of(char c) {
            boolean isOperator = c == '^' || c == '+' || c == '-' || c == '*' || c == '\\',
                    isLeftPar = c == '(',
                    isRightPar = c == ')';
            if (isOperator)
                return OPERATOR;
            else if (isLeftPar) 
                return LEFT_PAR;
            else if (isRightPar)
                return RIGHT_PAR;
            else if (Character.isDigit(c))
                return NUMBER;
            else if (Character.isLetter(c))
                return VAR;
            return NONE;
        }
    }
    
    static class Operator {
        private char repr;
        int precedence;
        Associativity associativity;

        public Operator(char c) {
            repr = c;
            if (c == '^') 
                precedence = 4;
            else if (c == '*' || c == '/')
                precedence = 3;
            else if (c == '+' || c == '-')
                precedence = 2;
            associativity = c == '^' ? Associativity.Right : Associativity.Left;
        }
        
        static enum Associativity {
            Right, Left
        }
    }
}
