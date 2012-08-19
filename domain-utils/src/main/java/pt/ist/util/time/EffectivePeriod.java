package pt.ist.util.time;

import org.joda.time.DateTime;

public class EffectivePeriod extends EffectivePeriod_Base {

  public void init() {
    init(new DateTime());
  }

  public void init(DateTime startTimestamp) {
    init(startTimestamp, null);
  }

  public void init(DateTime startTimestamp, DateTime endTimestamp) {
    setStartTimestamp(startTimestamp);
    setEndTimestamp(endTimestamp);
  }

  public boolean contains(DateTime timestamp) {
      return getStartTimestamp() != null &&
              getStartTimestamp().isBefore(timestamp) &&
              (getEndTimestamp() == null ||
               getEndTimestamp().isAfter(timestamp));
  }
  
  public void terminate() {
    if(getEndTimestamp() == null) {
      setEndTimestamp(new DateTime());
    }
  }
    
  public boolean isTerminated(){
	  if(getEndTimestamp() == null){
		  return false;
	  }
	  else{
		  return true;
	  }
  }
}
