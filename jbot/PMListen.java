package jbot;


import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class PMListen extends ListenerAdapter {

    private Epic_Jbot bot;

	public PMListen(Epic_Jbot jbot) {
        bot = jbot;
    }

	@Override
	public void onPrivateMessage(PrivateMessageEvent event) {

        if (!event.getUser().getNick().equals("epic_jdog")){

            String user = event.getUser().getNick();
            String pmessage = event.getMessage();

		    event.respond("Hi there, I'm, epic_jdog's bot. I don't reply through here, so if you have questions about me, talk to epic_jdog if he's online. Good day, sir.");
		    bot.getBot().sendMessage("epic_jdog", "PM received from " + user + ": " + pmessage);
        }
    }
}