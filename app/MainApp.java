// Файл: app/MainApp.java
package app;

import translation.Translator;

public class MainApp {
    public static void main(String[] args) {
        Translator t = new Translator();
        System.out.println(t.translate("Hello world"));
    }
}
