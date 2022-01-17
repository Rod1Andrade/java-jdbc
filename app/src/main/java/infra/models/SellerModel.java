package infra.models;

import core.entities.Department;
import core.entities.Seller;

import java.util.Date;

public class SellerModel extends Seller {
    public SellerModel() {
        super();
    }

    public SellerModel(int id, String name, String email, Date birthDate, double baseSalary, Department department) {
        super(id, name, email, birthDate, baseSalary, department);
    }

    public static SellerModel cast(Seller seller) {
        return new SellerModel(
                seller.getId(),
                seller.getName(),
                seller.getEmail(),
                seller.getBirthDate(),
                seller.getBaseSalary(),
                seller.getDepartment()
        );
    }

    public static Seller upperCast(SellerModel sellerModel) {
        return new Seller(
                sellerModel.getId(),
                sellerModel.getName(),
                sellerModel.getName(),
                sellerModel.getBirthDate(),
                sellerModel.getBaseSalary(),
                sellerModel.getDepartment()
        );
    }
}
