package infra.repositories;

import core.entities.Seller;
import core.repositories.SellerRepository;
import infra.drivers.SellerDriver;
import infra.models.SellerModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SellerRepositoryImplTest {

    SellerDriver driver = Mockito.mock(SellerDriver.class);
    SellerRepository repository = new SellerRepositoryImpl(driver);

    @Test
    void shouldSaveASellerTest() {
        Mockito.when(driver.save(Mockito.any())).thenReturn(1);
        int id = repository.save(new Seller());
        assertEquals(1, id);
    }

    @Test
    void shouldGetAllSellers() {
        List<SellerModel> sellers = new ArrayList<>();
        Mockito.when(driver.getAll()).thenReturn(sellers);

        assertIterableEquals(sellers, repository.getAll());
    }

    @Test
    void shouldGetSellerById() {
        SellerModel seller = new SellerModel();
        Mockito.when(repository.getById(Mockito.anyInt())).thenReturn(seller);
        assertInstanceOf(SellerModel.class, repository.getById(1));
    }

    @Test
    void shouldDeleteSellerById() {
        repository.deleteById(1);
        Mockito.verify(driver, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
    }

    @Test
    void shouldDeleteSellerByReference() {
        repository.delete(new Seller());
        Mockito.verify(driver, Mockito.atLeastOnce()).delete(Mockito.any());
    }
}