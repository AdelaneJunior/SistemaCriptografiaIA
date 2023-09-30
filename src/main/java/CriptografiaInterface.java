import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriptografiaInterface extends JFrame {

    private Criptografia criptografia;
    private JTextArea entradaTextArea;
    private JTextArea saidaTextArea;
    private JButton criptografarButton;
    private JButton descriptografarButton;

    public CriptografiaInterface() {
        criptografia = new Criptografia();

        setTitle("Criptografia Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(700, 150);

        entradaTextArea = new JTextArea();
        saidaTextArea = new JTextArea();
        criptografarButton = new JButton("CRIPTOGRAFAR");
        descriptografarButton = new JButton("DESCRIPTOGRAFAR");

        JPanel textAreasPanel = new JPanel(new GridLayout(1, 2));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("ENTRADA"), BorderLayout.NORTH);
        inputPanel.add(new JScrollPane(entradaTextArea), BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("SAIDA"), BorderLayout.NORTH);
        outputPanel.add(new JScrollPane(saidaTextArea), BorderLayout.CENTER);

        textAreasPanel.add(inputPanel);
        textAreasPanel.add(outputPanel);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(criptografarButton);
        buttonsPanel.add(descriptografarButton);

        add(textAreasPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        criptografarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = entradaTextArea.getText();
                String encrypted = criptografia.criptografarMensagem(input);
                saidaTextArea.setText(encrypted);
            }
        });

        descriptografarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = entradaTextArea.getText();
                String decrypted = criptografia.descriptografarMensagem(input);
                saidaTextArea.setText(decrypted);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        CriptografiaInterface criptografiaInterface = new CriptografiaInterface();

    }
}
