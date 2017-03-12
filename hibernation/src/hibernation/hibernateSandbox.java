package hibernation;
import java.io.Console;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;

public class hibernateSandbox {
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		
		//Creates a unique object called song that is mapped to hibernate
		song_List song = new song_List();
		song.setTitle("Whats This?");
		song.setArtist("The Nightmare Before Christmas");
		song.setId(1004);
	
		
		//sets up the factory, session. 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//runs custom query to see if the data in the table exists. 
		Query data = session.createQuery("select count(*) from song_List where id="+song.getId()+"");
		
		System.out.println("\n");
		
		if((Long)data.uniqueResult()!=1){
			System.out.println("Saving Input\n");
			//Saves Sessions
			session.save(song);
		}
		else
		{
			//deletes an entry matching the object.
			session.delete(song);
			System.out.println("UNIQUE ID already exists. Entry Deleted\n");
		}
		
		//selects entire table
		data = session.createQuery("from song_List");
		//puts table into list of songs
		List<song_List> list = data.list();
		System.out.println("Song List: ");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).getTitle()+" : "+list.get(i).getArtist());
		}
		System.out.println("\n");
		
		//commits the transaciton
		session.getTransaction().commit();
		//closes the session
		session.close();
		//closes the factory
		sessionFactory.close();
	}
}
