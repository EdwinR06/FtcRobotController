package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Blocker {
    private Servo blockerMotor = null;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Blocker(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        blockerMotor = hardwareMap.get(Servo.class, "blocker_motor");
        blockerMotor.setDirection(Servo.Direction.FORWARD);
    }

    public void closeBlocker(){
        blockerMotor.setPosition(0.5);
    }

    public void openBlocker() {
        blockerMotor.setPosition(0.0);
    }


}