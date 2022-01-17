package external.drivers;

import external.exceptions.DriverException;
import infra.drivers.DepartmentDriver;
import infra.models.DepartmentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDBDriver implements DepartmentDriver {

    private final Connection connection;

    public DepartmentDBDriver(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int save(DepartmentModel departmentModel) {
        return 0;
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

    @Override
    public DepartmentModel getById(int id) {
        String sql = "SELECT * FROM public.department WHERE id = ?";
        DepartmentModel departmentModel = null;
        try (
                PreparedStatement pst = connection.prepareStatement(sql);
        ) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
                departmentModel = new DepartmentModel(rs.getInt("id"), rs.getString("name"));

            return departmentModel;
        } catch (SQLException e) {
            throw new DriverException("Impossibel recuperar os dados atraves desse Driver: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(DepartmentModel departmentModel) {

    }
}
