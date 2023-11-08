package hibernate.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите, что нужно сделать с БД: 1. Добавить департамент 2. Добавить сотруднкиа 3.Удалить запись сотрудника 4.Показать все записи");
        int variant = scanner.nextInt();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        if (variant == 1) {
            Scanner scanner_dep = new Scanner(System.in);
            System.out.println("Введите данные департамента");
            Department department = new Department();
            System.out.println("Введите название департамента");
            department.setDepartmentName(scanner_dep.nextLine());
            System.out.println("Введите максимальную зарплату");
            department.setMaxSalary(scanner_dep.nextInt());
            System.out.println("Введите минимальную зарплату");
            department.setMinSalary(scanner_dep.nextInt());

            session.save(department);
            System.out.println("Done!");
        } else if (variant == 2) {
            Scanner scanner_emp = new Scanner(System.in);
            System.out.println("Введите данные сотрудника");
            Employee employee = new Employee();
            System.out.println("Введите имя сотрудника");
            employee.setName(scanner_emp.nextLine());
            System.out.println("Введите фамилию сотрудника");
            employee.setSurname(scanner_emp.nextLine());
            System.out.println("Введите зарплату сотрудника");
            employee.setSalary(scanner_emp.nextInt());

            System.out.println("Введите id департамента");
            int idDep = scanner_emp.nextInt();
            Department dep = session.get(Department.class, idDep);

            employee.setDepartment(dep);
            session.save(employee);
            System.out.println("Done!");
        } else if (variant == 3){
            System.out.println("Введите id сотрудника, которого надо удалить");
            int idEmp = scanner.nextInt();
            Employee employee = session.get(Employee.class, idEmp);
            
            session.delete(employee);
            System.out.println("Done!");
        } else if (variant == 4) {
            List<Employee> emps = session.createQuery("from Employee").getResultList();
            List<Department> deps = session.createQuery("from Department").getResultList();
            for(Employee e: emps)
                System.out.println(e);
            System.out.println("*********************************************");
            for(Department d: deps)
                System.out.println(d);
        }
        session.getTransaction().commit();
        factory.close();
    }
}
