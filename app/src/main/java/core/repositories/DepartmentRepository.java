package core.repositories;

import core.entities.Department;
import infra.models.DepartmentModel;

import java.util.List;

public interface DepartmentRepository {
    List<Department> getAll();
    Department getById(int id);
    int save(Department departmentModel);
    void deleteById(int id);
    void delete(Department departmentModel);
}
