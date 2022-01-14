package external.db.builder;

import external.db.DatabaseConnection;
import external.db.DatabaseException;
import external.util.Loader;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Constroi uma conexao a partir de um arquivo properties.
 *
 * @author Rodrigo Andrade
 */
public class BuilderPropertiesDBConnection implements BuilderDBConnection {

    private DatabaseConnection databaseConnection;
    private Connection connection;

    public static final String PROPERTIE_PATH = "src/main/resources/application.properties";
    private final Properties properties;

    public BuilderPropertiesDBConnection() {
        properties = Loader.properties(PROPERTIE_PATH);
    }

    @Override
    public void instanceDatabaseConnection() {
        databaseConnection = new DatabaseConnection(
                properties.getProperty("Host"),
                properties.getProperty("User"),
                properties.getProperty("Password"),
                properties.getProperty("Database"),
                properties.getProperty("Port"),
                properties.getProperty("URI")
        );
    }

    @Override
    public DatabaseConnection getInstanceDatabaseConnection() {
        return databaseConnection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void createConnection() {
        connection = databaseConnection.getConnection();
    }

    @Override
    public void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DatabaseException("Impossível fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}
