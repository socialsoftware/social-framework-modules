package pt.ist.organization;

import pt.ist.util.i18n.Language;
import pt.ist.util.i18n.MultiLanguageString;

public class AccountabilityType extends AccountabilityType_Base {

    public void init(String designation) {
        MultiLanguageString multiLanguageString = new MultiLanguageString();
        multiLanguageString.setTranslation(Language.PT, designation);
        setDesignation(multiLanguageString);
    }
}
