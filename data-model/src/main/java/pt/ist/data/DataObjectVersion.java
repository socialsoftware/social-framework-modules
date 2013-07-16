package pt.ist.data;

import java.util.HashMap;
import java.util.Map;

import pt.ist.authentication.User;
import pt.ist.util.time.EffectivePeriod;

public class DataObjectVersion extends DataObjectVersion_Base {

    public void init(User author, HashMap<String, Object> attributes) {
        init(author);
        setAttributes(attributes);
    }	
	
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
    	forkedDataObjectVersion.setAttributes(getAttributes());
    	return forkedDataObjectVersion;
    }
    
    public DataObjectVersion getNewVersion(User author, HashMap<String, Object> attributes){
    	DataObjectVersion newVersion = new DataObjectVersion();	
        newVersion.init(author, attributes);
        return newVersion;
    }
    
    public DataObjectVersion getNewVersion(User author){
    	DataObjectVersion newVersion = new DataObjectVersion();
        newVersion.init(author, this.getAttributes());
        return newVersion;
    }
    
    public static HashMap<String, Object> getDefaultAttributes()
    {
    	HashMap<String, Object> values = new HashMap<String, Object>();
    	values.put("Name", null);
    	values.put("Description", null);
    	return values;
    }
    
    public HashMap<String, Object> getAttributes(){
    	HashMap<String, Object> values = new HashMap<String, Object>();

    	if(getExternalizedValue() != null){
    		values.put("Externalized Value", getExternalizedValue());
    	}

    	for(DataObjectAttribute attribute : getAttribute()){
    		values.put(attribute.getLabel(), attribute.getExternalizedValue());
    	}
		return values;
    }
    
    public void setAttributes(HashMap<String, Object> attributes){
    	if(attributes.size() != 0){
    		for(Map.Entry<String , Object> attribute : attributes.entrySet()){
    			if(attribute.getKey().equals("Externalized Value"))
	    		{
	    			setExternalizedValue((String)attribute.getValue());
	    		}
    			else
    			{
	    			DataObjectAttribute newAttribute = new DataObjectAttribute();
		    		newAttribute.init(attribute.getKey(), DataObjectType.STRING, (String)attribute.getValue());
		    		this.addAttribute(newAttribute);
    			}
        	}
    	}
    }
}
