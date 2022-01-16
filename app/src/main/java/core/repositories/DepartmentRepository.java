package core.repositories;

import core.entities.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> getAll();
}
