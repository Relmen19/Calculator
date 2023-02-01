package com.poland;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Board implements ActionListener {

    private LinkedList<String> HISTORY = new LinkedList<String>();
    private LinkedList<String> POLISH_REVERSE = new LinkedList<String>();
    private String input = "";
    private Boolean showHistory = true;
    private JFrame frame;
    private JLabel label = new JLabel();
    private Scan scan = new Scan();
    private JTextArea area=new JTextArea();
    private JTextField textField = new JTextField();
    private JRadioButton onRadioButton = new JRadioButton("his");
    private JRadioButton offRadioButton = new JRadioButton("pol");
    private JButton buttonZero = new JButton("0");
    private JButton buttonOne = new JButton("1");
    private JButton buttonTwo = new JButton("2");
    private JButton buttonThree = new JButton("3");
    private JButton buttonFour = new JButton("4");
    private JButton buttonFive = new JButton("5");
    private JButton buttonSix = new JButton("6");
    private JButton buttonSeven = new JButton("7");
    private JButton buttonEight = new JButton("8");
    private JButton buttonNine = new JButton("9");
    private JButton buttonDot = new JButton(".");
    private JButton buttonClear = new JButton("C");
    private JButton buttonDelete = new JButton("DEL");
    private JButton buttonEqual = new JButton("=");
    private JButton buttonMul = new JButton("x");
    private JButton buttonDiv = new JButton("/");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonOpenBracket = new JButton("(");
    private JButton buttonCloseBracket = new JButton(")");
//    private JButton buttonSquare = new JButton("x\u00B2");
    private JButton buttonReciprocal = new JButton("1/x");
//  private JButton buttonCloseSqrt = new JButton("\u221A");
    private JButton buttonClearHistory = new JButton("Clr");



    public Board() {
        prepareGUI();
        addComponents();
        addActionEvent();
    }
    public void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(570, 510);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponents() {
        label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.white);
        frame.add(label);

        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 16));
        textField.setEditable(true);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        onRadioButton.setBounds(10, 95, 60, 40);
        onRadioButton.setSelected(true);
        onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        onRadioButton.setBackground(Color.black);
        onRadioButton.setForeground(Color.white);
        frame.add(onRadioButton);



        offRadioButton.setBounds(10, 120, 60, 40);
        offRadioButton.setSelected(false);
        offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        offRadioButton.setBackground(Color.black);
        offRadioButton.setForeground(Color.white);
        frame.add(offRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        buttonSeven.setBounds(10, 230, 60, 40);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSeven);

        buttonEight.setBounds(80, 230, 60, 40);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEight);

        buttonNine.setBounds(150, 230, 60, 40);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonNine);

        buttonFour.setBounds(10, 290, 60, 40);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFour);

        buttonFive.setBounds(80, 290, 60, 40);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFive);

        buttonSix.setBounds(150, 290, 60, 40);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSix);

        buttonOne.setBounds(10, 350, 60, 40);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonOne);

        buttonTwo.setBounds(80, 350, 60, 40);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonTwo);

        buttonThree.setBounds(150, 350, 60, 40);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonThree);

        buttonDot.setBounds(150, 410, 60, 40);
        buttonDot.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonDot);

        buttonZero.setBounds(10, 410, 130, 40);
        buttonZero.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonZero);

        buttonEqual.setBounds(220, 350, 60, 100);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEqual.setBackground(new Color(239, 188, 2));
        frame.add(buttonEqual);

        buttonDiv.setBounds(220, 110, 60, 40);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDiv.setBackground(new Color(239, 188, 2));
        frame.add(buttonDiv);

        buttonMul.setBounds(220, 230, 60, 40);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMul.setBackground(new Color(239, 188, 2));
        frame.add(buttonMul);

        buttonMinus.setBounds(220, 170, 60, 40);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMinus.setBackground(new Color(239, 188, 2));
        frame.add(buttonMinus);

        buttonPlus.setBounds(220, 290, 60, 40);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPlus.setBackground(new Color(239, 188, 2));
        frame.add(buttonPlus);

        buttonOpenBracket.setBounds(10, 170, 60, 40);
        buttonOpenBracket.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonOpenBracket);

        buttonCloseBracket.setBounds(80, 170, 60, 40);
        buttonCloseBracket.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(buttonCloseBracket);

        buttonReciprocal.setBounds(150, 170, 60, 40);
        buttonReciprocal.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(buttonReciprocal);

        buttonDelete.setBounds(150, 110, 60, 40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 12));
        buttonDelete.setBackground(Color.red);
        buttonDelete.setForeground(Color.white);
        frame.add(buttonDelete);

        buttonClear.setBounds(80, 110, 60, 40);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 12));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        frame.add(buttonClear);

        area.setBounds(290,40,270,360);
        area.setFont(new Font("Arial", Font.BOLD, 16));
        area.setBackground(Color.white);
        frame.add(area);

        buttonClearHistory.setBounds(290, 410, 60, 40);
        buttonClearHistory.setFont(new Font("Arial", Font.BOLD, 12));
        frame.add(buttonClearHistory);

    }

    public void addActionEvent() {
        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonCloseBracket.addActionListener(this);
        buttonOpenBracket.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonZero.addActionListener(this);
        buttonDot.addActionListener(this);
        buttonClearHistory.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == onRadioButton) {
            showHistoryOperation();
        } else if (source == offRadioButton) {
            showPolishRevers();
        } else if (source == buttonClear) {
            label.setText("");
            textField.setText("");
        } else if (source == buttonDelete) {
            int length = textField.getText().length();
            int number = length - 1;

            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());
            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }
        } else if (source == buttonZero) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == buttonOne) {
            textField.setText(textField.getText() + "1");
        } else if (source == buttonTwo) {
            textField.setText(textField.getText() + "2");
        } else if (source == buttonThree) {
            textField.setText(textField.getText() + "3");
        } else if (source == buttonFour) {
            textField.setText(textField.getText() + "4");
        } else if (source == buttonFive) {
            textField.setText(textField.getText() + "5");
        } else if (source == buttonSix) {
            textField.setText(textField.getText() + "6");
        } else if (source == buttonSeven) {
            textField.setText(textField.getText() + "7");
        } else if (source == buttonEight) {
            textField.setText(textField.getText() + "8");
        } else if (source == buttonNine) {
            textField.setText(textField.getText() + "9");
        } else if (source == buttonDot) {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }

        } else if (source == buttonPlus) {
            textField.setText(textField.getText() + "+");
        } else if (source == buttonMinus) {
            textField.setText(textField.getText() + "-");
        } else if (source == buttonMul) {
            textField.setText(textField.getText() + "*");
        } else if (source == buttonDiv) {
            textField.setText(textField.getText() + "/");
        } else if (source == buttonOpenBracket) {
            textField.setText(textField.getText() + "(");
        } else if (source == buttonCloseBracket) {
            textField.setText(textField.getText() + ")");
        } else if (source == buttonReciprocal) {
            textField.setText("1/(" + textField.getText() + ")");
        } else if (source == buttonEqual){
            scan.scan(textField.getText());
            input = scan.convert();

            String t;
            if(input != "incorrect input!"){
                t = scan.calculated();
                if(t == "win"){
                    String d = new DecimalFormat("#0.000").format(scan.getCalculateStackalculate().pollFirst());
                    HISTORY.addLast(textField.getText() + " = " + d);
                    textField.setText(d);
                    POLISH_REVERSE.addLast(input);
                }
                else textField.setText("incorrect input");
            }else{
                textField.setText("incorrect input");
            }

            if(showHistory) showHistoryOperation();
            else showPolishRevers();
            scan.ClearStacks();
        } else if(source == buttonClearHistory){
            HISTORY.clear();
            POLISH_REVERSE.clear();
            showHistoryOperation();
            showPolishRevers();
        }
    }

    public void showHistoryOperation() {
        area.setText("");
        showHistory = true;
        for(String str:HISTORY){
            area.append(str + "\n");
        }
    }

    public void showPolishRevers() {
        area.setText("");
        showHistory = false;
        for(String str:POLISH_REVERSE){
            area.append(str + "\n");
        }
    }
}
