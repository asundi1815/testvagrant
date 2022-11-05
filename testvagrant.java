package com.sgtesting.testcases;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class testvagrant {
	
	public void validateTeamHasFourForeignPlayers() {
		
		  String path=System.getProperty("user.dir");
		  path=path+"\\DataFiles";
		  
		  JSONParser parser = new JSONParser();
	      try {
	         Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\eclipse-workspace\\API-validation\\Datafiles\\rcbPlayers.json"));
	         JSONObject jsonObject = (JSONObject)obj;
	         String name = (String)jsonObject.get("name");
	         String course = (String)jsonObject.get("location");
	         JSONArray players = (JSONArray)jsonObject.get("player");
	         int size=players.size();
	         int foreignPlayer=0;
	         
	         
	         //System.out.println("Name: " + name);
	         //System.out.println("Players: " + players);
	         //System.out.println("Players:");
	        // JSONObject rcbPlayers=(JSONObject)players;
	         Iterator<?> iterator = players.iterator();
	         while (iterator.hasNext()) {
	        	 JSONObject player=(JSONObject)iterator.next();
	     
	        	 String playerCountry=(String) player.get("country");
	        	  if (!playerCountry.equalsIgnoreCase("INDIA"))
	        		  foreignPlayer=foreignPlayer+1;
	        	  
	        	 
	         }
	         System.out.println("Count of the Foreignplayers  "+foreignPlayer+"  ");
	         
	         String fplayer=Integer.toString(foreignPlayer);
	        
	         
			Assert.assertEquals("4",fplayer, "Number of Foreign players expected only  four");
	        
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		  
		System.out.println(path);
		
	}
	
	public void validateNumberofWicketKeeper() {
		
		  String path=System.getProperty("user.dir");
		  path=path+"\\DataFiles";
		  
		  JSONParser parser = new JSONParser();
	      try {
	         Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\eclipse-workspace\\API-validation\\Datafiles\\rcbPlayers.json"));
	         JSONObject jsonObject = (JSONObject)obj;
	         String name = (String)jsonObject.get("name");
	         String course = (String)jsonObject.get("location");
	         JSONArray players = (JSONArray)jsonObject.get("player");
	         int size=players.size();
	        
	         int wicketkeeper=0;
	         
	         //System.out.println("Name: " + name);
	         //System.out.println("Players: " + players);
	         //System.out.println("Players:");
	        // JSONObject rcbPlayers=(JSONObject)players;
	         Iterator<?> iterator = players.iterator();
	         while (iterator.hasNext()) {
	        	 JSONObject player=(JSONObject)iterator.next();
	     
	     
	        	  String playerRole=(String)player.get("role");
	        	  if (playerRole.equalsIgnoreCase("Wicket-keeper"));
	        	  	wicketkeeper=+1;
	         }
	         
	         System.out.println("Count of the WicketKeeper    "+wicketkeeper+"   ");
	         
	         String wKeeper=Integer.toString(wicketkeeper);
	         
	         Assert.assertEquals("1", wKeeper,"Atleast One wicket Keeper present");
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		  
		System.out.println(path);
		
	}

}
