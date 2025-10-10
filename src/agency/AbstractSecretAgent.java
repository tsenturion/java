// Файл: agency/AbstractSecretAgent.java

package agency;

public class AbstractSecretAgent {
    protected String secretName = "Agent X"; // защищённое поле

    protected void printSecret() { // защищённый метод
        System.out.println("Секретное имя: " + secretName);
    }
}
