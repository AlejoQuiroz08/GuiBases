import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    String Nombre;
    String cedula;
    int calif1;
    int calif2;
    public InsertarDatos(String nombre, String cedula, int calif1, int calif2) {
        this.Nombre = nombre;
        this.cedula = cedula;
        this.calif1 = calif1;
        this.calif2 = calif2;
    }
    public InsertarDatos(){
    }
    public void InsertarDatos(String Nombre, String cedula, int calif1, int calif2){
        String insercion;
        try(Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/estudiantes", "root", "")){
            String sql= "INSERT INTO calificaciones (nombre, cedula, calificacion1, calificacion2) values (?, ? , ?, ?)";
            try(PreparedStatement preparedStatement= conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, Nombre);
                preparedStatement.setString(2, cedula);
                preparedStatement.setInt(3, calif1);
                preparedStatement.setInt(4, calif2);

                int filasAfectadas=preparedStatement.executeUpdate();

                if (filasAfectadas>0){
                    insercion="insercion exitosa";
                    System.out.println(insercion);
                } else {
                    insercion="insercion erronea";
                    System.out.println(insercion);
                }

            }catch (SQLException sqlex) {
            }
        }catch (SQLException sqlex){

        }
    }

}
