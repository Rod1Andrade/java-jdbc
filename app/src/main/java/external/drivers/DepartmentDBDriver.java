package external.drivers;

import external.exceptions.DriverException;
import infra.drivers.DepartmentDriver;
import infra.models.DepartmentModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDBDriver implements DepartmentDriver {

    private final Connection connection;

    public DepartmentDBDriver(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<DepartmentModel> getAll() {
        String sql = "SELECT * FROM public.department";
        List<DepartmentModel> departmentModels = new ArrayList<>();

        try (
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                departmentModels.add(new DepartmentModel(id, name));
            }

            return departmentModels;
        } catch (SQLException e) {
            throw new DriverException("Impossibel recuperar os dados atraves desse Driver: " + e.getMessage());
        }
    }
}
