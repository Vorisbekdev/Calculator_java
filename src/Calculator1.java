import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator1 implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, multiplyButton, divButton, percentButton;
    JButton decButton, equalButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myfont = new Font("Ink free", Font.BOLD,30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;
    Calculator1(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("C");
        clrButton = new JButton("AC");
        negButton = new JButton("-");
        percentButton = new JButton("%");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = percentButton;

        for(int i = 0; i < 10; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myfont);
            numberButton[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.BLACK);

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(divButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(multiplyButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equalButton);
        panel.add(addButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Calculator1 cal = new Calculator1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButton[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton ){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = 'x';
            textfield.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        if(e.getSource() == equalButton){
            num2 = Double.parseDouble(textfield.getText());

            switch(operator){
                case'x':
                    result = num1 * num2;
                    break;
                case'÷':
                    result = num1 / num2;
                    break;
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'%':
                    result = num1 / 100;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textfield.setText("");
        }
        if(e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < string.length() - 1; i++){
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == negButton){
            double tem = Double.parseDouble(textfield.getText());
            tem *= -1;
            textfield.setText(String.valueOf(tem));
        }
    }
}


