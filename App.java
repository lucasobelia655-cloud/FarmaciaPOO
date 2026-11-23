import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class App {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Farmacia POO");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JLabel texto = new JLabel("¡Ya jaló la ventana!", SwingConstants.CENTER);
        ventana.add(texto);

        ventana.setVisible(true);
    }
}