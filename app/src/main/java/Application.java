import external.db.builder.BuilderPropertiesDBConnection;
import external.db.builder.ManagerDBConnection;

/**
 * Estudo do acesso a dados através da API
 * JDBC.
 *
 * @author Rodrigo Andrade
 * @since 01-14-2022
 * @version 1.0
 */
public class Application {
    public static void main(String[] args) {
        ManagerDBConnection.builderDBConnection(new BuilderPropertiesDBConnection());
        ManagerDBConnection.singletonConnection();
        ManagerDBConnection.closeSingletonConnection();
    }
}
