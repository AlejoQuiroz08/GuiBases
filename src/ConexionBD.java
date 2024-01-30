import java.sql.*;

public class ConexionBD {
    String servidor;
    String Usuario;
    String Password;
    String mensaje;
    public ConexionBD(String servidor, String usuario, String password) {
        this.servidor = servidor;
        this.Usuario = usuario;
        this.Password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ConexionBD() {

    }

    public void ConexionLocal(String Servidor, String Usuario, String Password){
        try(Connection conexion= DriverManager.getConnection(Servidor, Usuario, Password)){
            if (conexion!= null){
                mensaje= "Conexion correcta";
                System.out.println(mensaje);
            }

        }
        catch (SQLException sqlex){
            mensaje= "Conexion erronea";
            System.out.println(mensaje);
        }
    }
}
