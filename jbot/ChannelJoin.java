package jbot;

import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


@SuppressWarnings("rawtypes")
public class ChannelJoin extends ListenerAdapter
{
    private Epic_Jbot bot;

    public ChannelJoin(Epic_Jbot jbot) {
        bot = jbot;
    }

    @Override
    public void onMessage(MessageEvent event) {

        String channelraw;

        if (event.getMessage().startsWith("!jbot join") && event.getUser().getNick().equals("epic_jdog")) {

            channelraw = event.getMessage();
            //System.out.println(channelraw);

            String delims = "[ ]";
            String[] parts = channelraw.split(delims);

            String channeltojoin = parts[2];

            System.out.println(channeltojoin);

            bot.getBot().joinChannel(channeltojoin);
        }

        String channelrawleave;

        if (event.getMessage().startsWith("!jbot leave") && event.getUser().getNick().equals("epic_jdog")) {
            channelrawleave = event.getMessage();
            String delims = "[ ]";

            String[] partsleave = channelrawleave.split(delims);

            String channeltoleave = partsleave[2];
            System.out.println(channeltoleave);
            bot.getBot().partChannel(event.getBot().getChannel(channeltoleave));
        }
    }
}