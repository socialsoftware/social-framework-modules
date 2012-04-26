package pt.ist.util.i18n;

import java.util.HashSet;
import java.util.Set;

public enum Language {
    EN,
    PT,
    FR,
    DE,
    IT,
    ES;

    public static Language LANGUAGE = Language.PT;

    private final Set<ChangeListener> changeListenerSet = new HashSet<ChangeListener>();

    public interface ChangeListener {
        public void onLanguageChange(Language language);
    }

    public void addChangeListener(ChangeListener changeListener) {
        changeListenerSet.add(changeListener);
    }

    public void removeChangeListener(ChangeListener changeListener) {
        changeListenerSet.remove(changeListener);
    }

    public void setLanguage(Language language) {
        LANGUAGE = language;
        for(ChangeListener changeListener : changeListenerSet) {
            changeListener.onLanguageChange(language);
        }
    }

}
