package SocialNetWorking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BlockUser {
	
	public static void blockFunction(String friendName,Person personObjectParameter){
		ArrayList<Person> personArrayList=new ArrayList<Person>();
		String actualName="";
		Person personObject;
		try {
		 	ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
		 		while((personObject=(Person) ooi.readObject())!=null){
		 			if(personObject.name.compareToIgnoreCase(personObjectParameter.name)==0)
		 			{
		 				actualName=Connection.sendFriendName(friendName);
		 				if(actualName.compareToIgnoreCase("")!=0)
							{
		 						personObject.blockList.add(actualName);
		 						personObject.frinedList.remove(actualName);
		 						personObject.mutualFrined.remove(actualName);
							}
							else
							{
								personObject.blockList.add(friendName);
		 						personObject.frinedList.remove(friendName);
		 						personObject.mutualFrined.remove(friendName);
							
							}
		 				
		 			}
		 			else
		 				if(personObject.name.compareToIgnoreCase(friendName)==0)
		 				{
		 					personObject.frinedList.remove(personObjectParameter.name);
	 						personObject.mutualFrined.remove(personObjectParameter.name);
		 				}
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
	
	public static boolean checkBlockedFriend(String friendName,Person personObjectParameter)
	{
		Person personObject;
		int returnFlag=0;
		String actualName="";
		actualName=Connection.sendFriendName(friendName);
		try {
		 	ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\SocialNetWorking\\UsersObjectFile.ser"));
		 		while((personObject=(Person) ooi.readObject())!=null){
		 			if(personObject.name.compareToIgnoreCase(actualName)==0)
		 			{
		 				if(personObject.blockList.contains(personObjectParameter.name))
		 					{
		 							returnFlag=1;
		 							break;
		 						}
					}
						
		 			
		 	}
		}  
		catch (Exception e) {
		}
		if(returnFlag==1)
		return true;
		else
			return false;
		
	}
}
