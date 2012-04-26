package pt.ist.organization;

import org.joda.time.DateTime;
import pt.ist.util.time.EffectivePeriod;

public class Accountability extends Accountability_Base {

    public void init(AccountabilityType type) {
        init(type, new DateTime());
    }

    public void init(AccountabilityType type, DateTime startTimestamp) {
        init(type, startTimestamp, null);
    }

    public void init(AccountabilityType type, DateTime startTimestamp, DateTime endTimestamp) {
        setType(type);
        EffectivePeriod effectivePeriod = new EffectivePeriod();
        effectivePeriod.init(startTimestamp, endTimestamp);
        setEffectivePeriod(effectivePeriod);
    }

    public boolean isActiveOn(DateTime timestamp) {
        return getEffectivePeriod().contains(timestamp);
    }
}
