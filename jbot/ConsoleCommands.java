package jbot;

import jbot.BasicListen;

//import org.pircbotx.PircBotX;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;





public class ConsoleCommands {

	public static void main() throws IOException {
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println("IT DONE GOOFT on waiting.... somehow....");
			e.printStackTrace();
		}
		Console cons = System.console();

    if (cons == null) {
    System.err.println("THERE BE NONE OF THEM CONSOLES AVAILABLE FOR ME TO UUUSE!!!!!!.");
      System.exit(1);
   }

    
    
    
    
    System.out.println("***Commands may be entered via console***");
    while(true){


        System.out.print("Enter Command: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String enteredcommand = "noneyet";

   
        try {
        	enteredcommand = br.readLine();
        } catch (IOException ioe) {
           System.out.println("IT DONE GOOFT ON READING YO COMMAND!?!");
           System.exit(1);
        }

        System.out.println("Command received: " + enteredcommand);

        if(enteredcommand.equalsIgnoreCase("Disconnect")){
    		
        	
        	System.out.println("Told Me To Disconnect");
        	BasicListen.setDiscValue(true);
        	
    	}
    
    }
	
	}




}
	
	
	

