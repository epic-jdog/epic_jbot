/**
 * Created by James Ward (epic_jdog)
 *
 * Date: 02/11/13
 * Time: 5:50 PM
 *
 *
 */
package net.epic_jdog.jbot;


import java.util.Random;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ActionEvent;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;


@SuppressWarnings("rawtypes")
public class BasicListen extends ListenerAdapter {


    private PircBotX bot;

    public BasicListen(PircBotX jbot) {
        bot = jbot;
    }


    @Override
    public void onAction(ActionEvent event) throws Exception {
        String firedmessage = null;
        if (event.getMessage().toLowerCase().contains("vlees")) {
            firedmessage = event.getUser().getNick() + ", you're fired.";
            bot.sendMessage(event.getChannel(), firedmessage);
        }

        if (event.getMessage().contains("runs")) {
            String strung = event.getUser().getNick().toString();
            bot.sendMessage(event.getChannel(), "Nooo, please, " + strung
                    + "! Come baaack!!!");

        }

    }

    @Override
    public void onMessage(MessageEvent event) throws Exception {

        String message = event.getMessage();
        if (message.toLowerCase().contains(("vlee")))
            bot.sendMessage(event.getChannel(), "Aww.");


        if (message.contains("spam"))
            bot.sendMessage((event.getChannel()),
                    "Spam, spam, spam, spam, SPASPAAM!");

        if (message.equals("jbot, I KILL YOU")
                && event.getUser().getNick().toString().equals("epic_jdog")) {
            bot.disconnect();
        }


        if (message.contains("epic_jbot")) {

            if (message.startsWith("epic_jbot, pls")) {
                bot.sendMessage(event.getChannel(), "It's what I do!");
                return;
            }
            if (message.startsWith("epic_jbot pls")) {
                bot.sendMessage(event.getChannel(),
                        "You got a problem with me!?!");
                return;
            }

            if (message.equals("epic_jbot, I KILL YOU")
                    && event.getUser().getNick().toString()
                    .equals("epic_jdog")) {
                bot.disconnect();
                return;
            }


            final Random rand = new Random();

            String[] phrases = {"Yo!",
                    "That would be this fine bot right here.",
                    "G'day, sirs.", "This is the jbot you're looking for!",
                    "Yea Buddy!", "jbot is best bot!", "Hello, mates!"};
            final String response = phrases[rand.nextInt(phrases.length)];
            bot.sendMessage(event.getChannel(), response);

        }


    }

}
