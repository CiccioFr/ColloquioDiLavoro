package main.java.cicciofr.colloquioDiLavoro.viewSwing;

public class NomeEsterno {
    public static void main(String[] args) {
        QuestDialog dialog = new QuestDialog();
        dialog.setVisible(true);

        // Occorre attendere che la finestra venga chiusa (dispose();)
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
