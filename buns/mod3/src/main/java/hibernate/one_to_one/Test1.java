package hibernate.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите, что нужно сделать с БД: 1. Добавить запись 2.Удалить запись 3.Показать все записи");
        int variant = scanner.nextInt();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        if (variant == 1) {
            Scanner scanner_employee = new Scanner(System.in);
            System.out.println("Введите данные сотрудника");
            Employee employee = new Employee();
            System.out.println("Введите имя сотрудника");
            employee.setName(scanner_employee.nextLine());
            System.out.println("Введите фамилию сотрудника");
            employee.setSurname(scanner_employee.nextLine());
            System.out.println("Введите отделение сотрудника");
            employee.setDepartment(scanner_employee.nextLine());
            System.out.println("Введите зарплату сотрудника");
            employee.setSalary(scanner_employee.nextInt());

            Detail detail = new Detail();
            System.out.println("Введите детали сотрудника");
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Введите город сотрудника");
            detail.setCity(scanner2.nextLine());
            System.out.println("Введите номер телефона сотрудника");
            detail.setPhoneNumber(scanner2.nextLine());
            System.out.println("Введите email сотрудника");
            detail.setEmail(scanner2.nextLine());

            employee.setEmpDetail(detail);

            session.save(employee);

            System.out.println("Done!");
        } else if (variant == 2) {
            System.out.println("Введите id сотрудника, которого надо удалить");
            int id = scanner.nextInt();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            System.out.println("Done!");
        } else if (variant == 3){
            List<Employee> emps = session.createQuery("from Employee").getResultList();
            for(Employee e: emps)
                System.out.println(e);
        }
        session.getTransaction().commit();
        factory.close();
    }
}
