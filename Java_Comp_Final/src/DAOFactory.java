
public class DAOFactory
{
	// this method maps the MarathonDAO interface
    // to the appropriate data storage mechanism selected by the user
	
	public static MarathonDAO getMarathonDAO(int choice)
	{
		MarathonDAO mDAO =null;
		if (choice ==1) 
		{
	      mDAO = new RunnersDB();
		}
	      else if (choice ==2) 
	    {
	     mDAO = new FinalXMLData();
	    }
	     else if (choice==3) 
	    {
	        mDAO = new FinalTextData();
	    }	
	     else if (choice==4)
	    {
	    	 mDAO = new DefaultRunners();//This object will contain 2 default runners
		}
    return mDAO;
    }	

}
