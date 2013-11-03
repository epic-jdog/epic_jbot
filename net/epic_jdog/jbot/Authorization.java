

/**
 * Created by James Ward (epic_jdog)
 *
 * Date: 02/11/13
 * Time: 5:00 PM
 *
 *
 */
package net.epic_jdog.jbot;

import net.epic_jdog.jbot.TextRead;

public class Authorization {

    public boolean isOperator(String nick) {
        return TextRead.FileContains(nick, "authoperator");
    }

    public boolean isTrusted(String nick) {
        return TextRead.FileContains(nick, "authtrust");
    }

    public String[] getOperators() {

        return TextRead.getWholeFile("authoperator");
    }

    public String[] getTrusted() {

        return TextRead.getWholeFile("authtrust");
    }


}
