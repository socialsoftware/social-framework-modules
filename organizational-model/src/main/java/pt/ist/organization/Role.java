package pt.ist.organization;

import java.util.HashSet;
import java.util.Set;
import org.joda.time.DateTime;
import pt.ist.util.i18n.Language;
import pt.ist.util.i18n.MultiLanguageString;

public class Role extends Role_Base {

    public void init(String designation) {
        MultiLanguageString multiLanguageString = new MultiLanguageString();
        multiLanguageString.setTranslation(Language.PT, designation);
        setDesignation(multiLanguageString);
    }

    public Set<Party> getCurrentPlayerSet() {
        return getPlayerSetActiveOn(new DateTime());
    }

    public Set<Party> getPlayerSetActiveOn(DateTime timestamp) {
        Set<Party> activePartySet = new HashSet<Party>();
        for(RolePlay rolePlay : getRolePlaySet()) {
            if(rolePlay.isActiveOn(timestamp)) {
                activePartySet.add(rolePlay.getParty());
            }
        }
        return activePartySet;
    }
}
