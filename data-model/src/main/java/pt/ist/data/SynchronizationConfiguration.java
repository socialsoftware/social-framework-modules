package pt.ist.data;

import pt.ist.authentication.User;

public class SynchronizationConfiguration extends SynchronizationConfiguration_Base {

    public void init(User author, DataObject sourceDataObject, DataObject targetDataObject, SynchronizationPolicy sourcePolicy, SynchronizationPolicy targetPolicy) {
        setAuthor(author);
        setSourceDataObject(sourceDataObject);
        setTargetDataObject(targetDataObject);
        setSourcePolicy(sourcePolicy);
        setTargetPolicy(targetPolicy);
    }

}
