package com.asig;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.entity.Dependant;
import com.entity.Employee;
import com.entity.Manager;

public class CreateEmployee {

	public static void print1(Session session, String query) {
		SQLQuery qry = session.createSQLQuery(query);

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o[] = (Object[]) it.next();

			for (Object item : o) {
				System.out.print(item + "   |   ");
			}
			System.out.println();

		}
	}

	public static void update(Session session, String s) {
		String[] words = s.split("\\s");
		String query1 = "update " + words[0] +" set "+ words[1] + "=" + words[2] + " where " + words[3] + "= " + words[4];
		int i = words.length;
		int j = 5;
		while (j < i) {

			query1 = query1 + "and" + words[j] + "=" + words[j + 1];
			j = j + 2;
		}
		SQLQuery qry1 = session.createSQLQuery(query1);
		qry1.executeUpdate();

	}

	public static void delete(Session session, Class<?> type, Serializable id) {
		Object persistentInstance = session.load(type, id);
		if (persistentInstance != null) {
			session.delete(persistentInstance);
			return;
		}
		return;
	}

	public static void main(String[] args) {
		// session factory

		try {

			SessionFactory factory = new AnnotationConfiguration().addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Dependant.class).addAnnotatedClass(Manager.class).configure()
					.buildSessionFactory();

			// session creation
			Session session = factory.openSession();
			Transaction trans = session.beginTransaction();
			// start transaction

			Scanner sc = new Scanner(System.in);
			System.out.println("Use the following to perfrm query operations");
			System.out.println("\n 1.select query\n 2.insert\n3.update\n4.delete");
			int _input = sc.nextInt();

			String s = sc.nextLine();

			String query = sc.nextLine();
			String[] words = query.split("\\s");

			switch (_input) {

			case 1:
				print1(session, query);
				break;
			case 2:

				Employee tempemp = new Employee();
				tempemp.setEmail(words[3]);
				tempemp.setId(Integer.parseInt(words[0]));
				tempemp.setFirstname(words[1]);
				tempemp.setLastname(words[2]);

				Dependant depnd = new Dependant();
				depnd.setId(Integer.parseInt(words[0]));
				depnd.setGender(words[5]);
				depnd.setRelation(words[4]);

				Manager manage = new Manager();
				manage.setMid(Integer.parseInt(words[6]));
				manage.setDept(words[7]);
				depnd.setEmp(tempemp);
				manage.setEmp(tempemp);

				session.save(tempemp);
				session.save(depnd);
				session.save(manage);
				break;
			case 3:
				update(session, query);
				break;
			case 4:
				if (words[0].equals("employee")) {
					Employee tempemp1 = new Employee();
					tempemp1.setId(Integer.parseInt(words[1]));
					session.delete(tempemp1);
					//session.getTransaction().commit();
				} else if (words[0].equals("dependant")) {
					System.out.println("hello");
					Dependant dep = new Dependant();
					dep.setId(Integer.parseInt(words[1]));
					session.delete(dep);
				} else if (words[0].equals("manager")) {
					Manager manag = new Manager();
					manag.setMid(Integer.parseInt(words[1]));
					session.delete(manag);
				}

				break;
			default:
				System.out.println("invalid choice");

			}
			// comit transac
			trans.commit();

			System.out.println("Done!");
			session.close();
			factory.close();
		}

		catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
