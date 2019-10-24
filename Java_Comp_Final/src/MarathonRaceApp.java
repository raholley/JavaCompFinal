//Ruth Holley--Java comprehensive class final

import java.util.ArrayList;
import java.util.Scanner;

public class MarathonRaceApp {
	
	//Class Variables
	private ArrayList<Runner> runners = null;
	private static MarathonDAO mDAO = null;
	ArrayList<Thread> threadList = null;
	boolean executed = false;

	//Main Method
	public static void main(String[] args) { 
		
	Scanner sc = new Scanner(System.in);
	String fileName = "";
	String dbName = "";
	MarathonRaceApp mr = new MarathonRaceApp();
	
	int choice = 0;
	while (choice != 5) //Loops through the 5 available options. The loops stops when the user selects exit.
	{
		mr.reset(); //reset executed boolean variable to false before starting a new race
		
	System.out.println("Welcome to the Marathon Race Runner Program. \n");
			
	//Menu of data source options available to the user	  
			System.out.println("Select your data source:");
			System.out.println("");
			System.out.println("1. Derby database");
			System.out.println("2. XML file");
			System.out.println("3. Text file");
			System.out.println("4. Default two runners");
			System.out.println("5. Exit");
			System.out.println("");
						
	//Get user input and make sure its valid
	   choice = Validator.getIntWithinRange(sc, "Enter your choice: ", 1, 5);
	   System.out.println();
						
	//Call DAOFactory to get object of the class which connects to the data source
	  mDAO = DAOFactory.getMarathonDAO(choice);				
	  
	  
	// Switch as per user choice and get name of the data source.
	switch (choice)
				{
				case 1: dbName = Validator.getRequiredString("Enter Database name: ", sc);
				mr.createThreads(dbName);
				break;
				
		case 2: fileName = Validator.getRequiredString("Enter XML file name: ", sc);
				mr.createThreads(fileName);
				break;
					
		case 3:	fileName = Validator.getRequiredString("Enter Text file name: ", sc);
				mr.createThreads(fileName);
				break;
				
		case 4: mr.createThreads("");
				break;
				
		case 5: System.out.println("Thank you.The program will close now"); 
				System.exit(0);
				
		default: break;
	    }
	}
}					
		public void reset()
		{
			executed = false; // Reset the boolean variable (executed) before simulating new race.
		}	  
		public void createThreads(String fileName)
		{
			// Get all the runner's information from the data source
			if (fileName.equals(""))
			{
				DefaultRunners defaultRunners = (DefaultRunners) mDAO;
				runners = defaultRunners.getRunnerInfo();
			}
			else
				runners = mDAO.getRunnerInfo(fileName);
			
			if (runners == null) // if null re-enter the data source name
			{
				System.err.println("Error! Unable to get runners. Please re-enter valid data source.\n");
			}
			else 
			{
				int totalRunners = runners.size();
				threadList = new ArrayList<>();
				ThreadRunner thread = null;
				
				System.out.println("Start Race...");
				
				// start thread for each runner
				for (int i = 0; i < totalRunners; i++)
				{
					String name = runners.get(i).getRunnerName();
					int speed = runners.get(i).getRunnerSpeed();
					int restPercentage = runners.get(i).getRestPercentage();
					
					// Create a thread for each Runner
					thread = new ThreadRunner(name, speed, restPercentage, this);
					thread.start(); 
					threadList.add(thread);
				}
		
				ThreadsWaiting(); //The main thread has to wait for other threads to complete
				
				System.out.println();
				
				Continue(); // Call the end of the program. Press any key to proceed
			}
		}
		
		//Return true once this method is called. Its available only to the Thread that completes first		
		public synchronized boolean FirstPlace()
		{
			if (executed == false)
			{
				executed = true; //The thread that completes first can set executed to true
				return true;
			}
			else
			{
				return false;
			}
		}
		
         //The finished method announces that the race is over and there is a winner.
		 
		public void Finished(String threadName)
		{
			System.out.println("The race is over! The " + threadName + " is the winner. \n");
		}
		
		//This method interrupts the other threads once a winner has been found			
		
		public void interruptThreads(String threadName)
		{
			for (int i = 0; i < threadList.size(); i++)
			{
				if (!threadName.equals(((ThreadRunner) threadList.get(i)).getRunnerName()))
				{
					threadList.get(i).interrupt(); // interrupts other threads when one runner(thread) completes the race.
				}
			}
		}
		
		
		//Main thread waits until all other threads have finished
		 
		private void ThreadsWaiting()
		{
			for (int i = 0; i < threadList.size(); i++)
			{
				try 
				{
					threadList.get(i).join();
					//System.out.println(((ThreadRunner) threadList.get(i)).getRunnerName()	 + " finished. ");
				}
				catch (InterruptedException e)	{}
			}
		}
		
	
		//Press enter key to continue
		private void Continue()
		 { 
		        System.out.println("Press enter to continue . . .");
		        try
		        {
		            System.in.read();
		        }  
		        catch(Exception e)
		        {}  
		 }
	
		}