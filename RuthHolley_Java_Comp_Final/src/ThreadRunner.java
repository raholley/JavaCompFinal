
public class ThreadRunner extends Thread {
//Class variables
	private String name;
	private double speed;
	private int restPercentage;
	private MarathonRaceApp mr;
	boolean firstThread;


	//Constructor to create the objects for the Threadrunner	
	
	ThreadRunner(String name, double speed, int restPercentage, MarathonRaceApp mr)
	{
		this.name = name;
		this.speed = speed;
		this.restPercentage = restPercentage;
		this.mr = mr;
	}
	
   //This method returns the name of the individual runners Thread
	public String getRunnerName(){
		return name;
	}
	@Override
	public void run()
	{
		int distance = 0;
		
		try
		{
			while (distance < 1000) // loops until the runner reaches the total race distance
			{
				int randomNumber = (int) (Math.random()*100);

				if (randomNumber <= restPercentage) 
				{
					Thread.sleep(200);
				}
				else
				{
						distance += speed; 
						System.out.println(name + " : " + distance);
				}
				Thread.sleep(100);
			} 	

			//returns 'true' for the first thread calling isFirst method, returns 'false' for all other threads.
			firstThread = mr.FirstPlace(); 
			
			if (firstThread == true) // only winner thread enters if block
			{
				System.out.println(name + " : I finished! \n");
				mr.Finished(name);
				mr.interruptThreads(name);
				return;
			}
			else //Threads who do not win can sleep meanwhile the winner of the race will be announced.
			{
				Thread.sleep(200); 
			}
		}
		catch (InterruptedException e) 
		{
			// Empty catch 
		}
		System.out.println(name + " : You beat me fair and square."); //The racers who did not win speak.
	}
	
}
