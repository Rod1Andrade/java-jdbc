package core.usecases.seller;

import core.repositories.SellerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeleteSellerByIdUsecaseImplTest {
    @Test
    void shouldDeleteSellerByIdTest() {
        SellerRepository repository = Mockito.mock(SellerRepository.class);
        DeleteSellerByIdUsecase usecase = new DeleteSellerByIdUsecaseImpl(repository);
        usecase.apply(1);

        Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
    }
}