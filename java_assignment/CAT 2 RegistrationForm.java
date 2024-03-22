import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class RegistrationForm extends JFrame {
    private JTextField NameField;
    private JTextField MobileField;
    private JTextField AddressField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton submitButton;
    private JButton resetButton;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JCheckBox termsCheckBox;
    public RegistrationForm() {
        setTitle("User Registration");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel NameLabel = new JLabel("Name:");
        JLabel MobileLabel = new JLabel("Mobile:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel dobLabel = new JLabel("Date of Birth:");
        JLabel AddressLabel = new JLabel("Address:");
        NameField = new JTextField(10);
        MobileField = new JTextField(10);
        AddressField = new JTextField(10);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = Integer.toString(i);
        }
        dayComboBox = new JComboBox<>(days);
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = Integer.toString(i);
        }
        monthComboBox = new JComboBox<>(months);
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) {
            years[i] = Integer.toString(2024 - i);  // Assuming the current year is 2024
        }
        yearComboBox = new JComboBox<>(years);
        termsCheckBox = new JCheckBox("I accept the terms and conditions");
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!termsCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "You must accept the terms and conditions to register.");
                return;
            }

            String Name = NameField.getText();
            String Mobile = MobileField.getText();
            String Address = AddressField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String dob = dayComboBox.getSelectedItem() + "/" + monthComboBox.getSelectedItem() + "/" + yearComboBox.getSelectedItem();

        // Database connection and data insertion
            String url = "jdbc:mysql://localhost:3306/registrationdb";
            String username = "root";
            String password = "";  // default password for XAMPP MySQL is empty

            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                String sql = "INSERT INTO your_table_name (Name, Mobile, Address, Gender, DOB) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, Name);
                statement.setString(2, Mobile);
                statement.setString(3, Address);
                statement.setString(4, gender);
                statement.setString(5, dob);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Registration successful!");
                }
                connection.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        });

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NameField.setText("");
                MobileField.setText("");
                AddressField.setText("");
                genderGroup.clearSelection();
                dayComboBox.setSelectedIndex(0);
                monthComboBox.setSelectedIndex(0);
                yearComboBox.setSelectedIndex(0);
                termsCheckBox.setSelected(false);
            }
        });
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(NameLabel, constraints);
        constraints.gridx = 1;
        add(NameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(MobileLabel, constraints);
        constraints.gridx = 1;
        add(MobileField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(genderLabel, constraints);
        constraints.gridx = 1;
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        add(genderPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(dobLabel, constraints);
        constraints.gridx = 1;
        JPanel dobPanel = new JPanel(); 
        dobPanel.add(dayComboBox);
        dobPanel.add(monthComboBox);
        dobPanel.add(yearComboBox);
        add(dobPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(AddressLabel, constraints);
        constraints.gridx = 1;
        add(AddressField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(termsCheckBox, constraints);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        add(submitButton, constraints);
        constraints.gridx = 1;
        add(resetButton, constraints);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm());
    }
}



