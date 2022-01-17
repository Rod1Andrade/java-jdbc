package core.repositories;

import core.entities.Seller;

import java.util.List;

public interface SellerRepository {
    int save(Seller seller);
    List<Seller> getAll();
    Seller getById(int id);
    void deleteById(int id);
    void delete(Seller sellerModel);
}
