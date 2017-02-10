package SocialNetWorking;

import java.awt.Choice;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SocialNetwork {
	

		public static void main(String[] args) {
			//For the first run in a system run File Initialization Class First.
			
			String choice="";
		do
			{
				int home_choice;
				BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
				try{
					System.out.println("                      Social Network\n 1 : Sign Up \n 2 : Sig In");
					System.out.println("Enter Choice : ");
					home_choice=Integer.parseInt(br.readLine());
					if(home_choice==1)
						SignUp.newUserCreateFunction();
					else
					{
						Person personObject=Login.loginAccessFunction();
						//Connection.showMutualFriend();
						//Person.display();
						if(personObject!=null)
						{
							System.out.println("1:Show Pending Request \n 2: Send Friend Request \n 3 : Block Friend ");
							int userChoice;
							String friendName="";
							userChoice=Integer.parseInt(br.readLine());
							if(userChoice==2){
								System.out.println("Friend Request : ");
								System.out.println("Enter Friend Name : ");
								friendName=br.readLine();
								if(BlockUser.checkBlockedFriend(friendName, personObject)==false)
								Connection.addFriendRequest(friendName,personObject.name);
								else
									System.out.println("You can not send Request to this user . You have been Blocked by him");
							}
							else 
								if(userChoice==3)
								{
									System.out.println("Enter Friend Name : ");
									friendName=br.readLine();
									BlockUser.blockFunction(friendName,personObject);
									System.out.println(friendName+" Blocked ");
								}
							else
							{
								System.out.println("Pending Request : ");
								int count=1;
								int booleanFlag;
								if(personObject.pendingRequest.size()>=1){
									for(String name:personObject.pendingRequest)
									{
										System.out.println((count++)+" : "+name);
									}
									System.out.println("Enter Friend Name");
									friendName=br.readLine();
									System.out.println("Enter 1 : Accept 0 : Reject");
									booleanFlag=Integer.parseInt(br.readLine());
									Connection.friendAccept(friendName,booleanFlag,personObject);
								}
								else
								{
									System.out.println("No Request Pending ");
								}
							}
						}
						
					}
					System.out.println("Enter Y/y to continue ");
					choice=br.readLine();
				}
					catch(Exception o)
					{
						o.printStackTrace();
					}
				
			}while(choice.compareToIgnoreCase("y")==0);
		}
	}
		
