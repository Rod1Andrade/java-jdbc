package external.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com banco de dados.
 *
 * @author Rodrigo Andrade
 * @version 1.0
 * @since 01-14-2022
 */
public class DatabaseConnection {

    private final String host;
    private final String user;
    private final String password;
    private final String database;
    private final String port;
    private final String URI;

    public DatabaseConnection(String host, String user, String password, String database, String port, String URI) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
        this.port = port;
        this.URI = URI;
    }

    /**
     * Retorna um conexão com o banco de dados.
     *
     * @return Connection
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    URI,
                    user,
                    password
            );
        } catch (SQLException e) {
            throw new DatabaseException("Impossível estabelecer conexão: " + e.getMessage());
        }
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public String getPort() {
        return port;
    }

    public String getURI() {
        return URI;
    }
}
