package external.facades;

import core.entities.Department;
import core.repositories.DepartmentRepository;
import core.usecases.department.GetAllDepartmentUsecase;
import core.usecases.department.GetAllDepartmentUsecaseImpl;
import core.usecases.department.GetDepartmentByIdUsecase;
import core.usecases.department.GetDepartmentByIdUsecaseImpl;
import external.drivers.DepartmentDBDriver;
import infra.drivers.DepartmentDriver;
import infra.repositories.DepartmentRepositoryImpl;

import java.sql.Connection;
import java.util.List;

public class DepartmentFacade {
    private final Connection connection;
    private static DepartmentFacade instace;

    private DepartmentFacade(Connection connection) {
        this.connection = connection;
    }

    public static DepartmentFacade getInstance(Connection connection) {
        if(instace == null)
            instace = new DepartmentFacade(connection);
        return instace;
    }

    public List<Department> getAll() {
        DepartmentDriver driver = new DepartmentDBDriver(connection);
        DepartmentRepository repository = new DepartmentRepositoryImpl(driver);
        GetAllDepartmentUsecase usecase = new GetAllDepartmentUsecaseImpl(repository);

        return usecase.apply();
    }

    public Department getDeparmentById(int id) {
        DepartmentDriver driver = new DepartmentDBDriver(connection);
        DepartmentRepository repository = new DepartmentRepositoryImpl(driver);
        GetDepartmentByIdUsecase usecase = new GetDepartmentByIdUsecaseImpl(repository);

        return usecase.apply(id);
    }
}
