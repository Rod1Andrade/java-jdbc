package infra.drivers;

import infra.models.DepartmentModel;

import java.util.List;

public interface DepartmentDriver {
    List<DepartmentModel> getAll();
    DepartmentModel getById(int id);
    int save(DepartmentModel departmentModel);
    void deleteById(int id);
    void delete(DepartmentModel departmentModel);
}
