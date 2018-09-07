package main;

import com.revature.beans.Power;
import com.revature.beans.Hero;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("root-context.xml");

        SessionFactory sf = (SessionFactory) ac.getBean("mySessionFactory");

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        try {
            int id = (int) s.save(new Hero("Timmy", "isCool","dynamic man", LocalDate.now()));
            Hero temp = (Hero) s.get(Hero.class, id);
            Set<Power> tempPower = new HashSet();
            tempPower.add(new Power( "Sarcasm",11404));
            temp.setPowers(tempPower);
            s.saveOrUpdate(temp);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }

        s.close();
        sf.close();
//        Session s = sf.openSession();
//        Trans
//
//        int id = (int) s.save(new Hero("Timmy", "isCool"));
//
//        System.out.println(id);
//
//        s.close();
//        sf.close();
    }
}
