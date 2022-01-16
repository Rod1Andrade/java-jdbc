package core.usecases;

import core.entities.Department;

public interface GetDepartmentByIdUsecase {
    Department apply(int id);
}
