package external.db.builder;

import java.sql.Connection;

/**
 * Gerenciador da conexão com base nos builders: Define a ordem de chamado do builder.
 *
 * @author Rodrigo Andrade
 */
public class ManagerDBConnection {

    private static BuilderDBConnection builderDBConnection;
    private static Connection connection;

    /**
     * Define o Builder
     *
     * @param builderDBConnection BuilderDBConnection
     */
    public static void builderDBConnection(BuilderDBConnection builderDBConnection) {
        if (ManagerDBConnection.builderDBConnection == null)
            ManagerDBConnection.builderDBConnection = builderDBConnection;

    }

    /**
     * Altera o Builder
     *
     * @param builderDBConnection BuilderDBConnection
     */
    public static void changeBuilderDBConnection(BuilderDBConnection builderDBConnection) {
        if (ManagerDBConnection.builderDBConnection != null)
            ManagerDBConnection.builderDBConnection = builderDBConnection;
    }

    /**
     * Pega uma instancia da conexao.
     *
     * @return Connection
     */
    public static Connection singletonConnection() {
        if (connection == null) {
            ManagerDBConnection.builderDBConnection.instanceDatabaseConnection();
            ManagerDBConnection.builderDBConnection.createConnection();

            connection = ManagerDBConnection.builderDBConnection.getConnection();
        }

        return connection;
    }

    /**
     * Fecha uma instancia da conexao.
     */
    public static void closeSingletonConnection() {
        if(connection != null) {
            ManagerDBConnection.builderDBConnection.closeConnection();
        }
    }
}
