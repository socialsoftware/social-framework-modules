package pt.ist.data;

import pt.ist.authentication.User;
import pt.ist.util.time.EffectivePeriod;

public class DataObjectVersion extends DataObjectVersion_Base {

    public void init(DataObjectType type, String externalizedValue, User author) {
        setType(type);
        setExternalizedValue(externalizedValue);
        setAuthor(author);
        EffectivePeriod effectivePeriod = new EffectivePeriod();
        effectivePeriod.init();
        setEffectivePeriod(effectivePeriod);
    }
    
    public void init(User author) {
        setAuthor(author);
        EffectivePeriod effectivePeriod = new EffectivePeriod();
        effectivePeriod.init();
        setEffectivePeriod(effectivePeriod);
    }
    
    public DataObjectVersion fork(DataObjectVersion forkedDataObjectVersion,User author){
    	if(forkedDataObjectVersion == null){
    		forkedDataObjectVersion =  new DataObjectVersion();
    	}
    	forkedDataObjectVersion.init(author);
    	return forkedDataObjectVersion;
    }
}
