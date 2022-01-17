package infra.repositories;

import core.entities.Department;
import core.repositories.DepartmentRepository;
import infra.drivers.DepartmentDriver;
import infra.models.DepartmentModel;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private final DepartmentDriver driver;

    public DepartmentRepositoryImpl(DepartmentDriver driver) {
        this.driver = driver;
    }

    @Override
    public List<Department> getAll() {
        return driver.getAll()
                .stream()
                .map(DepartmentModel::upperCast)
                .collect(Collectors.toList());
    }

    @Override
    public Department getById(int id) {
        return driver.getById(id);
    }

    @Override
    public int save(Department department) {
        return driver.save(DepartmentModel.cast(department));
    }

    @Override
    public void deleteById(int id) {
        driver.deleteById(id);
    }

    @Override
    public void delete(Department department) {
        driver.delete(DepartmentModel.cast(department));
    }
}
