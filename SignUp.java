package SocialNetWorking;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;


public class SignUp {
	
	public static void newUserCreateFunction(){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Enter User Name : ");
			String userName=br.readLine();
			System.out.println("Enter Password : ");
			String password=br.readLine();
			System.out.println("Enter Email : ");
			String emailId=br.readLine();
			Person personObject=new Person();
			personObject.name=userName;
			personObject.id=password;
			personObject.Email_id=emailId;
			personObject.posts="0";
			 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser", true)) {
		            protected void writeStreamHeader() throws IOException {
		                reset();
		            }
		        };
		        oos.writeObject(personObject);
			}
			catch (Exception e) {
			}
			
		} 
	
}
