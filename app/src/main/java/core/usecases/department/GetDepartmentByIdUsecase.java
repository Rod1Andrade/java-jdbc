package core.usecases.department;

import core.entities.Department;

public interface GetDepartmentByIdUsecase {
    Department apply(int id);
}
