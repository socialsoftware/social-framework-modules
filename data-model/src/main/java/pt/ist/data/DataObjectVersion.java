package pt.ist.data;

import pt.ist.authentication.User;
import pt.ist.util.time.EffectivePeriod;

public class DataObjectVersion extends DataObjectVersion_Base {

    public void init(DataObjectType type, String externalizedValue, User author) {
        setType(type);
        setExternalizedValue(externalizedValue);
        init(author);
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
    	for(DataObjectAttribute attribute : getAttribute()){
    		DataObjectAttribute newAttribute = new DataObjectAttribute();
    		newAttribute.init(attribute.getLabel(), attribute.getType(), attribute.getExternalizedValue());
    		forkedDataObjectVersion.addAttribute(newAttribute);
    	}
    	return forkedDataObjectVersion;
    }
    
    public DataObjectVersion newVersionOf(User author){
    	DataObjectVersion newVersion = new DataObjectVersion();
        newVersion.init(this.getType(), this.getExternalizedValue(), author);
        return newVersion;
    }
}
