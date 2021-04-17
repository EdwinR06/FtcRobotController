package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;


public class Chassis {
    private DriveWheel frontLeft;
    private DriveWheel frontRight;
    private DriveWheel backLeft;
    private DriveWheel backRight;
    private DriveWheel intakeMotor;
    private DriveWheel liftMotor;
    private DriveWheel stringPuller;
    private static final double LOOK_AHEAD_DISTANCE = 12;

    public Chassis() {
        //FTCUtil.telemetry.addData("Status", "Initialized");
        frontLeft = new DriveWheel("frontLeftMotor", DcMotor.Direction.REVERSE);
        frontRight = new DriveWheel("frontRightMotor", DcMotor.Direction.FORWARD);
        backLeft = new DriveWheel( "backLeftMotor", DcMotor.Direction.REVERSE);
        backRight = new DriveWheel( "backRightMotor", DcMotor.Direction.FORWARD);
        intakeMotor = new DriveWheel("intakeMotor", DcMotor.Direction.FORWARD);
        liftMotor = new DriveWheel("liftMotor", DcMotor.Direction.FORWARD);
        stringPuller = new DriveWheel("stringPullerMotor", DcMotor.Direction.FORWARD);
    }

    private void stopMotors() {
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }

    public void setPowers(double motorPower){
        frontLeft.setPower(motorPower);
        frontRight.setPower(motorPower);
        backLeft.setPower(motorPower);
        backRight.setPower(motorPower);
    }

    public void driveStraight(double distance, double power) {
        frontLeft.resetEncoder();
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        setPowers(power);

        while (Math.abs(frontLeft.getDistance()) < Math.abs(distance) && FTCUtil.isOpModeActive()) {
        }
        stopMotors();
    }

    public void strafe(double distance, double power, boolean directionLeft) {
        frontLeft.resetEncoder();
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        if (directionLeft) {
            frontLeft.setPower(power);
            backRight.setPower(power);
            frontRight.setPower(-power);
            backLeft.setPower(-power);
        } else {
            frontRight.setPower(power);
            backLeft.setPower(power);
            frontLeft.setPower(-power);
            backRight.setPower(-power);
        }

        while(Math.abs(frontLeft.getDistance()) < Math.abs(distance) && FTCUtil.isOpModeActive()){
        }
        stopMotors();
    }

    public void drive(double straight, double turn, double strafe) {
        frontLeft.setPower(straight + strafe + turn);
        backLeft.setPower(straight - strafe + turn);
        frontRight.setPower(straight - strafe - turn);
        backRight.setPower(straight + strafe - turn);
    }

    public void intake(double power) {
        intakeMotor.setPower(power);
    }

    public void deposit(double power) {
        intakeMotor.setPower(-power);
    }

    /*public void lift(){
        liftMotor.resetEncoder();
        liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        int liftDistance = 25;

        liftMotor.setPower(.4);
        while(Math.abs(liftMotor.getDistance()) < Math.abs(liftDistance) && FTCUtil.isOpModeActive()) {
        }
        liftMotor.setPower(0);
        //liftMotor.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
    }*/

    public void lift() {
        liftMotor.setPower(.6);
    }

    public void downLift() {
        liftMotor.setPower(-.3);
    }

    public void stringIn() {
        stringPuller.setPower(.75);
    }

    public void stringOut() {
        stringPuller.setPower(-.75);
    }

    public void stringZero() {
        stringPuller.setPower(0);
    }

    /*public void downLift(){
        liftMotor.resetEncoder();
        liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        int liftDistance = 25;

        liftMotor.setPower(-(.25));
        while(Math.abs(liftMotor.getDistance()) < Math.abs(liftDistance) && FTCUtil.isOpModeActive()) {
        }
        liftMotor.setPower(0);

    }*/
}