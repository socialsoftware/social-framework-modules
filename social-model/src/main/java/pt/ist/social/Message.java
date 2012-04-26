package pt.ist.social;

import org.joda.time.DateTime;
import pt.ist.authentication.User;

public class Message extends Message_Base {

    public void init(String text, User author) {
        setText(text);
        setAuthor(author);
        setTimestamp(new DateTime());
    }
}
