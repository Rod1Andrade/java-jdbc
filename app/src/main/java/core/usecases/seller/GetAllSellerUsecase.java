package core.usecases.seller;

import core.entities.Seller;

import java.util.List;

public interface GetAllSellerUsecase {
    List<Seller> apply();
}
