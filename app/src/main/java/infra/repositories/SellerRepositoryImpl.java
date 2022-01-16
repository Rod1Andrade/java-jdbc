package infra.repositories;

import core.entities.Seller;
import core.repositories.SellerRepository;
import infra.drivers.SellerDriver;
import infra.models.SellerModel;

public class SellerRepositoryImpl implements SellerRepository {
    private final SellerDriver driver;

    public SellerRepositoryImpl(SellerDriver driver) {
        this.driver = driver;
    }

    @Override
    public int save(Seller seller) {
        return driver.save(SellerModel.cast(seller));
    }
}
