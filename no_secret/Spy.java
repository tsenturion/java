// Файл: no_secret/Spy.java
package no_secret;

import agency.AbstractSecretAgent;

public class Spy {
    public void trySteal() {
        AbstractSecretAgent agent = new ForeignAgent();
        // agent.printSecret(); // Ошибка: нет доступа к protected-методу
    }
}
