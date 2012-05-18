package pt.ist.social;

import org.joda.time.DateTime;

import pt.ist.authentication.User;

public class Discussion extends Discussion_Base {

    public void init(String subject, User creator) {
        this.setSubject(subject);
        this.setCreator(creator);
        this.setTimestamp(new DateTime());
    }
    
	public void createMessage(User author, String text) {
		Message message = new Message();
		message.init(text, author);
		addMessage(message);
	}
}
