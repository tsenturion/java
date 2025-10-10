// Файл: devices/Smartphone.java
package devices;

public class Smartphone extends AbstractDevice {
    public Smartphone(String model) {
        super(model);
    }

    public void displayInfo() {
        showModel(); // есть доступ к protected-методу
    }
}
