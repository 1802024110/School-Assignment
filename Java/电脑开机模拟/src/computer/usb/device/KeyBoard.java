package computer.usb.device;

import computer.usb.Usb;

public class KeyBoard implements Usb {

    @Override
    public void turnOn() {
        System.out.println("KeyBoard is on");
    }

    @Override
    public void turnOff() {
        System.out.println("KeyBoard is off");
    }
}
