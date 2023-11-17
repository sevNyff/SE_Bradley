package ch.fhnw.richards.Week_11.translator;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Translator {
    protected Locale currentLocale;
    private ResourceBundle resourceBundle;

    public Translator(String localeString) {
        // Can we find the language in our supported locales?
        // If not, use VM default locale
        Locale locale = Locale.forLanguageTag(localeString);

        // Load the resource strings - (here, we hard-code the file-name)
        //resourceBundle = ResourceBundle.getBundle(this.getClass().getName(), locale);
        resourceBundle = ResourceBundle.getBundle("ch.fhnw.richards.Week_11.translator.resources", locale);
        Locale.setDefault(locale); // Change VM default (for dialogs, etc.)
        currentLocale = locale;
    }

    /**
     * Public method to get string resources, default to "--" *
     */
    public String getString(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return "--";
        }
    }
}
