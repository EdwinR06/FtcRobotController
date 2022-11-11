package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorSensor {
    private ColorSensor color = null;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;

    public ColorSensor(Telemetry telemetry, HardwareMap hardwareMap) {
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;

        color = hardwareMap.get(ColorSensor.class, "color_sensor");

    }
}
