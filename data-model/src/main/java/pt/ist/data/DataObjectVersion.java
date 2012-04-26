package pt.ist.data;

import pt.ist.authentication.User;
import pt.ist.util.time.EffectivePeriod;

public class DataObjectVersion extends DataObjectVersion_Base {

    public void init(DataObjectType type, String label, String externalizedValue, User author) {
        setType(type);
        setLabel(label);
        setExternalizedValue(externalizedValue);
        setAuthor(author);
        setEffectivePeriod(new EffectivePeriod());
    }
}
