import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.StringTokenizer;


//Class to connect to the Runners Text file
public class FinalTextData implements MarathonDAO
{
	private ArrayList<Runner> runners =null;
	private Path textFilePath=null;
	private File textFile=null;
	
public ArrayList<Runner> getRunnerInfo(String fileName) 	
//if the runner file has already been read, don't read it again
{
	if (runners != null)
		return runners; 	
	
	textFilePath = Paths.get(fileName);
    textFile = textFilePath.toFile();
    
    runners = new ArrayList<>();
	
    if (Files.exists(textFilePath))  // prevent the FileNotFoundException
	
	{
        try (BufferedReader in = 
                 new BufferedReader(
                 new FileReader(textFile)))
        {
            // read all runners stored in the file
            // into the array list
            String line = in.readLine();
            while(line != null)
            {
            	StringTokenizer t = new StringTokenizer(line, "\t");
				String name = t.nextToken();
				int speed = Integer.parseInt(t.nextToken());
				int restPercentage = Integer.parseInt(t.nextToken());
				
				Runner r = new Runner();
				r.setRunnerName(name);
				r.setRunnerSpeed(speed);
				r.setRestPercentage(restPercentage);
				
				// add runner to the ArrayList
				runners.add(r);
				
				line = in.readLine();
          }		
            
        }

            catch(IOException e)
            {
                System.out.println(e);
                return null;
            }
	}
	else
	{
		return null;
	}

	return runners;
}
   }
