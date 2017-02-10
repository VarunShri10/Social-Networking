package SocialNetWorking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Organization extends Entity{
	String likes;
	
	 public static void display() {
		 try {
			 	BufferedReader br;
			 	br = new BufferedReader(new FileReader("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\OrganizationFile.txt"));
			 	String line;
			 	String words[];
			 	while((line=br.readLine())!=null){
			 		words=line.split(" ");
			 		System.out.println("Name : "+words[0]);
			 		System.out.println("Unique Code "+words[1]);
			 		System.out.println("Email : "+words[2]);
			 		System.out.println("Like : "+words[3]);
			 		System.out.println();
				}
		 }
		 catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		 catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
}
