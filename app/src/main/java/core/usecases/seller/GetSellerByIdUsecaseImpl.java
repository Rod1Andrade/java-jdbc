package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;

public class GetSellerByIdUsecaseImpl implements GetSellerByIdUsecase {
    private final SellerRepository repository;

    public GetSellerByIdUsecaseImpl(SellerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Seller apply(int id) {
        return repository.getById(id);
    }
}
