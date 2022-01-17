package core.usecases.seller;

import core.entities.Seller;

public interface GetSellerByIdUsecase {
    Seller apply(int id);
}
