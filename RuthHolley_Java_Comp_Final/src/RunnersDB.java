import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

//This class connects to the Derby Runners database and retrieves their information

public class RunnersDB implements MarathonDAO
{
	ArrayList<Runner> runners =null;
	
	private Connection getConnection(String dbName)
	    {
	        Connection connection = null;
	        try
	        {
	            String dbDirectory = "Resources";
	            System.setProperty("derby.system.home", dbDirectory);

	            String url = "jdbc:derby:RunnersDB";
	            String user = "";
	            String password = "";
	            connection = DriverManager.getConnection(url, user, password);
	            return connection;
	        }
	        catch(SQLException e)
	        {
	            System.err.println("Error loading database driver: " + e);
	        }
	        return null;
}
	        
public ArrayList<Runner> getRunnerInfo(String dbName)
{
	
	try
	{
		Connection connection = getConnection(dbName);
		runners = new ArrayList<>();
		
		// query the runners table
		String query = "SELECT * FROM runnersstats";
	
	
	PreparedStatement ps = connection.prepareStatement(query);
	ResultSet rs = ps.executeQuery();
	
	while (rs.next())
	{
		String runnerName = rs.getString("RunnersName");
		int runnerSpeed = rs.getInt("RunnersSpeed");
		int restPercentage = rs.getInt("RestPercentage");
		
		Runner r = new Runner();
		r.setRunnerName(runnerName);
		r.setRunnerSpeed(runnerSpeed);
		r.setRestPercentage(restPercentage);
		
		runners.add(r);
	}
	rs.close();
	ps.close();
	connection.close();
	
}
catch (Exception e)
{
	return null;
}
return runners;
	}


 }

	        
	        
	      
