import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.xml.stream.*;  // StAX API
import java.util.ArrayList;

//This class connects to the FinalXMLData file and gets all of the runners information
public class FinalXMLData implements MarathonDAO {
	
	private Path xmlFilePath = null;
	private File xmlFile =null;
	private ArrayList<Runner> runners =null;
	
	
	@Override
	public ArrayList<Runner> getRunnerInfo(String fileName)
	{
		// Check if file has been read already, do not read it again.
		if(runners != null)
			return runners;
		

		xmlFilePath= Paths.get(fileName);
		xmlFile = xmlFilePath.toFile();
	
		Runner r = null;
		runners = new ArrayList<>();
		
		// Check if file exist and prevent the FileNotFoundException
		if(Files.exists(xmlFilePath))
		{
			// Create XMLInputFactory object
			XMLInputFactory inputFactory = XMLInputFactory.newFactory();
			try
			{
				// Create XMLStreamReader object
				FileReader fileReader =	new FileReader(xmlFile);
				XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
				
				// Read products from the XML file
				while (reader.hasNext())
				{
					int eventType = reader.getEventType();
					switch (eventType)
					{
						case XMLStreamConstants.START_ELEMENT: // set the state (i.e. name, speed and rest percentage) of each Runner.
							String elementName = reader.getLocalName();
							if (elementName.equals("Runner")) // sets runner name
							{
								r = new Runner();
								String name = reader.getAttributeValue(0);
								r.setRunnerName(name);
							}
							if (elementName.equals("RunnersMoveIncrement")) // sets runner speed
							{
								int speed = Integer.parseInt(reader.getElementText());
								r.setRunnerSpeed(speed);
							}
							if (elementName.equals("RestPercentage")) // sets rest percentage 
							{
								int restPercentage = Integer.parseInt(reader.getElementText());
								r.setRestPercentage(restPercentage);
							}
							break;
							
						case XMLStreamConstants.END_ELEMENT:
							
							elementName = reader.getLocalName();
							if (elementName.equals("Runner"))
							{
								runners.add(r); // add each runner object to the ArrayList
							}
							break;
							
						default:
							break;
					}
					reader.next(); // reads next value (runner) from the XML file
				}
			}
			catch (Exception e)
			{
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
