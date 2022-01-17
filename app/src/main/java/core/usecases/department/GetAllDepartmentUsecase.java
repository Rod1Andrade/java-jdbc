package core.usecases.department;

import core.entities.Department;

import java.util.List;

public interface GetAllDepartmentUsecase {
    List<Department> apply();
}
