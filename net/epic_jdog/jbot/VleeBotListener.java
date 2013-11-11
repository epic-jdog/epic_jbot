package net.epic_jdog.jbot;

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by James Ward (epic_jdog)
 * <p/>
 * Date: 10/11/13
 * Time: 11:59 PM
 */
public class VleeBotListener extends ListenerAdapter {

    private PircBotX vleebot;
    public VleeBotListener(PircBotX vbot) {
        vleebot = vbot;
    }

    @Override
    public void onJoin(JoinEvent event) throws Exception {
        Channel c = event.getChannel();
        String chan = c.toString();
        User user = event.getUser();
        if(chan.equals("#vlee")){
            vleebot.sendMessage(c, "VLEEEEE!!!!");
            vleebot.sendMessage(c, "Hello, " + user.toString() + "! Better Start Vleeing!");
            vleebot.sendMessage(c, "http://dzhemzouaurd.bandcamp.com/track/interrobang-2");
        }
    }
    @Override
    public void onMessage(MessageEvent event) throws Exception {
        Channel c = event.getChannel();
        String chan = c.toString();;
        if(chan.equals("#vlee")){
            vleebot.sendMessage(c, "VLEEEEE!!!!");
            vleebot.sendMessage(c, "http://dzhemzouaurd.bandcamp.com/track/interrobang-2");
        }
    }
}
