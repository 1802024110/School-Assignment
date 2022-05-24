package computer;

import computer.usb.Usb;

public class Computer {
    private final Usb[] usb;

    public Computer(Usb[] usb) {
    // 初始化usb设备
        this.usb = usb;
    }

    public void powerOn() {
        for (Usb usb : this.usb) {
            usb.turnOn();
        }
        System.out.println("Computer is on");
    }

    public void powerOff() {
        for (Usb usb : this.usb) {
            usb.turnOff();
        }
        System.out.println("Computer is off");
    }
}
