/**
 * Created by James Ward (epic_jdog)
 *
 * Date: 02/11/13
 * Time: 5:50 PM
 *
 *
 */
package net.epic_jdog.jbot;

import org.pircbotx.PircBotX;
import org.pircbotx.User;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.Channel;
import org.pircbotx.hooks.events.MessageEvent;

public class VleeBot{
    public static final PircBotX vleebot = new PircBotX();


    public static void init() throws Exception {


        vleebot.setName("VleeBot");
        vleebot.setCapEnabled(true);
        vleebot.setVerbose(true);
        vleebot.setAutoSplitMessage(true);
       // vleebot.getCapHandlers().add(new SASLCapHandler(BotInfo.BotInfo("login", true), BotInfo.BotInfo("password", true)));
        vleebot.setLogin("vlee");
        vleebot.getListenerManager().addListener(new VleeBotListener(vleebot));


        try {
            vleebot.connect("irc.seion.us");
            vleebot.joinChannel("#vlee");
            vleebot.setAutoNickChange(false);


        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("IT DONE GOOFT ON JOINING (VLEEBOT)!");

        }


    }

}
