package external.facades;

import core.entities.Seller;
import core.repositories.SellerRepository;
import core.usecases.CreateSellerUsecase;
import core.usecases.CreateSellerUsecaseImpl;
import external.drivers.SellerDBDriver;
import infra.drivers.SellerDriver;
import infra.repositories.SellerRepositoryImpl;

import java.sql.Connection;

public class SellerFacade {
    private final Connection connection;

    private static SellerFacade instance;

    private SellerFacade(Connection connection) {
        this.connection = connection;
    }

    public static SellerFacade getInstance(Connection connection) {
        if (instance == null)
            instance = new SellerFacade(connection);
        return instance;
    }

    public int createSeller(Seller seller) {
        SellerDriver driver = new SellerDBDriver(connection);
        SellerRepository repository = new SellerRepositoryImpl(driver);
        CreateSellerUsecase usecase = new CreateSellerUsecaseImpl(repository);

        return usecase.apply(seller);
    }
}
