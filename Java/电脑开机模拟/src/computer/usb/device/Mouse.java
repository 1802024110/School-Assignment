package computer.usb.device;

import computer.usb.Usb;

public class Mouse implements Usb {

    @Override
    public void turnOn() {
        System.out.println("Mouse is on");
    }

    @Override
    public void turnOff() {
        System.out.println("Mouse is off");
    }
}
