package infra.drivers;

import infra.models.SellerModel;

import java.util.List;

public interface SellerDriver {
    int save(SellerModel sellerModel);
    List<SellerModel> getAll();
    SellerModel getById(int id);
    void deleteById(int id);
    void delete(SellerModel sellerModel);
}
