package SocialNetWorking;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Login {

	public static Person loginAccessFunction() {
		// TODO Auto-generated method stub
			String userEmail="";
			String userPassword="";
			Scanner scannerObject=new Scanner(System.in);
			System.out.println("Enter Email : ");
			userEmail=scannerObject.next();
			System.out.println("Enter Password : ");
			userPassword=scannerObject.next();
			Person personObject=null;
			int loginFlag=0;
			 try {
					ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
					int count=1;
					
					while((personObject=(Person) ooi.readObject())!=null){
						count=1;
							if(personObject.Email_id.equalsIgnoreCase(userEmail)&&personObject.id.equals(userPassword)){
								System.out.println("Name : "+personObject.name);
								System.out.println("Email : "+personObject.Email_id);
								System.out.println("Posts : "+personObject.posts);
								System.out.println("Friends : ");
								if(personObject.frinedList.size()>=1)
								{
									for(String name:personObject.frinedList){
										System.out.println((count++)+": "+name);
									}
								}
								else
								System.out.println("No Friend ");		
								System.out.println("Mutual Friend : ");
								if((personObject.mutualFrined.size()>=1))
								{
									count=1;
									for(String m:personObject.mutualFrined)
										System.out.println((count++)+":"+m);
								}
								else
									System.out.println("No Mutual Friend");	
									loginFlag=1;
								break;
							}
							
						}
					ooi.close();
					}
					
				 catch (Exception  e) {
				} 
			 if(loginFlag==0){
				 System.out.println("Invalid Credentialss");
				 return null;
			 }
			 else
				 return personObject;
				
	}
}
