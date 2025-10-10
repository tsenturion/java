// Файл: agency/LocalAgent.java

package agency;

public class LocalAgent extends AbstractSecretAgent {
    public void reveal() {
        printSecret(); // доступ есть, потому что наследник и тот же пакет
    }
}
