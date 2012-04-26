package pt.ist.organization;

import pt.ist.util.i18n.Language;
import pt.ist.util.i18n.MultiLanguageString;

public class OrganizationalUnit extends OrganizationalUnit_Base {

    public void init(String designation) {
        MultiLanguageString multiLanguageString = new MultiLanguageString();
        multiLanguageString.setTranslation(Language.PT, designation);
        setDesignation(multiLanguageString);
    }

    @Override
    public boolean isPerson() {
        return false;
    }

    @Override
    public boolean isOrganizationalUnit() {
        return true;
    }
}
