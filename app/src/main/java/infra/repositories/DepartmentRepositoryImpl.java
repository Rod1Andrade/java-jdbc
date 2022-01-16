package infra.repositories;

import core.entities.Department;
import core.repositories.DepartmentRepository;
import infra.drivers.DepartmentDriver;

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
                .map(model -> new Department(model.getId(), model.getName()))
                .collect(Collectors.toList());
    }
}
