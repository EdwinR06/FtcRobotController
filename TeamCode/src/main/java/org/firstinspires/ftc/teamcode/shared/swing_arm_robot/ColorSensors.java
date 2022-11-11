package org.firstinspires.ftc.teamcode.shared.swing_arm_robot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorSensors {
    private ColorSensor colorSensor;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public ColorSensors(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        colorSensor = hardwareMap.get(ColorSensor.class, "color");
    }

    public void getRed() {
        telemetry.addData("Red: ", colorSensor.red());
    }


}
