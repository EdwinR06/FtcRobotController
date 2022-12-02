package org.firstinspires.ftc.teamcode.shared.swing_arm_robot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private Chassis chassis;
    private Gripper gripper;
    private SwingArm swingArm;
    private ColorSensors colorSensor;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        chassis = new Chassis(hardwareMap,telemetry);
        gripper = new Gripper(hardwareMap, telemetry);
        swingArm = new SwingArm(hardwareMap, telemetry);
        //colorSensor = new ColorSensors(hardwareMap, telemetry);
    }

    void driveStraight(double distance){
        chassis.driveStraight(distance);
    }

    void pointTurn(double angle,boolean rightTurn) {
        chassis.pointTurn(angle,rightTurn);
    }

    void drive(double drive, double turn, double strafe){
        chassis.drive(drive, turn, strafe);
    }

    void grip() {
        gripper.grip();
    }

    void unGrip() {
        gripper.unGrip();
    }

    void swing() {
        swingArm.swing();
    }

    void unSwing() {
        swingArm.unSwing();
    }

    /*void getRed() {
        colorSensor.getRed();
    }*/

}