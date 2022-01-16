import core.entities.Department;
import external.db.builder.BuilderPropertiesDBConnection;
import external.db.builder.ManagerDBConnection;
import external.facades.DepartmentFacade;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

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
        Connection connection = ManagerDBConnection.singletonConnection();

        DepartmentFacade facade = DepartmentFacade.getInstance(connection);

        List<Department> departments = facade.getAll();
        System.out.println(Arrays.toString(departments.toArray()));

        ManagerDBConnection.closeSingletonConnection();
    }
}
