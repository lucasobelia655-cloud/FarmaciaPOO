import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL = "jdbc:sqlite:farmacia.db";

    // Abre una conexión a la base de datos (con llaves foráneas activadas)
    public static Connection obtener() throws SQLException {
        Connection c = DriverManager.getConnection(URL);
        try (Statement st = c.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return c;
    }

    // Lee schema.sql y crea las tablas si todavía no existen
    public static void inicializar() throws SQLException, IOException {
        String sql = Files.readString(Path.of("schema.sql"));
        try (Connection c = obtener(); Statement st = c.createStatement()) {
            for (String instruccion : sql.split(";")) {
                if (!instruccion.isBlank()) {
                    st.execute(instruccion);
                }
            }
        }
    }
}