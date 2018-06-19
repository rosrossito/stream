package main;

import domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.math.BigInteger;

public class HibernateGetvsLoad {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = (Employee) session.get(Employee.class, new Integer("2"));
        System.out.println("Employee get called");
        System.out.println("Employee ID= "+emp.getId());
        System.out.println("Employee Get Details:: "+emp+"\n");

        Employee emp1 = (Employee) session.load(Employee.class, new Integer("2"));
        System.out.println("Employee load called");
        System.out.println("Employee ID= " + emp1.getId());
        System.out.println("Employee load Details:: " + emp1 + "\n");

        //Get Example
        try{
            Employee emp2 = (Employee) session.get(Employee.class, new Integer(200));
            System.out.println("Employee get called");
            if(emp2 != null){
                System.out.println("Employee GET ID= "+emp2.getId());
                System.out.println("Employee Get Details:: "+emp2+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        //load Example
        try{
            Employee emp3 = (Employee) session.load(Employee.class, new Integer(100));
            System.out.println("Employee load called");
            System.out.println("Employee LOAD ID= "+emp3.getId());
            System.out.println("Employee load Details:: "+emp3+"\n");
        }catch(Exception e){
            e.printStackTrace();
        }

        tx.commit();
        sessionFactory.close();



    }
}
