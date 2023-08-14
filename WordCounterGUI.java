import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterGUI extends JFrame {

    private JTextArea textArea;
    private JLabel wordCountLabel;

    public WordCounterGUI() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.BOLD, 15));
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton countButton = new JButton("Count Words");
       
        countButton.setFont(new Font("Arial", Font.BOLD, 15));
       countButton.setBackground(Color.blue);
        countButton.setForeground(Color.white);
        countButton.setBorder(new LineBorder(Color.WHITE, 3));
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });

        wordCountLabel = new JLabel("Word Count: 0");
        wordCountLabel.setFont(new Font("Arial", Font.BOLD, 15));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(countButton);
        buttonPanel.add(wordCountLabel);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordCounterGUI wordCounterGUI = new WordCounterGUI();
                wordCounterGUI.setVisible(true);
            }
        });
    }
}
