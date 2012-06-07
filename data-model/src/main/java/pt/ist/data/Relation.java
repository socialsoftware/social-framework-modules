package pt.ist.data;

import pt.ist.util.time.EffectivePeriod;

public class Relation extends Relation_Base {
   
	public void init(){
		EffectivePeriod effectivePeriod =  new EffectivePeriod();
        effectivePeriod.init();
        setEffectivePeriod(effectivePeriod);
	}
	
	public void init(DataObject source, DataObject target){
		init();
		setSourceDataObejct(source);
		addTargetDataObject(target);
	}
}
