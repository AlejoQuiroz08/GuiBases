import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class menuinsercion {
    private JButton conexionABaseDeButton;
    public JPanel menu;
    private JLabel mensajeTxt;
    private JTextField nombreText;
    private JTextField Precio;
    private JTextField Genero;
    private JTextField Foto;
    private JButton insertarButton;
    private JButton borrarCamposButton;
    private JButton datosButton;

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
                Precio.setText("");
                Genero.setText("");
                Foto.setText("");
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Juegos nuevos= new Juegos();
                try {
                    nuevos.agregaraBD(nombreText.getText(),Double.parseDouble(Precio.getText()), Genero.getText(), Foto.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        datosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Mostrar = new JFrame("Datos");
                Mostrar.setContentPane(new Mostrar().mostrartabla);
                Mostrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Mostrar.setSize(400, 400);
                Mostrar.setVisible(true);
            }
        });
    }
}
