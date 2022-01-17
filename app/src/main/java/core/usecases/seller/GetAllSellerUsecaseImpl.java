package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;

import java.util.List;

public class GetAllSellerUsecaseImpl implements GetAllSellerUsecase{
    private final SellerRepository repository;

    public GetAllSellerUsecaseImpl(SellerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Seller> apply() {
        return repository.getAll();
    }
}
