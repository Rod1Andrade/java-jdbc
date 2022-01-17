package core.usecases.seller;

import core.entities.Seller;
import core.repositories.SellerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetAllSellerUsecaseImplTest {

    @Test
    public void shouldGetAllSellerTest() {
        List<Seller> sellers = new ArrayList<>();
        SellerRepository repository = Mockito.mock(SellerRepository.class);
        Mockito.when(repository.getAll()).thenReturn(sellers);

        GetAllSellerUsecase usecase = new GetAllSellerUsecaseImpl(repository);
        assertIterableEquals(sellers, usecase.apply());
    }
}