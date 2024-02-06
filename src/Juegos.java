import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Juegos {
    int id;
    String nombre;
    Double Precio;
    String Genero;
    String Foto;

    public Juegos(){

    }
    public Juegos(int id, String nombre, Double precio, String genero, String foto) {
        this.id = id;
        this.nombre = nombre;
        Precio = precio;
        Genero = genero;
        Foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public boolean agregaraBD(String Nombre, double Precio, String Genero, String Foto) throws SQLException {
        String insercion;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos", "root", "")) {
            String sql = "INSERT INTO juegos (Nombre, Precio, Genero, Foto) values (?, ? , ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, Nombre);
                preparedStatement.setDouble(2, Precio);
                preparedStatement.setString(3, Genero);
                preparedStatement.setString(4, Foto);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    insercion = "insercion exitosa";
                    System.out.println(insercion);
                } else {
                    insercion = "insercion erronea";
                    System.out.println(insercion);
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            return true;
        }
    }
}
