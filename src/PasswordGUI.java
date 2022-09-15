import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.*;

public class PasswordGUI extends JComponent implements Runnable {

    JButton generateButton;
    JButton copyButton;
    JButton closeButton;

    PasswordGUI application;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PasswordGUI());

    }


    @Override
    public void run() {

        JFrame frame = new JFrame();
        frame.setTitle("Password Generator");

        frame.setSize(400, 563);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        JLabel welcome = new JLabel("Random Password Generator");
        welcome.setFont(new Font("Ariel", Font.BOLD, 23));
        welcome.setSize(350, 88);
        welcome.setLocation(25, 0);

        JLabel length = new JLabel("Length");
        length.setFont(new Font("Ariel", Font.PLAIN, 27));
        length.setSize(100, 62);
        length.setLocation(169, 62);

        Integer[] lengthNumList = new Integer[25];
        for (int i = 0; i < lengthNumList.length; i++) {
            lengthNumList[i] = i + 8;
        }
        JComboBox<Integer> lengthBox = new JComboBox<>(lengthNumList);
        lengthBox.setFont(new Font("Arial", Font.PLAIN, 17));
        lengthBox.setBounds(112, 75, 50, 40);

        JCheckBox symCheck = new JCheckBox("Symbols");
        symCheck.setFont(new Font("Ariel", Font.PLAIN, 26));
        symCheck.setSize(150, 62);
        symCheck.setLocation(38, 150);

        JCheckBox numCheck = new JCheckBox("Numbers");
        numCheck.setFont(new Font("Ariel", Font.PLAIN, 26));
        numCheck.setSize(150, 62);
        numCheck.setLocation(212, 150);

        String[] caseVal = new String[3];
        caseVal[0] = "Uppercase";
        caseVal[1] = "Lowercase";
        caseVal[2] = "Both";

        JComboBox<String> letterCases = new JComboBox<>(caseVal);
        letterCases.setFont(new Font("Arial", Font.PLAIN, 17));
        letterCases.setBounds(12, 250, 125, 44);

        JLabel caseText = new JLabel("Uppercase / Lowercase");
        caseText.setFont(new Font("Arial", Font.PLAIN, 20));
        caseText.setBounds(150, 250, 212, 37);

        generateButton = new JButton("Generate Password");
        generateButton.setFont(new Font("Arial", Font.PLAIN, 22));
        generateButton.setBounds(62, 325, 250, 44);

        JLabel newPassText = new JLabel("Your new random password is:");
        newPassText.setFont(new Font("Arial", Font.PLAIN, 20));
        newPassText.setBounds(56, 375, 300, 44);

        JTextField passwordText = new JTextField("Password temp", 200);
        passwordText.setBounds(69, 413, 244, 44);
        passwordText.setEditable(false);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 21));
        passwordText.setHorizontalAlignment(JTextField.CENTER);

        copyButton = new JButton("Copy");
        copyButton.setFont(new Font("Arial", Font.PLAIN, 16));
        copyButton.setBounds(91, 469, 81, 31);

        closeButton = new JButton("Exit");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        closeButton.setBounds(210, 469, 81, 31);


        JLabel nothing = new JLabel("");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked!");
                System.out.println(lengthBox.getItemAt(lengthBox.getSelectedIndex()));
                System.out.println(symCheck.isSelected());
                System.out.println(numCheck.isSelected());
                System.out.println(letterCases.getItemAt(letterCases.getSelectedIndex()));
                Password newPass = new Password(lengthBox.getItemAt(lengthBox.getSelectedIndex()),
                        symCheck.isSelected(), numCheck.isSelected(),
                        letterCases.getItemAt(letterCases.getSelectedIndex()));
                passwordText.setText(newPass.generatePassword());

            }
        });


        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String copyString = passwordText.getText();
                StringSelection stringSelection = new StringSelection(copyString);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });


        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        frame.add(welcome);
        frame.add(length);
        frame.add(lengthBox);
        frame.add(symCheck);
        frame.add(numCheck);
        frame.add(letterCases);
        frame.add(caseText);
        frame.add(generateButton);
        frame.add(newPassText);
        frame.add(passwordText);
        frame.add(copyButton);
        frame.add(closeButton);
        frame.add(nothing);
    }

}
