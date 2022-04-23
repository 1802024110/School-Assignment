package computer.usb.device;

import computer.usb.Usb;

public class Microphone implements Usb {
    @Override
    public void turnOn() {
        System.out.println("Microphone is on");
    }

    @Override
    public void turnOff() {
        System.out.println("Microphone is off");
    }
}
