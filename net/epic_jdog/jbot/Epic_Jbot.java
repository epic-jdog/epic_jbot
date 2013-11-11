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
import org.pircbotx.cap.SASLCapHandler;

public class Epic_Jbot {
    public static final PircBotX mecha_jdog = new PircBotX();


    public static void main(String[] args) throws Exception {


        mecha_jdog.setName("epic_jbot");
        mecha_jdog.setCapEnabled(true);
        mecha_jdog.setVerbose(true);
        mecha_jdog.setAutoSplitMessage(true);
        for (int i = 42;i > 0; i--){
            System.out.println(BotInfo.BotInfo("42", true));
        }
        mecha_jdog.getCapHandlers().add(new SASLCapHandler(BotInfo.BotInfo("login", true), BotInfo.BotInfo("password", true)));
        mecha_jdog.setLogin(BotInfo.BotInfo("login", true));
        mecha_jdog.getListenerManager().addListener(new BasicListen(mecha_jdog));
        mecha_jdog.getListenerManager().addListener(new MessageEventHandler(mecha_jdog));


        try {
            mecha_jdog.connect("irc.seion.us");
            mecha_jdog.joinChannel("#epic_jdog");
            mecha_jdog.setAutoNickChange(false);


        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("IT DONE GOOFT ON JOINING!");

        }

    }

}
