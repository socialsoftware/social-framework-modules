package pt.ist.social;

import org.joda.time.DateTime;
import pt.ist.authentication.User;
import pt.ist.util.time.EffectivePeriod;

public class ParticipationRolePlay extends ParticipationRolePlay_Base {

    void init(ParticipationRole participationRole, User participant) {
        setRole(participationRole);
        setParticipant(participant);
        EffectivePeriod effectivePeriod = new EffectivePeriod();
        effectivePeriod.init();
        setEffectivePeriod(effectivePeriod);
    }

    boolean hasParticipationRole(ParticipationRole participationRole) {
        return getRole().equals(participationRole);
    }

    public boolean isActive() {
        return getEffectivePeriod()!=null && getEffectivePeriod().contains(new DateTime());
    }

    public boolean isActiveOn(DateTime timestamp) {
        return getEffectivePeriod().contains(timestamp);
    }

    public void terminate() {
        getEffectivePeriod().terminate();
    }
}
