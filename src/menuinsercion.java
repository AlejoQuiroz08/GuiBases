import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuinsercion {
    private JButton conexionABaseDeButton;
    public JPanel menu;
    private JLabel mensajeTxt;
    private JTextField nombreText;
    private JTextField cedulaText;
    private JTextField c1Text;
    private JTextField c2Text;
    private JButton insertarButton;
    private JButton borrarCamposButton;

    public menuinsercion() {
        conexionABaseDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionBD miconexion= new ConexionBD();
                miconexion.ConexionLocal("jdbc:mysql://localhost:3306/estudiantes", "root", "");
                mensajeTxt.setText(miconexion.getMensaje());
            }
        });
        borrarCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreText.setText("");
                cedulaText.setText("");
                c1Text.setText("");
                c2Text.setText("");
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertarDatos insercion= new InsertarDatos();
                insercion.InsertarDatos(nombreText.getText(), cedulaText.getText(), Integer.parseInt(c1Text.getText()) , Integer.parseInt(c2Text.getText()));

            }
        });
    }
}
