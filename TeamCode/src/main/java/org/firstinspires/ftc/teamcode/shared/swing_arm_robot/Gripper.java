package org.firstinspires.ftc.teamcode.shared.swing_arm_robot;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Gripper {

    private Servo gripperServo = null;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Gripper(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        gripperServo = hardwareMap.get(Servo.class, "gripper_servo");
        gripperServo.setDirection(Servo.Direction.FORWARD);
    }

    public void grip(){
        gripperServo.setPosition(1.0);
    }

    public void unGrip() {
        gripperServo.setPosition(0.0);
    }
}
