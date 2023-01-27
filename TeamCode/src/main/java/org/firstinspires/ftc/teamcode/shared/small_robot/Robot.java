package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {


    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private Chassis chassis;
    private LinearSlide linearSlide;
    private Gripper gripper;
    private Color colorSensor;


    public Robot(HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap=hardwareMap;
        this.telemetry=telemetry;

        chassis=new Chassis(hardwareMap, telemetry);
        linearSlide=new LinearSlide(hardwareMap, telemetry);
        gripper = new Gripper(telemetry, hardwareMap);
        colorSensor = new Color(hardwareMap, telemetry);
    }

    public void drive(double drive, double turn, double strafe){
        chassis.drive(drive, turn, strafe);
    }

    public void linear(int i) throws InterruptedException {
        linearSlide.slideUp();
    }

    public void driveStraight(double distance){
        chassis.driveStraight(distance);
    }

    public void driveTurn(double turnDistance){
        chassis.driveTurn(turnDistance);
    }

    public void driveStrafe(double strafeDistance){
        chassis.driveStrafe(strafeDistance);
    }

    public void slideRaise() throws InterruptedException {
        linearSlide.slideRaise();
    }

    public void slideLower() throws InterruptedException {
        linearSlide.slideLower();
    }


    void grip() {
        gripper.grip();
    }

    void unGrip() {
        gripper.unGrip();
    }

    public int getRed() {
        return colorSensor.getRed();
    }
    public int getBlue() {
        return colorSensor.getBlue();
    }

    public int getGreen() {
        return colorSensor.getGreen();
    }

    public void slideUp() throws InterruptedException {
        linearSlide.slideUp();
    }

    public void slideDown() throws InterruptedException {
        linearSlide.slideDown();
    }


}
