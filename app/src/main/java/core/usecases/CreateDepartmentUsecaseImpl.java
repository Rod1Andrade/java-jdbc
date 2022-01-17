package core.usecases;

import core.entities.Department;
import core.repositories.DepartmentRepository;

public class CreateDepartmentUsecaseImpl implements CreateDepartmentUsecase{

    private final DepartmentRepository repository;

    public CreateDepartmentUsecaseImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public int apply(Department department) {
        return repository.save(department);
    }
}
