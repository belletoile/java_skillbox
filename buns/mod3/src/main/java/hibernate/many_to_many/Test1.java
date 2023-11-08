package hibernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите, что нужно сделать с БД: 1. Добавить секцию 2. Добавить ребенка " +
                "3.Удалить запись секции 4.Удалить запись ребенка 5.Показать все записи");
        int variant = scanner.nextInt();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        if (variant == 1){
            Scanner scanner_sec = new Scanner(System.in);
            System.out.println("Введите данные о секции");
            Section section = new Section();
            System.out.println("Введите название секции");
            section.setName(scanner_sec.nextLine());

            session.save(section);
            System.out.println("Done!");
        } else if (variant == 2) {
            Scanner scanner_child = new Scanner(System.in);
            System.out.println("Введите данные о ребенке");
            Child child = new Child();
            System.out.println("Введите имя ребенка");
            child.setFirstName(scanner_child.nextLine());
            System.out.println("Введите возраст ребенка");
            child.setAge(scanner_child.nextInt());

            System.out.println("Введите id секции, где занимается ребенок");
            int idSec = scanner_child.nextInt();
            Section section = session.get(Section.class, idSec);

            child.addSectionToChild(section);
            session.save(child);
            System.out.println("Done!");
        } else if (variant == 3) {
            System.out.println("Введите id секции, которую хотите удалить");
            int idSec = scanner.nextInt();
            Section section = session.get(Section.class, idSec);

            session.delete(section);
            System.out.println("Done!");
        } else if (variant == 4) {
            System.out.println("Введите id ребенка, которого хотите удалить");
            int idChild = scanner.nextInt();
            Child child = session.get(Child.class, idChild);

            session.delete(child);
            System.out.println("Done!");
        } else if (variant == 5) {
            List<Child> children = session.createQuery("from Child").getResultList();
            List<Section> section = session.createQuery("from Section").getResultList();
            for(Child e: children)
                System.out.println(e);
            System.out.println("*********************************************");
            for(Section d: section)
                System.out.println(d);
        }
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
