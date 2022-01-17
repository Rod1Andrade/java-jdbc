package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GetSellerByIdUsecaseImplTest {

    @Test
    public void getSellerByIdTest() {
        Seller seller = new Seller();
        SellerRepository repository = Mockito.mock(SellerRepository.class);
        Mockito.when(repository.getById(Mockito.anyInt())).thenReturn(seller);

        GetSellerByIdUsecase usecase = new GetSellerByIdUsecaseImpl(repository);
        assertEquals(seller, usecase.apply(1));
    }
}