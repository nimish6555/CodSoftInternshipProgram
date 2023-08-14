import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMGUI extends JFrame implements ActionListener {
    private BankAccount bankAccount;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton checkBalanceButton;

    private JButton TryAgainButton;

    public ATMGUI(BankAccount bankAccount) {
        this.bankAccount = bankAccount;

        setTitle("ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        balanceLabel = new JLabel("Balance: RS " + bankAccount.getBalance());
        // balanceLabel.setHorizontalAlignment(JLabel.CENTER);
        balanceLabel.setBounds(10,10,200,50);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(balanceLabel);

        JPanel amountPanel = new JPanel();
        amountField = new JTextField(12);
       
        amountPanel.add(new JLabel("Amount: "));
        amountPanel.setBounds(200,10,150,50);
        
        amountPanel.add(amountField);
        add(amountPanel);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(30,150,150,50);
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 18));
        withdrawButton.setBackground(Color.blue);
        withdrawButton.setForeground(Color.white);
        withdrawButton.setBorder(new LineBorder(Color.WHITE, 3));
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(200,150,150,50);
        depositButton.setFont(new Font("Arial", Font.BOLD, 18));
        depositButton.setBackground(Color.blue);
        depositButton.setForeground(Color.white);
        depositButton.setBorder(new LineBorder(Color.WHITE, 3));
        depositButton.addActionListener(this);
        add(depositButton);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(30,220,150,50);
        checkBalanceButton.setFont(new Font("Arial", Font.BOLD, 18));
        checkBalanceButton.setBackground(Color.blue);
        checkBalanceButton.setForeground(Color.white);
        checkBalanceButton.setBorder(new LineBorder(Color.WHITE, 3));
        checkBalanceButton.addActionListener(this);
        add(checkBalanceButton);

        TryAgainButton = new JButton("Try Again");
        TryAgainButton.setBounds(200,220,150,50);
        TryAgainButton.setFont(new Font("Arial", Font.BOLD, 18));
        TryAgainButton.setBackground(Color.blue);
        TryAgainButton.setForeground(Color.white);
        TryAgainButton.setBorder(new LineBorder(Color.WHITE, 3));
        TryAgainButton.addActionListener(this);
        add(TryAgainButton);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            double amount = getAmountFromField();
            boolean success = bankAccount.withdraw(amount);
            if (success) {
                showMessage("Withdrawal successful!");
            } else {
                showMessage("Insufficient balance or invalid amount.");
            }
        } else if (e.getSource() == depositButton) {
            double amount = getAmountFromField();
            bankAccount.deposit(amount);
            showMessage("Deposit successful!");
        } else if (e.getSource() == checkBalanceButton) {
            double balance = bankAccount.getBalance();
            showMessage("Your account balance is: RS " + balance);

        } else if (e.getSource() ==  TryAgainButton) {
            double balance = bankAccount.getBalance();
            showMessage("Your account balance is: RS " + balance);
        }
        updateBalanceLabel();
        clearAmountField();
    }

    private double getAmountFromField() {
        String amountString = amountField.getText();
        try {
            return Double.parseDouble(amountString);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: RS " + bankAccount.getBalance());
    }

    private void clearAmountField() {
        amountField.setText("");
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0); // Initial account balance
        ATMGUI atm = new ATMGUI(bankAccount);
        atm.setVisible(true);
    }
}
