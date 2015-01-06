
/*Grace Yao, Andrea Kim, Lydia Hwang, Michelle Jang.
 *      :D
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
// import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import java.util.Random;

public class test2
{
    private ArrayList<String> elements;
    
    test2()
    {
        elements = new ArrayList<String>();
        
        try
        {
            readInElementsByLine();
        }
        catch (IOException e)
        {
            System.out.println( "Error: " + e );
        }
    }
    
    public void readInElementsByLine() throws IOException 
    {
        FileReader fin = new FileReader("elements.txt");
        StringTokenizer strTok;  // newly added
        String line = new String();  // changed name from input to line
        String wrd;  // newly added
        Scanner src = new Scanner(fin);
        while(src.hasNextLine())
        {
            line = src.nextLine();
            strTok = new StringTokenizer(line);
            //System.out.println(input); // echo book to console
            while(strTok.hasMoreTokens())
            {
                wrd = strTok.nextToken();
                elements.add(wrd);
            }
             elements.add("\n");   // that's a backslash
        }
    }
    
    public static void main(String[] args)
    {        
        JFrame frame = new JFrame();
        JButton buttonL = new JButton("Learn about a random element.");
        JButton buttonS = new JButton("Search for an element.");
        JButton buttonQ = new JButton("Quiz");
        JPanel panel = new JPanel();
        panel.add(buttonL);
        panel.add(buttonS);
        panel.add(buttonQ);
        frame.add(panel);
        
        class learnListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                test2 bleh = new test2();
                Random nGenerator = new Random();
                int number = 118;
                int elementNumber = (int)(nGenerator.nextInt(number))+1;
                int nextElementNumber = elementNumber + 1;
                String Number = Integer.toString(elementNumber);
                String nextNumber = Integer.toString(nextElementNumber);
                int elementIndex = 0;
                int nextElementIndex = bleh.elements.size();
                for(int i = 0; i < bleh.elements.size(); i++)
                {
                    if(bleh.elements.get(i).equals("~" + Number + "~"))
                    {
                        elementIndex = i;
                    }
                    if(bleh.elements.get(i).equals("~" + nextNumber + "~"))
                    {
                        nextElementIndex = i;
                    }
                }
                String testtest = " ";
                for(int i = elementIndex; i < nextElementIndex; i++)
                {
                    testtest += bleh.elements.get(i);
                    testtest += " ";
                    //System.out.println(bleh.elements.get(i));
                }
                JOptionPane.showMessageDialog(null, testtest);
            }
        }
        class searchListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                test2 bleh = new test2();
                String element;
                element = JOptionPane.showInputDialog("Would you like to search by (Enter A, B, or C):  \n (A) Atomic number     OR     (B) Element name     OR     (C) Element symbol?");
                String input;
                int elementNumber = 0;
                if(element.equalsIgnoreCase("A"))
                {
                    input = JOptionPane.showInputDialog("Enter atomic number.");
                    elementNumber = Integer.parseInt(input);
                }
                else if(element.equalsIgnoreCase("B"))
                {
                    input = JOptionPane.showInputDialog("Enter element name.");
                    for(int i = 0; i < bleh.elements.size(); i++)
                    {
                        if(bleh.elements.get(i).equalsIgnoreCase("~" + input + "~"))
                        {
                            if(bleh.elements.get(i-2).length() == 4)
                                elementNumber = Integer.parseInt(bleh.elements.get(i-2).substring(1,3));
                            else if(bleh.elements.get(i-2).length() == 3)
                                elementNumber = Integer.parseInt(bleh.elements.get(i-2).substring(1,2));
                            else
                                elementNumber = Integer.parseInt(bleh.elements.get(i-2).substring(1,4));
                        }
                    }
                }
                else if(element.equalsIgnoreCase("C"))
                {
                    input = JOptionPane.showInputDialog("Enter element symbol.");
                    for(int i = 0; i < bleh.elements.size(); i++)
                    {
                        if(bleh.elements.get(i).equalsIgnoreCase("~" + input + "~"))
                        {
                            if(bleh.elements.get(i-4).length() == 4)
                                elementNumber = Integer.parseInt(bleh.elements.get(i-4).substring(1,3));
                            else if(bleh.elements.get(i-4).length() == 3)
                                elementNumber = Integer.parseInt(bleh.elements.get(i-4).substring(1,2));
                            else
                                elementNumber = Integer.parseInt(bleh.elements.get(i-4).substring(1,4));
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please try again.");
                    actionPerformed(event);
                }
                
                int nextElementNumber = elementNumber + 1;
                String Number = Integer.toString(elementNumber);
                String nextNumber = Integer.toString(nextElementNumber);
                int elementIndex = 0;
                int nextElementIndex = bleh.elements.size();
                for(int i = 0; i < bleh.elements.size(); i++)
                {
                    if(bleh.elements.get(i).equals("~" + Number + "~"))
                    {
                        elementIndex = i;
                    }
                    if(bleh.elements.get(i).equals("~" + nextNumber + "~"))
                    {
                        nextElementIndex = i;
                    }
                }
                String testtest = " ";
                for(int i = elementIndex; i < nextElementIndex; i++)
                {
                    testtest += bleh.elements.get(i);
                    testtest += " ";
                    //System.out.println(bleh.elements.get(i));
                }
                JOptionPane.showMessageDialog(null, testtest);
            }   
        }
        class quizListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                test2 bleh = new test2();
                Random nGenerator = new Random();
                JOptionPane.showMessageDialog(null, "Directions: Enter the atomic number for the element name shown.");
                int number = 118;
                int elementNumber;
                String Number;
                int elementIndex = 0;
                int score = 0;
                
               
                for(int i = 0; i < 5; i++)
                {
                    elementNumber = (int)(nGenerator.nextInt(number))+1;
                    Number = Integer.toString(elementNumber);
                    for(int j = 0; j < bleh.elements.size(); j++)
                    {
                        if(bleh.elements.get(j).equals("~" + Number + "~"))
                        {
                            elementIndex = j;
                        }
                    }
                    String question1 = JOptionPane.showInputDialog(bleh.elements.get(elementIndex+2));
                    if(("~" + question1 + "~").equals(bleh.elements.get(elementIndex)))
                    {
                        score ++;
                    }
                }
                JOptionPane.showMessageDialog(null, "You got " + score + " right out of 5.");
             }
        }
        
        ActionListener quizListener = new quizListener();
        ActionListener searchListener = new searchListener();
        ActionListener learnListener = new learnListener();
        
        buttonL.addActionListener(learnListener);
        buttonS.addActionListener(searchListener);
        buttonQ.addActionListener(quizListener);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 100;
    
}
