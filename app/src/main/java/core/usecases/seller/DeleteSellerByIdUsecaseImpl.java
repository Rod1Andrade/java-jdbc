package core.usecases.seller;

import core.repositories.SellerRepository;

public class DeleteSellerByIdUsecaseImpl implements DeleteSellerByIdUsecase {

    private final SellerRepository repository;

    public DeleteSellerByIdUsecaseImpl(SellerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void apply(int id) {
        System.out.println(id);
        repository.deleteById(id);
    }
}
