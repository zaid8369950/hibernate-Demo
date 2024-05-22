package com.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.transferObject.Player;
import com.transferObject.Team;



public class HibernateMain {
	
	public static void main(String[] args) {
		try {
//			System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory"); Bhai Error kai Liye hai
		Configuration configuration = new Configuration().configure();
//	    configure if problem is there	"hibernate.cfg.xml"
		configuration.addAnnotatedClass(com.transferObject.Player.class);
		configuration.addAnnotatedClass(com.transferObject.Team.class);
		StandardServiceRegistryBuilder builder = 
				       new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Team t1 = new Team("India");
		Team t2 = new Team("RCB");
		Team t3 = new Team("Delhi");
		
		Player p = new Player();
		p.setAge(28);
		p.setPlayerName("Ram");
		p.getTeamList().add(t1);
		p.getTeamList().add(t2);
		p.getTeamList().add(t3);
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(p);
		
//		onetoone
//		Team t1= new Team("India");
//		Player p1 = new Player("Dhoni", t1, 28);
//		session.save(t1);
//		session.save(p1);
//		Player p1 = new Player(10,"zaid","USA",26);
//		Player p2 = new Player(20,"munna","UAE",22);
//		session.save(p1);
//		session.save(p2);
		
//		Player p = session.get(Player.class, 10);
//		System.out.println("The Details : " +p);
//		p.setPlayerName("Muzzu");
//		p.setAge(29);
//		session.delete(p);
		
//		Query query = session.createQuery("from Player where teamName=:name");
//		("from Player where playerName=:name");
//		("from Player where age between =:age1 and age2 order by playerName");  HQL 
//		query.setString("name", "Shagid");
//		query.setInteger("age1", 35); 
//		query.setInteger("age2", 40); 
//		List<Player> playerList = query.list();
//		System.out.println("Player Details");
//		for(Player p:playerList) {
//			System.out.println(p);
//		}
		
		transaction.commit();
		session.close();
	}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
