/*
 * Calculator class for Chapter17Problem3.java
 */

package chapter17problem3;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton; 
import javax.swing.UIManager; 
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 200;
    public static final int HEIGHT = 200;
    public static final int NUMBER_OF_DIGITS = 20;
    private String[] symbols = {
        "7", "8", "9", "/",
        "4", "5", "6", "X",
        "1", "2", "3", "-",
        "0", ".", "=", "+"};
    
    private JPanel outputPanel;
    private JPanel inputPanel;
    private JPanel controlPanel;
    private JTextField operandField;
    private JTextField resultField;
    private JButton[] buttons;
    private JButton clear;
    private JButton reset;
    private String actionClicked;
    
    public Calculator()
    {
        super("Calculator");
        setLayout(new BorderLayout());
        setSize(200, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        outputPanel = new JPanel(new GridLayout(4, 0));
        resultField = new JTextField("0.0", 10);
        resultField.setVisible(true);
        resultField.setEditable(false);
        operandField = new JTextField(10);
        operandField.setVisible(true);
        operandField.setEditable(false);
        outputPanel.add(new JLabel("Result"));
        outputPanel.add(resultField);
        outputPanel.add(new JLabel("Operand"));
        outputPanel.add(operandField);
        add(outputPanel, BorderLayout.NORTH);

        controlPanel = new JPanel(new GridLayout(1, 0));
        clear = new JButton("Clear");
        clear.setActionCommand("c");
        clear.setVisible(true);
        clear.addActionListener(this);
        controlPanel.add(clear);
        reset = new JButton("Reset");
        reset.setActionCommand("r");
        reset.setVisible(true);
        reset.addActionListener(this);
        controlPanel.add(reset);
        add(controlPanel, BorderLayout.CENTER);

        inputPanel = new JPanel(new GridLayout(4, 4));

        buttons = new JButton[16];
        for(int i = 0; i < 16; i++)
        {
            buttons[i] = new JButton("" + symbols[i]);
            buttons[i].setActionCommand(symbols[i]);
            buttons[i].setVisible(true);
            buttons[i].addActionListener(this);
            inputPanel.add(buttons[i]);    
        }
        add(inputPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        double resultFieldNumber, operandFieldNumber, answer;

        if(action.equals("+") || action.equals("-") || action.equals("X")
                || action.equals("/"))
        {
            if(operandField.getText().length() == 0)
                return;
            
            operandFieldNumber = Double.parseDouble(operandField.getText());
            resultField.setText(Double.toString(operandFieldNumber));
            operandField.setText("");
            actionClicked = action;
        }

        else if(action.equals("="))
        {
            if(operandField.getText().length() == 0)
                return;
            
            switch(actionClicked)
            {
                case "+":
                    resultFieldNumber = Double.parseDouble(resultField.getText());
                    operandFieldNumber = Double.parseDouble(operandField.getText());
                    answer = resultFieldNumber + operandFieldNumber;
                    resultField.setText(Double.toString(answer));
                    operandField.setText("");
                    break;
                
                case "-":
                    resultFieldNumber = Double.parseDouble(resultField.getText());
                    operandFieldNumber = Double.parseDouble(operandField.getText());
                    answer = resultFieldNumber - operandFieldNumber;
                    resultField.setText(Double.toString(answer));
                    operandField.setText("");
                    break;

                case "X":
                    resultFieldNumber = Double.parseDouble(resultField.getText());
                    operandFieldNumber = Double.parseDouble(operandField.getText());
                    answer = resultFieldNumber * operandFieldNumber;
                    resultField.setText(Double.toString(answer));
                    operandField.setText("");
                    break;
                
                case "/":
                    resultFieldNumber = Double.parseDouble(resultField.getText());
                    operandFieldNumber = Double.parseDouble(operandField.getText());
                    if (operandFieldNumber > -1.e-10 && operandFieldNumber < 1e-10)
                    {
                        try
                        {
                            throw new DivisionByZeroException();
                        }
                        
                        catch(DivisionByZeroException err)
                        {
                            operandField.setText("Division by Zero");
                            break;
                        }
                    }
                    answer = resultFieldNumber / operandFieldNumber;
                    resultField.setText(Double.toString(answer));
                    operandField.setText("");
                    break;

                case "c":
                    operandField.setText("");
                    break;

                case "r":
                    resultField.setText("0.0");
                    operandField.setText("");
                    break;
                
                case ".":
                    String operandFieldText = operandField.getText() + ".";
                    operandField.setText(operandFieldText);
            }
        }
        
        else
        {
            switch(action)
            {
                case "1":
                    operandField.setText(operandField.getText() + "1");
                    break;
                    
                case "2":
                    operandField.setText(operandField.getText() + "2");
                    break;
                    
                case "3":
                    operandField.setText(operandField.getText() + "3");
                    break;
                    
                case "4":
                    operandField.setText(operandField.getText() + "4");
                    break;
                
                case "5":
                    operandField.setText(operandField.getText() + "5");
                    break;
                    
                case "6":
                    operandField.setText(operandField.getText() + "6");
                    break;
                
                case "7":
                    operandField.setText(operandField.getText() + "7");
                    break;
                    
                case "8":
                    operandField.setText(operandField.getText() + "8");
                    break;
                    
                case "9":
                    operandField.setText(operandField.getText() + "9");
                    break;
                    
                case "0":
                    operandField.setText(operandField.getText() + "0");
                    break;
                
                case ".":
                    operandField.setText(operandField.getText() + ".");
                    break;
            }
        }
    }
}
