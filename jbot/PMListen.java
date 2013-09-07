package jbot;

import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class PMListen extends ListenerAdapter implements Listener {
	String chatchannel = "#epic_jdog";

	@Override
	public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
		String pmessage = event.getMessage();
		if (!event.getUser().getNick().toString().equals("epic_jdog")) {
			event.respond("Hi there, I'm, epic_jdog's bot. I don't reply through here, so if you have questions about me, talk to epic_jdog if he's online. Good day, sir.");
			String user = event.getUser().getNick();
			event.getBot().sendMessage("epic_jdog",
					"PM received from " + user + ": " + pmessage);

			return;
		}

		if (event.getMessage().startsWith("!pmchat")) {
			String channelraw = pmessage.toString();

			String delims = "[ ]";
			String[] parts = channelraw.split(delims);
			chatchannel = parts[1];
			event.getBot().sendMessage(event.getUser(),
					"Target channel/nick changed to " + chatchannel);

			return;

		}
	
			event.getBot().sendMessage(chatchannel, pmessage);
	


	}
}