package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Student;

public class daoimplementaion  implements daointerface{

	public String Insert(String name,String dept)
	{
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				try
				{
					//System.out.println("okay");
					
					Session session=sf.openSession();
					Transaction tx=session.beginTransaction();
					Student t=new Student();
					t.setEmp_name(name);
					t.setEmp_dept(dept);
					session.save(t);
					//session.update(s1);
					//System.out.println("okay123");
					tx.commit();
					session.close();
					sf.close();
					return "true";
				}
				catch(HibernateException e)
				{
					e.printStackTrace();
				}
				return "false";
	}
	public String Delete(int id) {
        Transaction trns = null;
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Student st = (Student) session.load(Student.class, new Integer(id));
            session.delete(st);
            session.getTransaction().commit();
            return "true";
        } 
        catch (RuntimeException e)
        {
        	e.printStackTrace();
        } 
        return "false";
    }
	
public String Update(Student s) {
        Transaction trns = null;
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(s);
            session.getTransaction().commit();
            return "true";
        } catch (HibernateException e) {
           /* if (trns != null) {
                trns.rollback();
            }*/
            e.printStackTrace();
        } /*finally {
            session.flush();
            session.close();
        }*/
        return "false";
    } 
	public String RetrieveDetails(int id)
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try 
        {
        	Session session=sf.openSession();
        	Student st=(Student)session.get(Student.class,id);
        	System.out.println("user name read from db is = "+st.getEmp_name());
        	return "true";
        }
        catch(HibernateException e)
        {
        	e.printStackTrace();
        }
        return "false";
		
	}
	public List<Student> getAll() {
        List<Student> s1 = new ArrayList<Student>();
        Transaction trns = null;
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            s1= session.createQuery("from Student").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return s1;
    }
}
