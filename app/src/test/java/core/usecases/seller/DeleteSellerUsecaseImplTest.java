package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DeleteSellerUsecaseImplTest {
    @Test
    public void deleteSeller() {
        SellerRepository repository = Mockito.mock(SellerRepository.class);
        DeleteSellerUsecase usecase = new DeleteSellerUsecaseImpl(repository);
        usecase.apply(new Seller());
        Mockito.verify(repository).delete(Mockito.any());
    }
}