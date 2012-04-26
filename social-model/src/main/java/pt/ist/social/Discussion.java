package pt.ist.social;

import pt.ist.authentication.User;

public class Discussion extends Discussion_Base {

    public void init(String subject, User creator) {
        this.setSubject(subject);
        this.setCreator(creator);
    }
}
