package pt.ist.organization;

import java.util.HashSet;
import java.util.Set;
import org.joda.time.DateTime;

public abstract class Party extends Party_Base {

    public abstract boolean isPerson();
    public abstract boolean isOrganizationalUnit();


    public Set<Role> getCurrentRoleSet() {
        return getRoleSetActiveOn(new DateTime());
    }

    public Set<Role> getRoleSetActiveOn(DateTime timestamp) {
        Set<Role> activeRoleSet = new HashSet<Role>();
        for(RolePlay activeRolePlay : getRolePlaySetActiveOn(timestamp)) {
            activeRoleSet.add(activeRolePlay.getRole());
        }
        return activeRoleSet;
    }

    public Set<RolePlay> getCurrentRolePlaySet() {
        return getRolePlaySetActiveOn(new DateTime());
    }

    public Set<Accountability> getCurrentAccountabilitySet() {
        return getAccountabilitySetActiveOn(new DateTime());
    }

    public Set<RolePlay> getRolePlaySetActiveOn(DateTime timestamp) {
        Set<RolePlay> activeRolePlaySet = new HashSet<RolePlay>();
        for(RolePlay rolePlay : getRolePlaySet()) {
            if(rolePlay.isActiveOn(timestamp)) {
                activeRolePlaySet.add(rolePlay);
            }
        }
        return activeRolePlaySet;
    }

    public Set<Accountability> getAccountabilitySetActiveOn(DateTime timestamp) {
        Set<Accountability> activeAccountabilitySet = new HashSet<Accountability>();
        for(RolePlay activeRolePlay : getRolePlaySetActiveOn(timestamp)) {
            activeAccountabilitySet.add(activeRolePlay.getAccountability());
        }
        return activeAccountabilitySet;
    }
}
