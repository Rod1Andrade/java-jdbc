package core.usecases;

import core.entities.Department;

import java.util.List;

public interface GetAllDepartmentUsecase {
    List<Department> apply();
}
