package net.epic_jdog.jbot;

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class MessageEventHandler extends ListenerAdapter { 
	public static String prefix = "!jbot";
	
	private PircBotX bot;
	
	
	public MessageEventHandler(PircBotX jbot) {
		bot = jbot;
	}

	
	public void onMessage(MessageEvent event) throws Exception {

		String message = event.getMessage();
		
		
		if (message.startsWith(prefix)) {
			
			Channel chan = event.getChannel();
			User u = event.getUser();
			String n = u.getNick();
			boolean authorized = false;
			if (n.equals("epic_jdog")){
				authorized = true;
			} else {
			authorized = false;
			}
			String messageraw = message;
			String delims = "[ ]";
			String[] commandparts = messageraw.split(delims);

			int i = commandparts.length;
			
			String commandname = "DEFAULT";
			String param1 = "DEFAULT";
			String param2 = "DEFAULT";
			
			if (i >= 4){
			commandname = commandparts[1];
			param1 = commandparts[2];
			param2 = commandparts[3];
			}
			if (i == 3){
				commandname = commandparts[1];
				param1 = commandparts[2];
			}
			if (i == 2){
				commandname = commandparts[1];
			}

			Command c = new Command(commandname, param1, param2, u, n, chan, authorized);
			c.exec();
		}
	}
	
		public void onPrivateMessage(PrivateMessageEvent event) throws Exception {

			String pmessage = event.getMessage();
			User u = event.getUser();
			String n = u.getNick();
			if (n.equals("epic_jdog")) {
				
				
				String pmessageraw = pmessage;
				String delims = "[ ]";
				String[] commandparts = pmessageraw.split(delims);
				
				int i = commandparts.length;
				String commandname = "DEFAULT";
				String param1 = "DEFAULT";
				String param2 = "DEFAULT";
				if (i >= 3){
					commandname = commandparts[1];
					param1 = commandparts[2];
				}
				if (i == 2){
					commandname = commandparts[1];
				}

				PMCommand p = new PMCommand(commandname, param1, pmessageraw);
				p.exec();
		} else {
				event.respond("Hi there, I'm, epic_jdog's bot. I don't reply through here, so if you have questions about me, talk to epic_jdog if he's online. Good day, sir.");
				bot.sendMessage("epic_jdog",
						"PM received from " + n + ": " + pmessage);
			}
	
	
	}
	
	
	
	
}
