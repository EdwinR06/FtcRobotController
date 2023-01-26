package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Gripper {
    private Servo gripperServo = null;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;

    public Gripper(Telemetry telemetry, HardwareMap hardwareMap) {
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;

        gripperServo = hardwareMap.get(Servo.class, "gripper_servo");
        gripperServo.setDirection(Servo.Direction.FORWARD);
    }

    public void grip(){
        gripperServo.setPosition(0.0);
    }

    public void unGrip() {
        gripperServo.setPosition(3.5);
    }
}
