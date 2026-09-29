package com.HybernateExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
       Employee emp= new Employee();
       emp.setEid(1);
       emp.setEname("John");
       emp.setAddress("Bangloree");
     
       Configuration cf=new Configuration().configure().addAnnotatedClass(Employee.class);
       ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(cf.getProperties()).buildServiceRegistry();
       SessionFactory sf=cf.buildSessionFactory(reg);
       Session s=sf.openSession();   
       Transaction t = s.beginTransaction();
       s.save(emp);
       t.commit();
    }
}
