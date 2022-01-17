package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CreateSellerUsecaseImplTest {

    @Test
    void createSellerTest() {
        SellerRepository repository = Mockito.mock(SellerRepository.class);

        Mockito.when(repository.save(Mockito.any())).thenReturn(1);

        CreateSellerUsecase usecase = new CreateSellerUsecaseImpl(repository);
        assertEquals(1, usecase.apply(new Seller()));
    }
}