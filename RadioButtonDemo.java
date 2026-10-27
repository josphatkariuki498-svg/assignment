import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JAVA (ASSIGNMENT 2): Radio Button Demo
 * Select a pet using one of five radio buttons.
 * The selected pet is displayed and a message box confirms the selection.
 */
public class RadioButtonDemo extends JFrame {
    private final JLabel petImageLabel;
    private final JLabel selectedPetLabel;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 370);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(24, 10));
        mainPanel.setBorder(new EmptyBorder(22, 24, 22, 24));
        mainPanel.setBackground(new Color(245, 245, 245));

        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new BoxLayout(choicesPanel, BoxLayout.Y_AXIS));
        choicesPanel.setOpaque(false);

        JLabel heading = new JLabel("Choose a pet:");
        heading.setFont(new Font("SansSerif", Font.BOLD, 16));
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);
        choicesPanel.add(heading);
        choicesPanel.add(Box.createVerticalStrut(12));

        ButtonGroup group = new ButtonGroup();
        String[] pets = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
        String[] pictures = {"🐦", "🐱", "🐶", "🐰", "🐷"};

        petImageLabel = new JLabel("🐷", SwingConstants.CENTER);
        petImageLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 100));
        selectedPetLabel = new JLabel("Pig", SwingConstants.CENTER);
        selectedPetLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        for (int i = 0; i < pets.length; i++) {
            final String pet = pets[i];
            final String picture = pictures[i];

            JRadioButton radioButton = new JRadioButton(pet);
            radioButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
            radioButton.setOpaque(false);
            radioButton.setFocusPainted(false);
            radioButton.setAlignmentX(Component.LEFT_ALIGNMENT);
            group.add(radioButton);
            choicesPanel.add(radioButton);
            choicesPanel.add(Box.createVerticalStrut(7));

            radioButton.addActionListener((ActionEvent e) -> {
                petImageLabel.setText(picture);
                selectedPetLabel.setText(pet);
                JOptionPane.showMessageDialog(
                    this,
                    "You selected: " + pet,
                    "Pet Selection",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });

            if (pet.equals("Pig")) {
                radioButton.setSelected(true);
            }
        }

        JPanel displayPanel = new JPanel(new BorderLayout(5, 8));
        displayPanel.setBackground(Color.WHITE);
        displayPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(210, 210, 210)),
            new EmptyBorder(12, 12, 12, 12)
        ));
        displayPanel.add(petImageLabel, BorderLayout.CENTER);
        displayPanel.add(selectedPetLabel, BorderLayout.SOUTH);

        mainPanel.add(choicesPanel, BorderLayout.WEST);
        mainPanel.add(displayPanel, BorderLayout.CENTER);

        JLabel footer = new JLabel("Select a radio button to display the pet and show a message.", SwingConstants.CENTER);
        footer.setFont(new Font("SansSerif", Font.PLAIN, 12));
        footer.setBorder(new EmptyBorder(0, 5, 10, 5));

        add(mainPanel, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonDemo().setVisible(true));
    }
}
