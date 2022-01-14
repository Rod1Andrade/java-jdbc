package external.db.builder;

import external.db.DatabaseConnection;

import java.sql.Connection;

/**
 * Builder para conexão com banco de dados.
 *
 * @author Rodrigo Andrade.
 */
public interface BuilderDBConnection {

    void instanceDatabaseConnection();

    DatabaseConnection getInstanceDatabaseConnection();

    void createConnection();

    Connection getConnection();

    void closeConnection();
}
