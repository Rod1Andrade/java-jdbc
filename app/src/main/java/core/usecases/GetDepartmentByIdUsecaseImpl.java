package core.usecases;

import core.entities.Department;
import core.repositories.DepartmentRepository;

public class GetDepartmentByIdUsecaseImpl implements GetDepartmentByIdUsecase {

    private final DepartmentRepository repository;

    public GetDepartmentByIdUsecaseImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department apply(int id) {
        return repository.getById(id);
    }
}
