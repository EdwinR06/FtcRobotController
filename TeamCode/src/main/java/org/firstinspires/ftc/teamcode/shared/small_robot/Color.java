package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Color {
    private ColorSensor colorSensor;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Color(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        colorSensor = hardwareMap.get(ColorSensor.class, "Color");
    }

    public int getRed() {
        return colorSensor.red();
    }

    public int getBlue() {
        return colorSensor.blue();
    }

    public int getGreen() {
        return colorSensor.green();
    }
}
