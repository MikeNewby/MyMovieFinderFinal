package myMovieFinder;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Connect {

	   static final String databasePrefix ="project"; // TODO: need to change this depending on DB location
	   static final String netID ="root"; // Please enter your netId
	   static final String hostName ="localhost"; //washington.uww.edu
	   static final String databaseURL ="jdbc:mysql://"+hostName+"/"+databasePrefix+"?useSSL=false&serverTimezone=UTC";
	   static final String password="Qzc10667!"; // please enter your own password
	    
	   private static Connection connection = null;
       private static Statement statement = null;
       private static ResultSet resultSet = null;
       
	   public static Connection Connection(){
	  
	      try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("databaseURL: "+ databaseURL);
	            connection = DriverManager.getConnection(databaseURL, netID, password);
	            System.out.println("Successfully connected to the database");
	         }
	        catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		return connection;
	    } // end of Connection
	    
	   //run simple query
	    public static void runQuery(String sqlQuery) {
	    
	    	try {
	    		statement = connection.createStatement();
	    		resultSet = statement.executeQuery(sqlQuery);

	    		ResultSetMetaData metaData = resultSet.getMetaData();
	    		int columns = metaData.getColumnCount();

	    		for (int i=1; i<= columns; i++) {
	    			System.out.print(metaData.getColumnName(i)+"\t");
	    		}

	    		System.out.println();

	    		while (resultSet.next()) {
	       
	    			for (int i=1; i<= columns; i++) {
	    				System.out.print(resultSet.getObject(i)+"\t\t");
	    			}
	    			System.out.println();
	    		}
	    	}
	    	catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    	 
	    } 
	    //check user ID and p/w against users database.
	    public static int checkUser(String sqlQuery) {
	    
	    	try {
	    		statement = connection.createStatement();
	    		resultSet = statement.executeQuery(sqlQuery);
	    		
	    		int cnt=0;
	    		while(resultSet.next()) {
	    			cnt++;
	    		}
	    		
	    		if(cnt == 1) {
	    			resultSet.first();
	    			int uid = resultSet.getInt(1);
	    			if(uid > 0)
	    				return uid;
	    		}
	    		//All other cases are a failure, 
	    		return -1;
	    		
	    		
	    	}
	    	catch (SQLException e) {
	    		e.printStackTrace();
	    		return -1;
	    	}
	    	
	    	 
	    } 
	    
	
}
