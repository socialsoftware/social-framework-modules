package pt.ist.util.i18n;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

public final class MultiLanguageString implements Serializable {

    private final static Gson GSON = new Gson();
    private final Map<Language, String> translationMap;

    public MultiLanguageString() {
        this(new EnumMap<Language,String>(Language.class));
    }

    public MultiLanguageString(String translation) {
        this();
        setTranslation(Language.EN, translation);
    }

    public MultiLanguageString(Map<Language,String> translationMap) {
        this.translationMap = translationMap;
    }

    public String getTranslation(Language language) {
        if(translationMap.containsKey(language)) {
            return translationMap.get(language);
        } else if(translationMap.containsKey(Language.EN)) {
            return translationMap.get(Language.EN);
        } else {
            for(Language existingLanguage : translationMap.keySet()) {
                return translationMap.get(existingLanguage);
            }
        }
        return null;
    }

    public void setTranslation(Language language, String translation) {
        translationMap.put(language, translation);
    }

    public String exportAsString() {
        return GSON.toJson(translationMap);
    }

    public static MultiLanguageString fromString(String externalizedMultiLanguageString) {
        Map<Language,String> translationMap = GSON.fromJson(externalizedMultiLanguageString, new TypeToken<Map<Language, String>>() {}.getType());
        return new MultiLanguageString(translationMap);
    }

    public Map<Language, String> getTranslationMap() {
        return translationMap;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj ||
                (obj != null &&
                (obj.getClass() == this.getClass()) &&
                ((MultiLanguageString)obj).getTranslationMap().equals(translationMap));
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + translationMap.hashCode();
        return hash;
    }

}

