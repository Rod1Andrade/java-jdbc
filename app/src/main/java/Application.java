import core.entities.Department;
import core.entities.Seller;
import external.db.builder.BuilderPropertiesDBConnection;
import external.db.builder.ManagerDBConnection;
import external.facades.DepartmentFacade;
import external.facades.SellerFacade;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        ManagerDBConnection.builderDBConnection(new BuilderPropertiesDBConnection());
        Connection connection = ManagerDBConnection.singletonConnection();

        DepartmentFacade departmentFacade = DepartmentFacade.getInstance(connection);

        List<Department> departments = departmentFacade.getAll();
        System.out.println(Arrays.toString(departments.toArray()));

        SellerFacade sellerFacade = SellerFacade.getInstance(connection);

        int id = sellerFacade.createSeller(
                new Seller(
                        "Rodrigo Andrade",
                        "rod1.andrade@email.com",
                        simpleDateFormat.parse("15/07/1999"),
                        2500.0,
                        departments.get(0)
                )
        );

        System.out.println("Seller id: " + id);

        ManagerDBConnection.closeSingletonConnection();
    }
}
