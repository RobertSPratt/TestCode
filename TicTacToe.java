/*
 * TicTacToe Class for Chapter17Problem2.java
 */
package chapter17problem2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TicTacToe extends JFrame implements ActionListener
{
    private JButton[] buttons;
    private boolean isXTurn;
    private boolean gameIsOver;
    private JLabel playerTurn;
    private JPanel spaces;
    
    private final int X_SPACE = 1;
    private final int O_SPACE = 0;
    
    private final int[][] WINNING_COMBINATIONS = new int[][]
    {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };
    
    private int[] selectedSpaces;

    public TicTacToe()
    {
        super("TicTacToe");
        setLayout(new BorderLayout());
        setSize(250,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        playerTurn = new JLabel("X's Turn");
        playerTurn.setVisible(true);
        add(playerTurn, BorderLayout.NORTH);
        
        spaces = new JPanel(new GridLayout(3, 3));
        spaces.setVisible(true);
        buttons = new JButton[9];
        selectedSpaces = new int[9];
        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton("");
            buttons[i].setEnabled(true);
            buttons[i].setActionCommand(Integer.toString(i));
            buttons[i].addActionListener(this);
            buttons[i].setVisible(true);
            spaces.add(buttons[i]);
            selectedSpaces[i] = 2;
        }
        
        add(spaces, BorderLayout.CENTER);
        isXTurn = true;
        gameIsOver = false;
    }
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        String action = e.getActionCommand();
        
        switch(action)
        {
            case "0":
                if(isXTurn == true)
                {
                    xTurn(Integer.parseInt(action));
                }
                else
                {
                    oTurn(Integer.parseInt(action));
                }
                break;
                
            case "1":
                if(isXTurn == true)
                {
                    xTurn(Integer.parseInt(action));
                }
                else
                {
                    oTurn(Integer.parseInt(action));
                }
                break;
                
            case "2":
                if(isXTurn == true)
                {
                    xTurn(Integer.parseInt(action));
                }
                else
                {
                    oTurn(Integer.parseInt(action));
                }
                break;
            
            case "3":
                if(isXTurn == true)
                {
                    xTurn(Integer.parseInt(action));
                }
                else
                {
                    oTurn(Integer.parseInt(action));
                }
                break;
                
            case "4":
                if(isXTurn == true)
                {
                    xTurn(Integer.parseInt(action));
                }
                else
                {
                    oTurn(Integer.parseInt(action));
                }
                break;
                
            case "5":
                if(isXTurn == true)
                {
                    xTurn(Integer.parseInt(action));
                }
                else
                {
                    oTurn(Integer.parseInt(action));
                }
                break;
                
            case "6":
                if(isXTurn == true)
                    xTurn(Integer.parseInt(action));
                else
                    oTurn(Integer.parseInt(action));
                break;
                
            case "7":
                if(isXTurn == true)
                    xTurn(Integer.parseInt(action));
                else
                    oTurn(Integer.parseInt(action));
                break;
            
            case "8":
                if(isXTurn == true)
                    xTurn(Integer.parseInt(action));
                else
                    oTurn(Integer.parseInt(action));
                break;
        }
    }
    
    private void xTurn(int i)
    {
        buttons[i].setText("X");
        buttons[i].setEnabled(false);
        selectedSpaces[i] = 1;
        isXTurn = false;
        playerTurn.setText("O's Turn");
        checkForGameEnd();
    }
    
    private void oTurn(int i)
    {
        buttons[i].setText("O");
        buttons[i].setEnabled(false);
        selectedSpaces[i] = 0;
        isXTurn = true;
        playerTurn.setText("X's Turn");
        checkForGameEnd();
    }
    
    private void checkForGameEnd()
    {
        int[] spaces = new int[3];
        int count = 0;
        for(int i = 0; i < 8; i++)
        {
            System.arraycopy(WINNING_COMBINATIONS[i], 0, spaces, 0, 3);
                
            if(selectedSpaces[spaces[0]] == selectedSpaces[spaces[1]] &&
                    selectedSpaces[spaces[1]] == selectedSpaces[spaces[2]])
            {
                declareWinner(selectedSpaces[spaces[0]]);
                break;
            }
        }
        
        for(int i = 0; i < 9; i++)
        {
            if(selectedSpaces[i] == 2)
                count++;
        }
        
        if(count == 0)
            declareWinner(2);
        
    }
    
    private void declareWinner(int i)
    {
        int winner = i;
        switch(winner)
        {
            case 0:
                playerTurn.setText("O is the Winner!");
                for(int j = 0; j < 8; j++)
                    buttons[j].setEnabled(false);
                break;
             
            case 1:
                playerTurn.setText("X is the Winner!");
                for(int j = 0; j < 8; j++)
                    buttons[j].setEnabled(false);
                break;
                
            case 2:
                playerTurn.setText("It's a Tie!");
                break;
                
            default:
                if(isXTurn == true)
                    playerTurn.setText("X's Turn");
                else
                    playerTurn.setText("O's Turn");
        }
        
    }
}
