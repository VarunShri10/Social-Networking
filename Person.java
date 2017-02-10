package SocialNetWorking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Person extends Entity implements Serializable{
	String posts;
	ArrayList<String> frinedList =new ArrayList<String>();
	HashSet<String> mutualFrined=new HashSet<String>();
	HashSet<String> pendingRequest=new HashSet<String>();
	HashSet<String> blockList=new HashSet<String>();
	
	 public static void makeFile() {
		 try {
			 	Scanner scannerObject=new Scanner(System.in);
			 	BufferedReader br;
			 	br = new BufferedReader(new FileReader("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersFile.txt"));
			 	ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
			 	String line;
			 	String words[];
			 	Person personObject;
			 	int friendListLength;
			 	while((line=br.readLine())!=null){
			 		friendListLength=0;
			 		personObject=new Person();
			 		words=line.split(" ");
			 		friendListLength=words.length;
			 		personObject.name=words[0]+" "+words[1];
			 		personObject.id=words[2];
			 		personObject.Email_id=words[3];
			 		personObject.posts=words[4];
			 		
			 		//System.out.println(":Post ..Person."+words[4]);
			 		for(int j=5;j<friendListLength;j=j+2){
			 			personObject.frinedList.add(words[j]+" "+words[j+1]);
			 			//System.out.print("Added Friend : "+personObject.frinedList.get(j-5));
			 		}
			 		
			 		oos.writeObject(personObject);
				}
			 	oos.close();
			 	
		 }
		 catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		 catch (IOException e) {
			e.printStackTrace();
		}
		
	 }
		 public static void display(){
			 try {
				ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
				Person personObject=null;
				int count=1;
				while((personObject=(Person) ooi.readObject())!=null){
					count=1;
					System.out.println("Name : "+personObject.name);
					System.out.println("Unique Code "+personObject.id);
					System.out.println("Email : "+personObject.Email_id);
					System.out.println("Posts : "+personObject.posts);
					System.out.println("Friends : ");
					//System.out.println("Length : "+personObject.frinedList.size());
					/*for(String name:personObject.frinedList){
						System.out.println((count++)+": "+name);
					}
					*/
					if(personObject.frinedList.size()>=1)
					{
						for(int index=0;index<personObject.frinedList.size();index++)
							System.out.println((count++)+":"+personObject.frinedList.get(index));
					}
					else
					{
						System.out.println("No mutual Friend");
					}
					System.out.println("Mutual Friend : ");
					if(personObject.mutualFrined.size()>=1)
					{
						count=1;
						for(String m:personObject.mutualFrined)
							System.out.println((count++)+":"+m);
					}
					else
					{
						System.out.println("No mutual Friend ");
					}
				}
				
				ooi.close();
			} catch (Exception  e) {
			} 
			 
		 }
		 
		 public  HashSet<String> mutualFriendAdd(){
			 HashSet<String> mutualFriend=new HashSet<String>();
			 int findFriend=0;
			 int indirectFriend=0;
			 Person personObject;
			 try {
				 	ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
				 	while((personObject=(Person) ooi.readObject())!=null){
						if(personObject.name==this.name)
							continue;
						else
						{
							for(String name:personObject.frinedList){
								findFriend=0;
								for(String userFriend:this.frinedList){
									if(userFriend.compareToIgnoreCase(name)==0)
									{
										findFriend=1;
										break;
									}
									
								}
								indirectFriend=0;
								for(String FriendName:this.frinedList)
								{
									if(FriendName.compareToIgnoreCase(personObject.name)==0)
										{
											indirectFriend=1;
											break;
										}
									
										
								}
								if(findFriend==0&&(name.compareToIgnoreCase(this.name)!=0)&&(indirectFriend==1))
									mutualFriend.add(name);
							}
						}
				 	}
			 }  
			 catch (Exception e) {
				}
			 return mutualFriend;
			 
		 }
		
		
}
