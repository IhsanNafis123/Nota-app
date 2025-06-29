package manage;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    private static Locale currentLocale = new Locale("id"); // default Indonesia
    private static ResourceBundle messages = ResourceBundle.getBundle("resource.messages", currentLocale);

    public static void setLanguage(String langCode) {
        currentLocale = new Locale(langCode);
        messages = ResourceBundle.getBundle("resource.messages", currentLocale);
    }

    public static String get(String key) {
        return messages.getString(key);
    }
}
