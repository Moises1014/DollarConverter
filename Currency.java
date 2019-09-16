/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package converter;

/**
 *
 * @author Moises Feliz
 *
 * I affirm that this program is entirely my own work and none of it is the 
 * work of any other person.
 *
 * The program allows the user to convert an amount of money 
 * between U.S. dollars (USD), euros (EUR), and British pounds (GBP). While 
 * a frame(graphical interface) for user interface and showing the conversion
 * in the frame also. It does this b first asking the user to pick the currency
 * he wants to convert from and two in two different combo boxes. Then the text
 * gets the amount that will be converted to the different amount, it gets the 
 * amount as a string so first it makes the string an integer. Then it does 
 * convertions and shows the new amount but only after the convert button is 
 * pressed.
 * 
 */
import java.awt.*;

import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

//Define the class.
public class Currency extends Frame
        implements ItemListener, ActionListener {

//Create the J components.
    JComboBox convert_From, convert_To;

    JTextField txt_From;

    JLabel txt_To;

    JButton convert;

    JLabel from, to;

    JLabel lbl_From, lbl_To;

    JPanel main_panel = new JPanel();
    
    DecimalFormat df = new DecimalFormat("#########.##");

//Input and output variables.
    double input = 0;

    double result = 0;

     /**
     * Constructor for the class,makes the frame and everything in it. 
     * Including buttons, combo box, and everything else on the frame.
     * 
     */
    public Currency() {

        super("Currency");

        setSize(420, 300);

        setLayout(null);

        setBackground(Color.lightGray);

        //labels.
        lbl_From = new JLabel("From:");

        lbl_From.setBounds(30, 45, 250, 30);

        lbl_From.setForeground(Color.black);

        add(lbl_From);

        //combobox.
        convert_From = new JComboBox();

        convert_From.setBounds(30, 70, 150, 30);

        convert_From.addItem("U.S. dollars (USD)");

        convert_From.addItem("euros (EUR)");

        convert_From.addItem("British pounds (GBP)");

        add(convert_From);

        //labels.
        lbl_To = new JLabel("To:");

        lbl_To.setBounds(230, 45, 250, 30);

        lbl_To.setForeground(Color.black);

        add(lbl_To);

        //combobox
        convert_To = new JComboBox();

        convert_To.setBounds(230, 70, 150, 30);

        convert_To.addItem("U.S. dollars (USD)");

        convert_To.addItem("euros (EUR)");

        convert_To.addItem("British pounds (GBP)");

        add(convert_To);

        //makes labels.
        from = new JLabel("Enter Amount to Convert:");

        from.setBounds(50, 110, 300, 30);

        add(from);

        from.setForeground(Color.black);

        //textfields
        txt_From = new JTextField(15);

        txt_From.setBounds(50, 140, 300, 30);

        add(txt_From);

        //Buttons
        convert = new JButton("Convert");

        convert.setBounds(150, 250, 100, 30);

        add(convert);

        //Label
        to = new JLabel("Total Amount Converted:");

        to.setBounds(50, 170, 300, 30);

        add(to);

        to.setForeground(Color.black);

        //Define the label to show the results
        txt_To = new JLabel("");

        txt_To.setBounds(50, 200, 300, 30);

        txt_To.setFocusable(false);

        txt_To.setForeground(Color.blue);

        add(txt_To);

        //Add the events to JComponents.
        convert_From.addItemListener(this);

        convert_To.addItemListener(this);

        convert.addActionListener(this);

        txt_From.addActionListener(this);

        addWindowListener
        (
                new WindowAdapter() 
                {
                     public void windowClosing(WindowEvent e) 
                     {
                         exit();
            }

        }
        );
    }
    
     /**
     * Defines the exit button functionality on the frame
     *
     */
    public void exit() 
    {
        setVisible(false);

        dispose();

        System.exit(0);

    }


    /**
     * Defines the method to convert dollar to other currency.
     *
     */
    public void ConvertDollar() 
    {
        if (convert_To.getSelectedItem() == "British pounds (GBP)") 
        {

            result = (input / 1.64);

            txt_To.setText("" + df.format(result));

        } else if (convert_To.getSelectedItem() == "euros (EUR)") 
        {
            result = (input / 1.42);

            txt_To.setText("" + df.format(result));

        } else if (convert_To.getSelectedItem() == "U.S. dollars (USD)") 
        {
            txt_To.setText("Choose different currency");
        }
    }

    /**
     * Defines the method to convert Euros to other currency.
     *
     */
    public void ConvertEuros() 
    {
        if (convert_To.getSelectedItem() == "U.S. dollars (USD)") 
        {
            result = (input * 1.42);

            txt_To.setText("" + df.format(result));

        } else if (convert_To.getSelectedItem() == "British pounds (GBP)") 
        {
            result = (input / 1.13);

            txt_To.setText("" + df.format(result));

        } else if (convert_To.getSelectedItem() == "euros (EUR)")
        {
            txt_To.setText("Choose different currency");

        }

    }


    /**
     * Defines the method to convert GBP to other currency.
     *
     */
    public void ConvertGBP() 
    {
        if (convert_To.getSelectedItem() == "U.S. dollars (USD)")
        {
            result = (input * 1.64);

            txt_To.setText("" + df.format(result));

        } else if (convert_To.getSelectedItem() == "euros (EUR)") 
        {
            result = (input * 1.13);

            txt_To.setText("" + df.format(result));

        } else if (convert_To.getSelectedItem() == "British pounds (GBP)") 
        {
            txt_To.setText("Choose different currency");

        }
    }

    /**
     * Define the action performed events. This includes :
     * Get the amount that will be converted,
     * Get the from type selected by from combo box,
     * On the click of button convert call the required function and
     * display the result,
     *
     */
    public void actionPerformed(ActionEvent e) 
    {
        input = Double.parseDouble(txt_From.getText());
        String msg = txt_From.getText();

        if (e.getSource() == convert) 
        {
            if (convert_From.getSelectedItem() == "U.S. dollars (USD)")
            {
                ConvertDollar();

            } else if (convert_From.getSelectedItem() == "euros (EUR)") 
            {
                ConvertEuros();

            } else if (convert_From.getSelectedItem() == "British pounds (GBP)")
            {
                ConvertGBP();

            }

        }
    }
    
     /**
     * lets items that haven been changed be saved or in other words action
     * listeners 
     *
     */
    @Override
    public void itemStateChanged(ItemEvent arg0) 
    {

    }

}
