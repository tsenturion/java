// Файл: devices/AbstractDevice.java
package devices;

public abstract class AbstractDevice {
    protected String model;

    public AbstractDevice(String model) {
        this.model = model;
    }

    protected void showModel() {
        System.out.println("Модель устройства: " + model);
    }
}
