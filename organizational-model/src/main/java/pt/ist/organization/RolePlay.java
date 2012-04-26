package pt.ist.organization;

import org.joda.time.DateTime;
import pt.ist.util.time.EffectivePeriod;

public class RolePlay extends RolePlay_Base {

    public void init() {
        init(new DateTime());
    }

    public void init(DateTime startTimestamp) {
        init(startTimestamp, null);
    }

    public void init(DateTime startTimestamp, DateTime endTimestamp) {
        EffectivePeriod effectivePeriod = new EffectivePeriod();
        effectivePeriod.init(startTimestamp, endTimestamp);
        setEffectivePeriod(effectivePeriod);
    }

    public boolean isActiveOn(DateTime timestamp) {
        if(getEffectivePeriod()==null) {
            return getAccountability().isActiveOn(timestamp);
        } else {
            return getEffectivePeriod().contains(timestamp);
        }
    }

    public void terminate() {
        EffectivePeriod effectivePeriod = getEffectivePeriod();
        if(effectivePeriod == null) {
            effectivePeriod = new EffectivePeriod();
            EffectivePeriod accountabilityEffectivePeriod = getAccountability().getEffectivePeriod();
            effectivePeriod.init(accountabilityEffectivePeriod.getStartTimestamp());
        }
        effectivePeriod.setEndTimestamp(new DateTime());
    }

}
