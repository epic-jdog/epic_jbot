package jbot;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ActionEvent;
import org.pircbotx.hooks.events.MessageEvent;
@SuppressWarnings("rawtypes")
public class BasicListen extends ListenerAdapter implements Listener {



	//@Override
	//public void onJoin(JoinEvent event) {
	//if (event.getUser().getNick().toString() != "epic_jbot"){
	// event.getBot().sendMessage(event.getChannel(), "Welcome, " +  event.getUser().getNick().toString());


	//}

	//}




	@Override
	public void onAction(ActionEvent event) throws Exception{
		String firedmessage = null;
		if (event.getMessage().contains("vlees")) {
			firedmessage = event.getUser().getNick() + ", you're fired.";
			event.getBot().sendMessage(event.getChannel(), firedmessage);
		}


	}
	@Override
	public void onMessage(MessageEvent event) throws Exception {

		String message = event.getMessage();

		try {
			
			
			if (message.startsWith("!jbot uptime")){
			RuntimeMXBean rtime = ManagementFactory.getRuntimeMXBean();
			long uptimelong = rtime.getUptime();
			String uptime = String.valueOf(uptimelong);
			event.getBot().sendMessage((event.getChannel()), "Current uptime (In milliseconds): " + uptime);
			
			}
			
			if (message.startsWith("vlee"))
				event.getBot().sendMessage(event.getChannel(), "Aww.");

			if (message.contains("spam"))
				event.getBot().sendMessage((event.getChannel()), "Spam, spam, spam, spam, SPASPAAM!");

			if (message.equals("jbot, I KILL YOU") && event.getUser().getNick().toString().equals("epic_jdog")){
				event.getBot().disconnect();
			}

			if (message.equals("!jbot disconnect") && event.getUser().getNick().toString().equals("epic_jdog"))
				event.getBot().disconnect();




			if (message.contains("epic_jbot")){


				if (message.startsWith("epic_jbot, pls")){
					event.getBot().sendMessage(event.getChannel(), "It's what I do!");
					return;
				}
				if (message.startsWith("epic_jbot pls")){
					event.getBot().sendMessage(event.getChannel(), "You got a problem with me!?!");
					return;
				}

				if (message.equals("epic_jbot, I KILL YOU") && event.getUser().getNick().toString().equals("epic_jdog")){
					event.getBot().disconnect();
					return;
				}


				final Random rand = new Random();

				String[] phrases = {"Yo!", "That would be this fine bot right here.", "G'day, sirs.", "This is the jbot you're looking for!", "Yea Buddy!", "jbot is best bot!"};
				final String response = phrases[rand.nextInt(phrases.length)];
				event.getBot().sendMessage(event.getChannel(), response);


			}



			if (message.startsWith("!time")){

				Calendar calendar = Calendar.getInstance();;
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				

				String currenttime = sdf.format(calendar.getTime());
				
				event.getBot().sendMessage(event.getChannel(), "It's currently " + currenttime + " PST.");
			}

		}
		catch (Exception ey) {
			ey.printStackTrace();
			System.out.println("IT DONE GOOFT ON LISTENING TO CHAT!!");

		}





	}

}


