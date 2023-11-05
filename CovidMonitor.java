//maam zesty code 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Extends JFrame
public class CovidMonitor extends JFrame {
    
    // Set all to private
    private static Queue<Patient> queue = new LinkedList<>();
    private JTextArea textArea;
    private JButton addButton;
    private JButton processButton;
    
    // Set the constructor to public
    public CovidMonitor() {       
        // Title
        setTitle("Covid-19 Monitor");
        
        // Label at the top 
        JLabel titleLabel = new JLabel("Covid-19 Patient Monitoring", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));
        add(titleLabel, BorderLayout.NORTH);
        
        // Label at the bottom
        JLabel helloLabel = new JLabel("Phinmaed Case Program", SwingConstants.LEFT);
        add(helloLabel, BorderLayout.SOUTH);
        
        // Customize the frame
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        // Create a text area
        textArea = new JTextArea();
        
        // Make the it not editable
        textArea.setEditable(false);
        
        // Crate a scrollpane and add the textarea
        JScrollPane pane = new JScrollPane(textArea);
        
        // Add the scrollpane to the frame and place it to the center
        add(pane, BorderLayout.CENTER);
        
        // Add button
        addButton = new JButton("Add Patient");
        // ActionListener of add button
        addButton.addActionListener(new AddButtonListener());

        // Process button
        processButton = new JButton("Process Patient");
        // ActionListener of process button
        processButton.addActionListener(new ProcessButtonListener());
        
        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        // Add the buttons to the buttonPanel
        buttonPanel.add(addButton);
        buttonPanel.add(processButton);
        
        // Add the buttonPanel to frame and place it to the bottom
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Set the visible of frame to true
        setVisible(true);
    }

    // Function then the add button is clicked
    private class AddButtonListener implements ActionListener {
        
        // Override
        @Override
        public void actionPerformed(ActionEvent e) {
            
            // JOption pane for firstname, lastname and symptoms
            String firstName = JOptionPane.showInputDialog(CovidMonitor.this, "Enter patient's first name");
            String lastName = JOptionPane.showInputDialog(CovidMonitor.this, "Enter patient's last name");
            String symptoms = JOptionPane.showInputDialog(CovidMonitor.this, "Enter patient's symptoms");
            
            // Add it to the queue
            queue.add(new Patient(firstName, lastName, symptoms));

            // Add some text to the text area
            textArea.append("Added Patient: " + firstName + " " + lastName + " " + symptoms + "\n");
        }
    }
    
    // Function when the process button is clicked
    private class ProcessButtonListener implements ActionListener {
        
        // Override
        @Override
        public void actionPerformed(ActionEvent e) {
            
            // Check first if the queue is not empty
            if(!queue.isEmpty()) {
               Patient patient = queue.poll();
               textArea.append("Processing Patient: " + patient.getfirstName() + " " + patient.getlastName() + " " + patient.getSymptoms()+ "\n");
            }
            
            // If the queue is empty
            else {
                textArea.append("No Patients to Process\n");
            }
        } 
        
    }

    // Main method
    public static void main(String args[]) {
        CovidMonitor monitor = new CovidMonitor();
    }
}

// Patient class
class Patient {
    private String firstName;
    private String lastName;
    private String symptoms;
    
    // Constructor
    public Patient(String firstName, String lastName, String symptoms) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.symptoms = symptoms;
    }
    

    // Getters
    public String getfirstName() {
        return firstName;
    }
    
    // Getters
    public String getlastName() {
        return lastName;
    }
    
    // Getters
    public String getSymptoms() {
        return symptoms;
    }
}
