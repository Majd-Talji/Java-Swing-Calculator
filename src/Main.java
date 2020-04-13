
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
public class Main extends JFrame {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, comma, equal, plus, minus, divide, multiple, clear, back;
    JTextField textField;
    JLabel oldValueLabel, operandLabel;

    double num;

    double answer;

    double oldAnswer;

    int operation;

    boolean isTextChanged = false;

    boolean noClickedOperator = true;

    boolean isEqualClicked = false;

    DecimalFormat format = new DecimalFormat("0.###############");

    Font font = new Font("Arial", Font.BOLD, 17);

    String errorStr = "Error";
    String canNotDivideBy0Str = "cannot divide by 0";

    private void calculaterOldAnswer() {
        switch (operation) {
            case 1:
                oldAnswer += num;
                break;
            case 2:
                if (!oldValueLabel.getText().isEmpty()) {
                    oldAnswer -= num;
                } else {
                    oldAnswer = num - oldAnswer;
                }
                break;
            case 3:
                oldAnswer *= num;
                break;
            case 4:
                oldAnswer /= num;
                break;
        }
    }

    private void addNumber(String num) {
        if (isEqualClicked == true || textField.getText().equals("0")) {
            textField.setText(num);
        } else {
            textField.setText(textField.getText() + num);
        }
        isEqualClicked = false;
        isTextChanged = true;
        noClickedOperator = true;
    }

    private void createAndShowGUI() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

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
        comma = new JButton(".");
        plus = new JButton("+");
        minus = new JButton("-");
        multiple = new JButton("×");
        divide = new JButton("÷");
        equal = new JButton("=");
        clear = new JButton("C");
        back = new JButton("←");
        textField = new JTextField("0");
        oldValueLabel = new JLabel("", JLabel.RIGHT);
        operandLabel = new JLabel("", JLabel.RIGHT);

        oldValueLabel.setBounds(11, 5, 214, 20);
        operandLabel.setBounds(225, 5, 20, 20);
        textField.setBounds(11, 25, 234, 47);
        b7.setBounds(10, 80, 45, 42);
        b8.setBounds(58, 80, 45, 42);
        b9.setBounds(106, 80, 45, 42);
        plus.setBounds(154, 80, 45, 42);
        clear.setBounds(202, 80, 45, 42);
        b4.setBounds(10, 125, 45, 42);
        b5.setBounds(58, 125, 45, 42);
        b6.setBounds(106, 125, 45, 42);
        minus.setBounds(154, 125, 45, 42);
        back.setBounds(202, 125, 45, 42);
        b1.setBounds(10, 170, 45, 42);
        b2.setBounds(58, 170, 45, 42);
        b3.setBounds(106, 170, 45, 42);
        multiple.setBounds(154, 170, 45, 42);
        equal.setBounds(202, 170, 45, 87);
        b0.setBounds(10, 215, 93, 42);
        comma.setBounds(106, 215, 45, 42);
        divide.setBounds(154, 215, 45, 42);

        b0.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        b5.setFont(font);
        b6.setFont(font);
        b7.setFont(font);
        b8.setFont(font);
        b9.setFont(font);
        comma.setFont(font);
        equal.setFont(font);
        plus.setFont(font);
        multiple.setFont(font);
        minus.setFont(font);
        divide.setFont(font);
        clear.setFont(font);
        back.setFont(font);
        oldValueLabel.setFont(font);
        operandLabel.setFont(font);

        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Monospaced", Font.BOLD, 19));

        oldValueLabel.setForeground(Color.cyan);
        operandLabel.setForeground(Color.yellow);
        b0.setForeground(Color.white);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        b4.setForeground(Color.white);
        b5.setForeground(Color.white);
        b6.setForeground(Color.white);
        b7.setForeground(Color.white);
        b8.setForeground(Color.white);
        b9.setForeground(Color.white);
        comma.setForeground(Color.white);
        equal.setForeground(Color.white);
        plus.setForeground(Color.white);
        minus.setForeground(Color.white);
        multiple.setForeground(Color.white);
        divide.setForeground(Color.white);
        clear.setForeground(Color.white);
        back.setForeground(Color.white);

        b0.setBackground(Color.darkGray);
        b1.setBackground(Color.darkGray);
        b2.setBackground(Color.darkGray);
        b3.setBackground(Color.darkGray);
        b4.setBackground(Color.darkGray);
        b5.setBackground(Color.darkGray);
        b6.setBackground(Color.darkGray);
        b7.setBackground(Color.darkGray);
        b8.setBackground(Color.darkGray);
        b9.setBackground(Color.darkGray);
        comma.setBackground(Color.darkGray);
        equal.setBackground(Color.darkGray);
        plus.setBackground(Color.darkGray);
        minus.setBackground(Color.darkGray);
        multiple.setBackground(Color.darkGray);
        divide.setBackground(Color.darkGray);
        clear.setBackground(new Color(223, 1, 1));
        back.setBackground(new Color(255, 128, 0));
        getContentPane().setBackground(Color.black);

        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(comma);
        add(equal);
        add(plus);
        add(multiple);
        add(minus);
        add(divide);
        add(clear);
        add(back);
        add(textField);
        add(oldValueLabel);
        add(operandLabel);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b0) {
                    addNumber("0");
                } else if (e.getSource() == b1) {
                    addNumber("1");
                } else if (e.getSource() == b2) {
                    addNumber("2");
                } else if (e.getSource() == b3) {
                    addNumber("3");
                } else if (e.getSource() == b4) {
                    addNumber("4");
                } else if (e.getSource() == b5) {
                    addNumber("5");
                } else if (e.getSource() == b6) {
                    addNumber("6");
                } else if (e.getSource() == b7) {
                    addNumber("7");
                } else if (e.getSource() == b8) {
                    addNumber("8");
                } else if (e.getSource() == b9) {
                    addNumber("9");
                } else if (e.getSource() == comma) {
                    // textField.getText().isEmpty()
                    if (isEqualClicked == true || textField.getText().equals("0")) {
                        textField.setText("0.");
                    } else if (!textField.getText().contains(".")) {
                        textField.setText(textField.getText() + ".");
                    }
                    isEqualClicked = false;
                    isTextChanged = true;
                } else if (e.getSource() == plus && noClickedOperator == true) {
                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷")) {
                        textField.setText(canNotDivideBy0Str);
                    } else if (isTextChanged == true || oldValueLabel.getText().isEmpty()) {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 0;
                            } else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 1;
                                oldAnswer = 0;
                            } else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }

                            calculaterOldAnswer();
                            operandLabel.setText("+");
                            oldValueLabel.setText(format.format(oldAnswer).replace(',', '.'));
                            textField.setText("");

                            operation = 1;

                        } catch (Exception ex) {
                            textField.setText(errorStr);
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                } else if (e.getSource() == minus && noClickedOperator == true) {
                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷")) {
                        textField.setText(canNotDivideBy0Str);
                    } else if (isTextChanged == true || oldValueLabel.getText().isEmpty()) {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 0;
                            } else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 2;
                                oldAnswer = 0;
                            } else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }

                            calculaterOldAnswer();
                            operandLabel.setText("-");
                            oldValueLabel.setText(format.format(oldAnswer).replace(',', '.'));
                            textField.setText("");

                            operation = 2;

                        } catch (Exception ex) {
                            textField.setText(errorStr);
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                } else if (e.getSource() == multiple && noClickedOperator == true) {
                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷")) {
                        textField.setText(canNotDivideBy0Str);
                    } else if (isTextChanged == true || oldValueLabel.getText().isEmpty()) {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 1;
                            } else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 3;
                                oldAnswer = 1;
                            } else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }

                            calculaterOldAnswer();
                            operandLabel.setText("×");
                            oldValueLabel.setText(format.format(oldAnswer).replace(',', '.'));
                            textField.setText("");

                            operation = 3;

                        } catch (Exception ex) {
                            textField.setText(errorStr);
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                } else if (e.getSource() == divide && noClickedOperator == true) {
                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷")) {
                        textField.setText(canNotDivideBy0Str);
                    } else if (isTextChanged == true || oldValueLabel.getText().isEmpty()) {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 1;
                            } else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                oldAnswer = num;
                            } else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                                calculaterOldAnswer();
                            }

                            operandLabel.setText("÷");
                            oldValueLabel.setText(format.format(oldAnswer).replace(',', '.'));
                            textField.setText("");

                            operation = 4;

                        } catch (Exception ex) {
                            textField.setText(errorStr);
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                } else if (e.getSource() == equal) {
                    if (!textField.getText().isEmpty() && !oldValueLabel.getText().isEmpty() && isEqualClicked == false) {

                        double a = Double.parseDouble(oldValueLabel.getText());
                        double b = Double.parseDouble(textField.getText());
                        char operand = operandLabel.getText().charAt(0);

                        switch (operand) {
                            case '+':
                                answer = a + b;
                                textField.setText(format.format(answer).replace(',', '.'));
                                break;
                            case '-':
                                answer = a - b;
                                textField.setText(format.format(answer).replace(',', '.'));
                                break;
                            case '×':
                                answer = a * b;
                                textField.setText(format.format(answer).replace(',', '.'));
                                break;
                            case '÷':
                                if (b == 0) {
                                    textField.setText(canNotDivideBy0Str);
                                } else {
                                    answer = a / b;
                                    textField.setText(format.format(answer).replace(',', '.'));
                                }
                                break;
                        }
                    } else if (textField.getText().isEmpty() && !oldValueLabel.getText().isEmpty()) {
                        textField.setText(oldValueLabel.getText());
                    }

                    oldValueLabel.setText("");
                    operandLabel.setText("");

                    isEqualClicked = true;
                    noClickedOperator = true;

                } else if (e.getSource() == back) {
                    if (textField.getText().equals(errorStr) || textField.getText().equals(canNotDivideBy0Str)) {
                        textField.setText("0");
                    } else if (!textField.getText().isEmpty()) {
                        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                    }
                } else if (e.getSource() == clear) {
                    oldValueLabel.setText("");
                    textField.setText("");
                    operandLabel.setText("");
                    oldAnswer = 0;
                    num = 0;
                    noClickedOperator = true;
                }

            }
        };

        b0.addActionListener(actionListener);
        b1.addActionListener(actionListener);
        b2.addActionListener(actionListener);
        b3.addActionListener(actionListener);
        b4.addActionListener(actionListener);
        b5.addActionListener(actionListener);
        b6.addActionListener(actionListener);
        b7.addActionListener(actionListener);
        b8.addActionListener(actionListener);
        b9.addActionListener(actionListener);
        comma.addActionListener(actionListener);
        equal.addActionListener(actionListener);
        plus.addActionListener(actionListener);
        multiple.addActionListener(actionListener);
        minus.addActionListener(actionListener);
        divide.addActionListener(actionListener);
        clear.addActionListener(actionListener);
        back.addActionListener(actionListener);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setSize(263, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    public Main() {
        createAndShowGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

}
