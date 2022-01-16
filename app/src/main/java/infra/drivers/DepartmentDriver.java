package infra.drivers;

import infra.models.DepartmentModel;

import java.util.List;

public interface DepartmentDriver {
    List<DepartmentModel> getAll();
}
