package main;

import domain.Address;
import domain.Employee;
import domain.Employee1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class HibernateSaveExample {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        //save example - without transaction
        Session session = sessionFactory.openSession();
        Employee1 employee = getTestemployee();
        Integer id = (Integer) session.save(employee);
        System.out.println("1. Employee save called without transaction, id="+id);
        session.flush();//address will not get saved without this
        System.out.println("******");

        //save example - with transaction
        Transaction tx1 = session.beginTransaction();
        Session session1 = sessionFactory.openSession();
        Employee1 employee1 = getTestemployee();
        Integer id1 = (Integer) session1.save(employee1);

        System.out.println("2. Employee save called with transaction, id="+id1);
        System.out.println("3. Before committing save transaction");
        tx1.commit();
        System.out.println("4. After committing save transaction");
        System.out.println("*****");

        //save example - existing row in table
        Session session2 = sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();
        Employee1 employee2 = (Employee1) session2.load(Employee1.class, new Integer(10));

        //update some data
        System.out.println("Employee Details="+employee2);
        employee2.setName("New name");
        employee2.getAddress().setCity("New city");

        Integer id2 = (Integer) session2.save(employee2);
        employee2.setName("New name1");
        System.out.println("5. Employee save called with transaction, id="+id2);
        System.out.println("6. Before committing save transaction");
        tx2.commit();
        System.out.println("7. After committing save transaction");
        System.out.println("*****");

        sessionFactory.close();

    }


    public static Employee1 getTestemployee(){
        Employee1 emp = new Employee1();
        Address add = new Address();
        emp.setName("Test emp");
        add.setAddressLine1("Test address1");
        add.setCity("test city");
        add.setZipcode("12121");
        emp.setAddress(add);
        add.setEmployee(emp);
        return emp;
    }
}
