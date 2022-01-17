package core.usecases.department;

import core.entities.Department;
import core.repositories.DepartmentRepository;

import java.util.List;

public class GetAllDepartmentUsecaseImpl implements GetAllDepartmentUsecase{

    private final DepartmentRepository repository;

    public GetAllDepartmentUsecaseImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Department> apply() {
        return repository.getAll();
    }
}
