import java.util.ArrayList;

public class DefaultRunners implements MarathonDAO {
	
	ArrayList<Runner> runners = new ArrayList<>();
	
	@Override
		public ArrayList<Runner> getRunnerInfo(String fileName)
		{		
				return null;
		}
		
	
	public ArrayList<Runner> getRunnerInfo()
	{		
	
	//Set Default runners details and add them as objects to the ArrayList
		
	Runner r1 = new Runner();
		r1.setRunnerName("Tortoise");
		r1.setRunnerSpeed(10);
		r1.setRestPercentage(0);
		
		runners.add(r1);
		
		Runner r2 = new Runner();
		r2.setRunnerName("Hare");
		r2.setRunnerSpeed(100);
		r2.setRestPercentage(90);
		
		runners.add(r2);
		
		return runners;		
	}
	
		
}
