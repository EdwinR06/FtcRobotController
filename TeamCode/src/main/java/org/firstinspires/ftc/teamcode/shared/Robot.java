package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private Chassis chassis;
    private SpinningArm spinningArm;
    private Intake intakeMotor;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        chassis = new Chassis(hardwareMap,telemetry);
        spinningArm = new SpinningArm(hardwareMap, telemetry);
        intakeMotor = new Intake(hardwareMap, telemetry);
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

    void spinLeft(boolean spin){
        spinningArm.spinLeft(spin);
    }

    void spinRight(boolean spin) { spinningArm.spinRight(spin); }

    void spinLeftAuto(){ spinningArm.spinLeftAuto(); }

    void spinRightAuto(){ spinningArm.spinRightAuto(); }

    void intake(double power) {
        intakeMotor.intake(power);
    }

    void deposit(double power) {
        intakeMotor.deposit(power);
    }

    void intakeAuto() { intakeMotor.intakeAuto(); }

    void depositAuto() {
        intakeMotor.depositAuto();
    }

}