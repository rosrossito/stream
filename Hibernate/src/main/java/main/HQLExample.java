package main;

import domain.Employee;
import domain.Employee1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Arrays;
import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Employee1");
        List<Employee1> employee1List = query.list();
        employee1List.stream()
                .forEach(emp -> System.out.println("List of Employees: " + emp.getId() + "," + emp.getAddress().getCity()));


        query = session.createQuery("from Employee1 where id=:id");
        query.setInteger("id", 3);
        Employee1 employee1 = (Employee1) query.uniqueResult();
        System.out.println("Employee Name=" + employee1.getName() + ", City=" + employee1.getAddress().getCity());

        //HQL pagination example
        query = session.createQuery("from Employee1");
        query.setFirstResult(0); // start with 0
        query.setFetchSize(1);
        List<Employee1> empList = query.list();
        empList.stream()
                .forEach(emp -> System.out.println("Paginated Employees: " + emp.getId() + "," + emp.getAddress().getCity()));

        //HQL Update Employee
        query = session.createQuery("update Employee1 set name =:name where id =:id");
        query.setParameter("name", "Pankaj Kumar");
        query.setInteger("id", 1);
        int result = query.executeUpdate();
        System.out.println("Employee Update Status=" + result);

        //HQL Delete Employee, we need to take care of foreign key constraints too
        query = session.createQuery("delete from Address where id =:id");
        query.setInteger("id", 4);
        result = query.executeUpdate();
        System.out.println("Address Delete Status="+result);

        query = session.createQuery("delete from Employee1 where id=:id");
        query.setInteger("id", 4);
        result = query.executeUpdate();
        System.out.println("Employee1 Delete Status="+result);

        //HQL join examples
        query = session.createQuery("select e.name, a.city from Employee1 e INNER JOIN e.address a");
        List<Object[]> list = query.list();
        list.stream()
                .forEach(obj -> System.out.println(Arrays.toString(obj)));

        //rolling back to save the test data
        tx.rollback();

        //closing hibernate resources
        sessionFactory.close();
    }
}
