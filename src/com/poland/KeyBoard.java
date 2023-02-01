package com.poland;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class KeyBoard extends JFrame implements ActionListener {

    private final JTextField l;
    private JTextArea list1;
    JFrame f;

    KeyBoard(Scan scan) {

        f = new JFrame();

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // create an object of class

        // create a textfield
        l = new JTextField(15);

        // set the textfield to non editable
        l.setEditable(true);

        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPow,
                bPlus, bMinus, bDivide, bMultiply, bRemove,
                bOpenBracket, bCloseBracket, bEquals, bDot;

        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // equals button
        bEquals = new JButton("=");

        // create operator buttons
        bPlus = new JButton("+");
        bMinus = new JButton("-");
        bDivide = new JButton("/");
        bMultiply = new JButton("*");
        bPow = new JButton("^");
        bRemove = new JButton("C");
        bOpenBracket = new JButton("(");
        bCloseBracket = new JButton(")");

        // create . button
        bDot = new JButton(".");

        list1 = new JTextArea("           ");


        // create a panel
        JPanel p = new JPanel();

        // add action listeners
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "1");
            }});
        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "2");
            }});

        b3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "3");
            }});

        b4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "4");
            }});

        b5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "5");
            }});

        b6.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "6");
            }});

        b7.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "7");
            }});

        b8.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "8");
            }});

        b9.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "9");
            }});

        b0.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "0");
            }});


        bMinus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "-");
            }});

        bPlus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "+");
            }});

        bMultiply.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "*");
            }});

        bDivide.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "/");
            }});

        bOpenBracket.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "(");
            }});

        bCloseBracket.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + ")");
            }});

        bEquals.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {

                scan.scan(l.getText());
                String input = scan.convert();
//                System.out.print("Revers polish: " + input);

                String t;
                if(input != "incorrect input!"){
                    t = scan.calculated();
                    if(t == "win"){
                        l.setText(l.getText() + " = " + scan.getCalculateStackalculate().pollFirst());
                        list1.setText(input);
                    }
                    else l.setText("incorrect input");
                }else{
                    l.setText("incorrect input");
                }
            }});

        bDot.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + ".");
            }});

        bRemove.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText("");
                list1.setText("           ");
            }});

        bPow.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                l.setText(l.getText() + "^");
            }});

        // create a separator
        JSeparator s = new JSeparator();

        // set layout as vertical
        s.setOrientation(JSeparator.HORIZONTAL);

        // add elements to panel
        p.add(l);
        p.add(s);
        p.add(new JSeparator());
        p.add(bPlus);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(s);
        p.add(bMinus);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bMultiply);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bDivide);
        p.add(bDot);
        p.add(b0);
        p.add(bPow);
        p.add(bEquals);
        p.add(bRemove);
        p.add(bOpenBracket);
        p.add(bCloseBracket);
        p.add(list1);


        // set Background of panel
//        p.setBackground(Color.blue);
        // add panel to frame
        f.add(p);

        f.setSize(230, 300);
        f.show();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
