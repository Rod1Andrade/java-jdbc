package infra.models;

import core.entities.Department;

public class DepartmentModel extends Department {
    public DepartmentModel() {
        super();
    }

    public DepartmentModel(String name) {
        super(name);
    }

    public DepartmentModel(int id, String name) {
        super(id, name);
    }

    public static DepartmentModel cast(Department department) {
        return new DepartmentModel(department.getName());
    }
}
