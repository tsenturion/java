// Файл: no_secret/ForeignAgent.java
package no_secret;

import agency.AbstractSecretAgent;

public class ForeignAgent extends AbstractSecretAgent {
    public void revealForeign() {
        printSecret(); // доступ есть, потому что это наследник, даже из другого пакета
    }
}
