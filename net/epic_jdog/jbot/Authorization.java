package net.epic_jdog.jbot;

/**
 * Created with IntelliJ IDEA.
 * User: James W
 * Date: 01/11/13
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */

import net.epic_jdog.jbot.TextRead;

public class Authorization {

    public boolean isOperator(String nick) {
        return TextRead.FileContains(nick, "authoperator");
    }

    public boolean isTrusted(String nick) {
        return TextRead.FileContains(nick, "authtrust");
    }


}
