package external.drivers;

import external.exceptions.DriverException;
import infra.drivers.SellerDriver;
import infra.models.DepartmentModel;
import infra.models.SellerModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellerDBDriver implements SellerDriver {
    private final Connection connection;

    public SellerDBDriver(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int save(SellerModel sellerModel) {
        String sql = "INSERT INTO public.seller (name, email, birthDate, baseSalary, departmentId)" +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, sellerModel.getName());
            pst.setString(2, sellerModel.getEmail());
            pst.setDate(3, new Date(sellerModel.getBirthDate().getTime()));
            pst.setDouble(4, sellerModel.getBaseSalary());
            pst.setInt(5, sellerModel.getDepartment().getId());

            if (pst.executeUpdate() > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) return rs.getInt(1);
            }

            return 0;

        } catch (SQLException e) {
            throw new DriverException("Impossível Cadastrar Seller: " + e.getMessage());
        }
    }

    @Override
    public List<SellerModel> getAll() {
        String sql = "select s.*, d.\"name\" as departmentName from public.seller s " +
                "inner join public.department d" +
                "on s.departmentid  = d.id";

        List<SellerModel> sellerModels = new ArrayList<>();

        try (
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()
        ) {

            while (rs.next()) {
                DepartmentModel departmentModel = new DepartmentModel(
                        rs.getInt("departmentId"), rs.getString("departmentName")
                );

                SellerModel sellerModel = new SellerModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("birthDate"),
                        rs.getDouble("basseSalary"),
                        departmentModel
                );

                sellerModels.add(sellerModel);
            }

            return sellerModels;
        } catch (SQLException e) {
            throw new DriverException("Impossível recuperar todos Sellers: " + e.getMessage());
        }
    }

    @Override
    public SellerModel getById(int id) {
        String sql = "select s.*, d.\"name\" as departmentName from public.seller s " +
                "inner join public.department d" +
                "on s.departmentid  = d.id" +
                "where s.id = ?";


        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery()
        ) {
            if (rs.next()) {
                DepartmentModel departmentModel = new DepartmentModel(
                        rs.getInt("departmentId"), rs.getString("departmentName")
                );

                return new SellerModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("birthDate"),
                        rs.getDouble("basseSalary"),
                        departmentModel
                );
            }

            return null;
        } catch (SQLException e) {
            throw new DriverException("Impossível recuperar seller por id: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from public.seller " +
                "where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DriverException("Impossível deletar o seller: " + e.getMessage());
        }
    }

    @Override
    public void delete(SellerModel sellerModel) {
        deleteById(sellerModel.getId());
    }
}
