package jbot;

import org.pircbotx.PircBotX;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import jbot.Epic_Jbot;

public class TextRead {
	
	public static String itemname = "None Yet";
	public static String filename = "None Yet";
	public static String result = "No Content Found";
	private static PircBotX bot = Epic_Jbot.mecha_jdog;
	
	public static String ReadFile(String fileee, String item){
		
		TextRead.filename = fileee.toLowerCase();
		TextRead.itemname = item;
		System.out.println(itemname);
		URL url = TextRead.class.getResource(filename);
		
		
		
		if (url == null){
			result = "File not found";
			return result;
		}
		
		
		
		
		File file = new File(url.getPath());
		if ((TextRead.filename.equals("None Yet")) || (TextRead.itemname.equals("None Yet"))){
			result = "Usage: !jbot read filename itemname";	
			return result;
		}
		
		if (!TextRead.filename.equals("None Yet")){
			
			try {
		       
			
			
			FileReader reader = new FileReader(file);
		       char[] chars = new char[(int) file.length()];
		       reader.read(chars);
		       String fullfile = new String(chars);
		      
		       String[] lines = fullfile.split("[//]");
		       
		       
		       reader.close();
		      
		       /* if(itemname == "-all"){              // For loop for pasting entire file, working on dis - it doesnt like checking my itemname
		    	   System.out.println("SO YOU WANT THEM ALL");
		    	   bot.sendMessage("#epic_jdog", "SO YOU WANT THEM ALL");
		    	   for (int j = 0; j < lines.length; j++ ){
			       bot.sendMessage("#epic_jdog", lines[j- 1]);
			       System.out.println(j);
		       }
		       }
		        else {      */
		    	   result = lines[6]; //does certain line - 1 is first, 6 is 2nd, 10 is 3rd, 14  is 4th etc
		     //  }
			} catch (IOException e) {
		       System.out.println("THAT FILE DIDNT WORK, AT ALL, MATE!");
			   e.printStackTrace();
		   }
		
		}
		
		   
		
		
		return result;
	}
		   public static String WriteFile(String fileee, String item){
				
				   return "File written.";
	
	}

		
		   public void TestTalk2(){


			   System.out.println("Test 2");
			   bot.sendMessage("#epic_jdog", "test");
			   
		   }




}