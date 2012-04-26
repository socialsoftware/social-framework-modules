package pt.ist.util.i18n;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class MultiLanguageStringTestCase {

    private MultiLanguageString mlString;

    @Before
    public void initializeMultiLanguageString() {
        this.mlString = new MultiLanguageString();
    }

    @Test
    public void testMultiLanguageCreation() {
        mlString.setTranslation(Language.EN, "Good morning");
        mlString.setTranslation(Language.PT, "Bom dia");
        mlString.setTranslation(Language.FR, "Bonjour");
        mlString.setTranslation(Language.DE, "Guten morgen");

        assertEquals(mlString.getTranslation(Language.EN), "Good morning");
        assertEquals(mlString.getTranslation(Language.PT), "Bom dia");
        assertEquals(mlString.getTranslation(Language.FR), "Bonjour");
        assertEquals(mlString.getTranslation(Language.DE), "Guten morgen");
    }

    @Test
    public void testNoTranslationDefaultFallbackToEnglish() {
        mlString.setTranslation(Language.EN, "Good morning");
        mlString.setTranslation(Language.FR, "Bonjour");

        assertEquals(mlString.getTranslation(Language.EN), "Good morning");
        assertEquals(mlString.getTranslation(Language.FR), "Bonjour");
        assertEquals(mlString.getTranslation(Language.PT), "Good morning");
        assertEquals(mlString.getTranslation(Language.DE), "Good morning");
    }

    @Test
    public void testNoTranslationFallbackWhenNoEnglishTranslationExists() {
        mlString.setTranslation(Language.FR, "Bonjour");

        assertEquals(mlString.getTranslation(Language.EN), "Bonjour");
        assertEquals(mlString.getTranslation(Language.FR), "Bonjour");
        assertEquals(mlString.getTranslation(Language.PT), "Bonjour");
        assertEquals(mlString.getTranslation(Language.DE), "Bonjour");
    }

    @Test
    public void testNoTranslationAvailable() {
        assertNull(mlString.getTranslation(Language.EN));
        assertNull(mlString.getTranslation(Language.FR));
        assertNull(mlString.getTranslation(Language.PT));
        assertNull(mlString.getTranslation(Language.DE));
    }

    @Test
    public void testMultiLanguageStringExternalizationAndInternalization() {
        mlString.setTranslation(Language.EN, "Good morning");
        mlString.setTranslation(Language.PT, "Bom dia");
        mlString.setTranslation(Language.FR, "Bonjour");
        mlString.setTranslation(Language.DE, "Guten morgen");

        String externalizedMultiLanguageString = mlString.exportAsString();

        MultiLanguageString otherMlString = MultiLanguageString.fromString(externalizedMultiLanguageString);
        assertEquals(mlString, otherMlString);
    }

}
