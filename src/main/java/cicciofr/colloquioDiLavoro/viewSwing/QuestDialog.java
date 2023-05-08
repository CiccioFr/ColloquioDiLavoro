package main.java.cicciofr.colloquioDiLavoro.viewSwing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QuestDialog extends JFrame {

    private String nome;

    public QuestDialog() {
//        SwingUtilities.invokeLater(() -> initComponents());
        SwingUtilities.invokeLater(this::initComponents);
    }

    private void initComponents() {

        // Elementi della finestra grafica
        JLabel label = new JLabel("Inserisci il tuo nome:");
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton buttonOk = new JButton("OK");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Aggiunge un margine di 10 pixel intorno al pannello
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonOk, BorderLayout.SOUTH);

        getContentPane().add(panel);

        // Listener() "Ascolta le azioni (eventi)" sul componente (il Button "OK" in questo caso)
        buttonOk.addActionListener(e -> {
            nome = textArea.getText(); // Recupera il testo inserito dall'utente
            JOptionPane.showMessageDialog(this, "Ciao, " + nome + "!");
            dispose();
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getNome() {
        return nome;
    }

    public static void main(String[] args) {
        QuestDialog dialog = new QuestDialog();

        // occorre settare per verificare nel while
        dialog.setVisible(true);
        // Attendiamo la "chiusura" della finestra
        // altrimenti eseguirebbe il codice prima che l'utente inserisca il nome e valorizzerebbe a null la variabile "nome"
        while (dialog.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String nome = dialog.getNome();
        System.out.println("Nome inserito: " + nome);
    }

}
