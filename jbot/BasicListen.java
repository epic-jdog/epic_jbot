package jbot;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.pircbotx.Channel;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ActionEvent;
import org.pircbotx.hooks.events.MessageEvent;
@SuppressWarnings("rawtypes")
public class BasicListen extends ListenerAdapter{

    private Epic_Jbot bot;

    public BasicListen(Epic_Jbot jbot) {
        bot = jbot;
    }

	//@Override
	//public void onJoin(JoinEvent event) {
	//if (event.getUser().getNick().toString() != "epic_jbot"){
	// event.getBot().sendMessage(event.getChannel(), "Welcome, " +  event.getUser().getNick().toString());


	//}

	//}

	@Override
	public void onAction(ActionEvent event) {

		String firedmessage;

		if (event.getMessage().contains("vlees")) {
			firedmessage = event.getUser().getNick() + ", you're fired.";
			event.getChannel().sendMessage(firedmessage);
		}
	}
	@Override
	public void onMessage(MessageEvent event) throws Exception {

		String message = event.getMessage();
        String nick = event.getUser().getNick();
        Channel channel = event.getChannel();

		if (message.startsWith("!jbot uptime")){
		    RuntimeMXBean rtime = ManagementFactory.getRuntimeMXBean();
		    long uptimelong = rtime.getUptime();
		    String uptime = String.valueOf(uptimelong);
               channel.sendMessage("Current uptime (In milliseconds): " + uptime);
		}

		if (message.startsWith("vlee"))
           channel.sendMessage("Aww.");

        if (message.contains("spam"))
           channel.sendMessage("Spam, spam, spam, spam, SPASPAAM!");

		if (message.equals("jbot, I KILL YOU") && nick.equals("epic_jdog")){
            bot.getBot().disconnect();
		}

		if (message.equals("!jbot disconnect") && nick.equals("epic_jdog"))
            bot.getBot().disconnect();

		if (message.contains("epic_jbot")){

		    if (message.startsWith("epic_jbot, pls")){
                channel.sendMessage("It's what I do!");
			    return;
		    }
		    if (message.startsWith("epic_jbot pls")){
			    channel.sendMessage("You got a problem with me!?!");
			    return;
			}

			if (message.equals("epic_jbot, I KILL YOU") && nick.equals("epic_jdog")){
                bot.getBot().disconnect();
			    return;
			}

			Random rand = new Random();

			String[] phrases = {"Yo!", "That would be this fine bot right here.", "G'day, sirs.", "This is the jbot you're looking for!", "Yea Buddy!", "jbot is best bot!"};

            String response = phrases[rand.nextInt(phrases.length)];

			channel.sendMessage(response);
        }

		if (message.startsWith("!time")){
			Calendar calendar = Calendar.getInstance();;
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String currenttime = sdf.format(calendar.getTime());
			event.getBot().sendMessage(event.getChannel(), "It's currently " + currenttime + " PST.");
		}
	}
}


