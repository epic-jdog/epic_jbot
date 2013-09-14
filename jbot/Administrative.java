package jbot;

import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class Administrative extends ListenerAdapter implements Listener {

	@Override
	public void onMessage(MessageEvent event) throws Exception {

		String message = event.getMessage();

		if (message.startsWith("!jbot kick")) {
			System.out.println(event.getChannel().toString());
			if (event.getUser().getNick().equals("epic_jdog")) {

				String kickraw = event.getMessage().toString();

				String delims = "[ ]";
				String[] parts = kickraw.split(delims);

				String nicktokick = parts[2];
				String reason = parts[3];
				System.out.println("Attempting to kick '" + nicktokick
						+ "' please stand by.");
				event.getBot().kick(event.getChannel(),
						event.getBot().getUser(nicktokick), reason);

			} else {

				event.getBot().sendMessage(event.getChannel(),
						"I'm Afraid not.");
			}

		}

		if ((message.startsWith("!jbot nick"))
				&& (event.getUser().getNick().equals("epic_jdog"))) {

			String nickraw = event.getMessage().toString();

			String delims = "[ ]";
			String[] parts = nickraw.split(delims);

			String nicktochangeto = parts[2];
			// String reason = parts[3];

			event.getBot().changeNick(nicktochangeto);

		}

		if ((message.equalsIgnoreCase("!jbot selfop"))
				&& (event.getUser().getNick().equals("epic_jdog"))) {

			event.getBot().sendMessage(event.getChannel(), "!op");
		}
	}

}
