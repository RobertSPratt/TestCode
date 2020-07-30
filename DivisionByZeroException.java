/*
 *DivisionByZeroException for Chapter17Problem3.java
 */
package chapter17problem3;

public class DivisionByZeroException extends Exception
{
    public DivisionByZeroException()
    {
        super("Division By Zero");
    }
    
    public DivisionByZeroException(String message)
    {
        super(message);
    }
}
