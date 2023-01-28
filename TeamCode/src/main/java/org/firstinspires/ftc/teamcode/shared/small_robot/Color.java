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
        telemetry.addData("Red", colorSensor.red());
        telemetry.update();
        return colorSensor.red();
    }

    public int getBlue() {
        telemetry.addData("Blue", colorSensor.blue());
        telemetry.update();
        return colorSensor.blue();
    }

    public int getGreen() {
        telemetry.addData("Green", colorSensor.green());
        telemetry.update();
        return colorSensor.green();
    }
}
