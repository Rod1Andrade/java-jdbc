package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeleteSellerUsecaseImplTest {
    @Test
    public void shouldDeleteSellerByReferenceTest() {
        SellerRepository repository = Mockito.mock(SellerRepository.class);
        DeleteSellerUsecase usecase = new DeleteSellerUsecaseImpl(repository);
        usecase.apply(new Seller());
        Mockito.verify(repository).delete(Mockito.any());
    }
}