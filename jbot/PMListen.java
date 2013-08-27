package jbot;


import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class PMListen extends ListenerAdapter implements Listener {

	
	@Override
	 public void onPrivateMessage(PrivateMessageEvent event) throws Exception {

	
	if (!event.getUser().getNick().toString().equals("epic_jdog")){
		event.respond("Hi there, I'm, epic_jdog's bot. I don't reply through here, so if you have questions about me, talk to epic_jdog if he's online. Good day, sir.");
		String user = event.getUser().getNick();
		String pmessage = event.getMessage();
		event.getBot().sendMessage("epic_jdog", "PM received from " + user + ": " + pmessage);

		return;
	}
	
	event.getBot().sendMessage("epic_jdog", "only you should see this!?");
	
}
}