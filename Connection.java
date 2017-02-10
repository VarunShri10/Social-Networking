package SocialNetWorking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Connection {
	Object obj;
	Boolean request;
	public static void showMutualFriend()
	{
		ArrayList<Person> personArrayList=new ArrayList<Person>();
		Person personObject;
		try {
		 	ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
		 		while((personObject=(Person) ooi.readObject())!=null){
		 			personObject.mutualFrined=personObject.mutualFriendAdd();
		 			personArrayList.add(personObject);
				//if(personObject.)
		 	}
		}  
		catch (Exception e) {
		}
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
			for(Person p:personArrayList)
				oos.writeObject(p);
		}
			catch (Exception e) {
			}
		
	}
	
	public static String  sendFriendName(String name){
		Person personObject;
		try {
		 	ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
		 		while((personObject=(Person) ooi.readObject())!=null){
		 			if(personObject.name.compareToIgnoreCase(name)==0)
		 					return personObject.name;
		 			}
		}  
		catch (Exception e) {
		}
		return "";
	}
	
		public static void  addFriendRequest(String friendName,String personName){
			ArrayList<Person> personArrayList=new ArrayList<Person>();
			Person personObject;
			try {
			 	ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
			 		while((personObject=(Person) ooi.readObject())!=null){
			 			if(personObject.name.compareToIgnoreCase(friendName)==0)
			 					personObject.pendingRequest.add(personName);
			 			personArrayList.add(personObject);
			 	}
			}  
			catch (Exception e) {
			}
			try {
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
				for(Person p:personArrayList)
					oos.writeObject(p);
			}
				catch (Exception e) {
				}
		}
		
		public static void friendAccept(String name,int booleanAccept,Person PersonObject){
			 
			ArrayList<Person> personArrayList=new ArrayList<Person>();
			Person personTempObject;
			String acceptedName="";
			try {
			 	ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
			 		while((personTempObject=(Person) ooi.readObject())!=null){
			 			if(personTempObject.name.compareToIgnoreCase(PersonObject.name)==0){
			 					if(booleanAccept==0)
			 					{
			 							personTempObject.pendingRequest.remove(name);
			 							System.out.println("You Rejected "+name);
			 					}
			 					else
			 					{
			 							
			 							acceptedName=Connection.sendFriendName(name);
			 							if(acceptedName.compareToIgnoreCase("")!=0)
			 							{
			 								personTempObject.pendingRequest.remove(acceptedName);
			 								personTempObject.frinedList.add(acceptedName);
			 								personTempObject.mutualFrined.remove(acceptedName);
			 							}
			 							else
			 							{
			 								personTempObject.pendingRequest.remove(name);
			 								personTempObject.frinedList.add(name);
			 								personTempObject.mutualFrined.remove(name);
			 							
			 							}
			 							System.out.println(name+" Added in your friend list");
			 					}
			 			}
			 			else
			 				if(personTempObject.name.compareToIgnoreCase(name)==0){
			 					if(booleanAccept==1){
			 							personTempObject.frinedList.add(PersonObject.name);
			 							personTempObject.mutualFrined.remove(PersonObject.name);
			 					}
			 				}
			 			personArrayList.add(personTempObject);
			 		}
			}
			catch (Exception e) {
			}
			try {
					ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
					for(Person p:personArrayList)
						oos.writeObject(p);
				}
				catch (Exception e) {
				}
		}
		
		
}
