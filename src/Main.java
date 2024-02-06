import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JFrame menuinsercion = new JFrame("Ingreso de calificaciones");
        menuinsercion.setContentPane(new menuinsercion().menu);
        menuinsercion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuinsercion.setSize(400, 400);
        menuinsercion.setVisible(true);
    }
}