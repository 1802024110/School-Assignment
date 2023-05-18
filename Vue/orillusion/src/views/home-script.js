import { ComponentBase, Time } from "@orillusion/core";

export class RotationScript extends ComponentBase {

    onUpdate() {
        // 旋转
        this.transform.rotationX = Math.sin(Time.time * 0.001) * 100.0;
    }
}
