package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;

public class DeleteSellerUsecaseImpl implements DeleteSellerUsecase {

    private final SellerRepository repository;

    public DeleteSellerUsecaseImpl(SellerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void apply(Seller seller) {
        repository.delete(seller);
    }
}
