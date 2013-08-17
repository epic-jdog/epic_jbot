package jbot;

import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ActionEvent;
import org.pircbotx.hooks.events.MessageEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
public class BasicListen extends ListenerAdapter implements Listener {

	
   
	//@Override
	//public void onJoin(JoinEvent event) {
		//if (event.getUser().getNick().toString() != "epic_jbot"){
		// event.getBot().sendMessage(event.getChannel(), "Welcome, " +  event.getUser().getNick().toString());

	
		//}
	
	//}
	
	
	
	
	@Override
	public void onMessage(MessageEvent event) throws Exception {
		if (event.getMessage().startsWith("vlee"))
			 event.getBot().sendMessage("#p_slice", "Aww.");
		
		if (event.getMessage().contains("spam"))
		 event.getBot().sendMessage("#p_slice", "Spam, spam, spam, spam, SPASPAAM!");
		
		
		//if (event.getMessage().startsWith("!jbot join"))
			//rhzxdh
				
			
		if (event.getMessage().contains("epic_jbot")){
		
		
		if (event.getMessage().startsWith("epic_jbot, pls")){
			 event.getBot().sendMessage("#p_slice", "It's what I do!");
		} else if (event.getMessage().startsWith("epic_jbot pls")){
			 event.getBot().sendMessage("#p_slice", "You got a problem with me!?!");
		} else if ((event.getMessage().equals(("epic_jbot, I KILL YOU")) && (event.getUser().getNick().toString().equals("epic_jdog")))){
              event.getBot().disconnect();
		
		} else {
		  
			final Random rand = new Random();

			String[] phrases = {"Yo!", "That would be this fine bot right here.", "This is the jbot you're looking for!", "Yea Buddy!", "jbot is best bot!"};
			String response = phrases[rand.nextInt(phrases.length)];
			event.getBot().sendMessage("#p_slice", response);
			
		
		}
		  
		  
		}
		  if (event.getMessage().startsWith("!time")){
				 
			  Calendar calendar = Calendar.getInstance();;
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		    	 String currenttime = null;	  
			  
			  currenttime = sdf.format(calendar.getTime());
			  
	    		event.getBot().sendMessage("#p_slice", "It's currently " + currenttime + " PST.");
		  }
		  
	}
	@Override	  
	public void onAction(ActionEvent event) throws Exception{
		 String firedmessage = null;
			  if (event.getMessage().contains("vlees")) {
				firedmessage = event.getUser().getNick() + ", you're fired.";
			  	event.getBot().sendMessage("#p_slice", firedmessage);
			  }
			 
			  
		  }




	}


