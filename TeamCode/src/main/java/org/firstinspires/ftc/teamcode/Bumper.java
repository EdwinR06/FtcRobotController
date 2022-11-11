package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Bumper {
    private Servo bumperMotor = null;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Bumper(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        bumperMotor = hardwareMap.get(Servo.class, "bumper_motor");
        bumperMotor.setDirection(Servo.Direction.FORWARD);
    }

    public void pushBlockForward(){
        bumperMotor.setPosition(1.0);
    }

    public void resetBumper() {
        bumperMotor.setPosition(0.0);
    }
}
