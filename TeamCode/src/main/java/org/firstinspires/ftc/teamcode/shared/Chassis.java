package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.hardware.DcMotor;

//Runs Completed
public class Chassis {
    private Motor frontLeft;
    private Motor frontRight;
    private Motor backLeft;
    private Motor backRight;
    private static final double LOOK_AHEAD_DISTANCE = 12;

    public Chassis() {
        //FTCUtil.telemetry.addData("Status", "Initialized");
        frontLeft = new Motor("frontLeftMotor", DcMotor.Direction.REVERSE);
        frontRight = new Motor("frontRightMotor", DcMotor.Direction.FORWARD);
        backLeft = new Motor( "backLeftMotor", DcMotor.Direction.REVERSE);
        backRight = new Motor( "backRightMotor", DcMotor.Direction.FORWARD);
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
}