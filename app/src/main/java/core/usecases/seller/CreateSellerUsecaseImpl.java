package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;

public class CreateSellerUsecaseImpl implements CreateSellerUsecase{

    private final SellerRepository repository;

    public CreateSellerUsecaseImpl(SellerRepository repository) {
        this.repository = repository;
    }

    @Override
    public int apply(Seller seller) {
        return repository.save(seller);
    }
}
