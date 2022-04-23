package computer;

import computer.usb.Usb;
import computer.usb.device.KeyBoard;
import computer.usb.device.Microphone;
import computer.usb.device.Mouse;

public class T1 {
    public static void main(String[] args) {
        Usb[] usb = new Usb[3];
        usb[0] = new Mouse();
        usb[1] = new Microphone();
        usb[2] = new KeyBoard();
        Computer computer = new Computer(usb);
        computer.powerOn();
    }
}
