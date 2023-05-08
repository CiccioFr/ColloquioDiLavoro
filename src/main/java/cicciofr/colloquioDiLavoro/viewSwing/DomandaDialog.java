package main.java.cicciofr.colloquioDiLavoro.viewSwing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class DomandaDialog extends JFrame {
    String risposta;

    private String getRisposta() {
        return risposta;
    }

    private DomandaDialog(String argomento, String domanda) {
        /**
         * <p> SwingUtilities.invokeLater </p>
         * esegue Runnable sul thread di invio di eventi AWT.
         * Perché farlo? Poiché le strutture dati Swing non sono thread-safe, quindi per fornire ai programmatori
         * un modo facilmente realizzabile per impedire l'accesso simultaneo ad esse, i progettisti Swing
         * hanno stabilito la regola secondo cui tutto il codice che vi accede deve essere eseguito sullo stesso thread.
         * Ciò avviene automaticamente per la gestione degli eventi e il codice di manutenzione del display,
         * ma se hai avviato un'azione di lunga durata, ovviamente su un nuovo thread, come puoi segnalarne
         * l'avanzamento o il completamento? Devi modificare un controllo Swing e devi farlo dal thread di invio di eventi.
         * Quindi invokeLater.
         */
        SwingUtilities.invokeLater(
                () -> initComponents(argomento, domanda)
        );
    }

    private void initComponents(String argomento, String domanda) {

        // --  Elementi label  --
        JLabel labelArgomento = new JLabel("Argomento:" + argomento);
        JLabel labelDomanda = new JLabel("Domanda:" + domanda);
        // componente che li contiene
        JPanel labelPanel = new JPanel();
        labelPanel.setBorder(new EmptyBorder(0, 10, 10, 10)); // Aggiunge un margine in pixel intorno al pannello
        labelPanel.setLayout(new GridLayout(2, 1));
        labelPanel.add(labelArgomento);
        labelPanel.add(labelDomanda);

//        JTextField textField = new JTextField(20);

        // --  Elemento textArea  --
        JTextArea textArea = new JTextArea(12, 70);
        // Abilita il wrap testuale
        // definisce se le righe di testo devono andare a capo automaticamente quando raggiungono il bordo
        textArea.setLineWrap(true);
        // Abilita il wrap di parole intere
        // definisce se il testo deve essere interrotto solo al termine di una parola completa
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // --  Elemento Pulsante  --
        JButton button = new JButton("OK");

        // --  creazione Finestra  --
        // Settaggio
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Aggiunge un margine in pixel intorno al pannello
        // Aggiunta Elementi
//        panel.add(label);
        panel.add(labelPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        getContentPane().add(panel);

        // --  attivazione del Click su pulsante  --
        button.addActionListener(e -> {
//            String testoUtente = textField.getText();
            risposta = textArea.getText();
//            JOptionPane.showMessageDialog(this, "Risposta: " + risposta + "!");
//            System.out.println("Risposta interna:" + risposta);
            dispose();
        });

        // adatta la dimensione del frame alle dimensioni dei suoi componenti interni
        pack();
        // posiziona il frame al centro dello schermo
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static String poniDomanda(String argomento, String domanda) {

        DomandaDialog dialog = new DomandaDialog(argomento, domanda);

        dialog.setTitle("Questionario per Selezione del candidato " + " " + "");
        dialog.setSize(850, 420);
        dialog.setVisible(true);

        // Attendiamo che la finestra venga chiusa dall'utente
        while (dialog.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return dialog.getRisposta();
    }


    // ---------

//    public void newDialog() {
//        setTitle("Inserisci il tuo nome");
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setModal(true);
//        setSize(300, 200);
//
//        // Creiamo il pannello per gli elementi di testo
//        JPanel textPanel = new JPanel();
//        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
//        JLabel label1 = new JLabel("Inserisci il tuo nome:");
//        JLabel label2 = new JLabel("e premi il tasto Invio");
//        textPanel.add(label1);
//        textPanel.add(label2);
//
//        // Creiamo la JTextArea
//        textArea = new JTextArea();
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
//
//        // Creiamo il pannello per la JTextArea
//        JPanel mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        mainPanel.add(textPanel, BorderLayout.NORTH);
//        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
//
//        // Aggiungiamo il pannello principale alla finestra
//        setContentPane(mainPanel);
//
//        // Aggiungiamo il listener per gestire l'evento di chiusura della finestra
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                dispose();
//            }
//        });
//
//        // Aggiungiamo il listener per gestire l'evento del tasto Invio
//        textArea.addActionListener(e -> {
//            nome = textArea.getText();
//            dispose();
//        });
//    }
}