package pt.ist.data;

public class DataObjectAttribute extends DataObjectAttribute_Base {
    
   public void init(String label, DataObjectType type, String value){
	   setLabel(label);
	   setType(type);
	   setExternalizedValue(value);
   }
    
}
