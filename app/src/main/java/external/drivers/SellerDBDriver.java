package external.drivers;

import external.exceptions.DriverException;
import infra.drivers.SellerDriver;
import infra.models.SellerModel;

import java.sql.*;
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
        return null;
    }

    @Override
    public SellerModel getById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(SellerModel sellerModel) {

    }
}
