package infra.repositories;

import core.entities.Seller;
import core.repositories.SellerRepository;
import infra.drivers.SellerDriver;
import infra.models.SellerModel;

import java.util.List;
import java.util.stream.Collectors;

public class SellerRepositoryImpl implements SellerRepository {
    private final SellerDriver driver;

    public SellerRepositoryImpl(SellerDriver driver) {
        this.driver = driver;
    }

    @Override
    public int save(Seller seller) {
        return driver.save(SellerModel.cast(seller));
    }

    @Override
    public List<Seller> getAll() {
        return driver.getAll()
                .stream()
                .map(SellerModel::upperCast)
                .collect(Collectors.toList());
    }

    @Override
    public Seller getById(int id) {
        return driver.getById(id);
    }

    @Override
    public void deleteById(int id) {
        driver.deleteById(id);
    }

    @Override
    public void delete(Seller seller) {
        driver.delete(SellerModel.cast(seller));
    }
}
