package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//Runs Completed
public class Chassis {
    private Motor frontLeft;
    private Motor frontRight;
    private Motor backLeft;
    private Motor backRight;
    private static final double LOOK_AHEAD_DISTANCE = 12;
    private double error;
    private double prop = 0.03;
    private double correction;

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
        backRight.resetEncoder();
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        setPowers(power);

        while (Math.abs(frontLeft.getDistance()) < Math.abs(distance-1) && Math.abs(backRight.getDistance()) < Math.abs(distance-1) && FTCUtil.isOpModeActive()) {
            error = Math.abs(frontLeft.getDistance()) - Math.abs(backRight.getDistance());
            correction = prop * error;

            if(error > 0 ){
                frontLeft.setPower(power - correction);
                backLeft.setPower(power  - correction);
                frontRight.setPower(power);
                backRight.setPower(power);
            } else {
                frontLeft.setPower(power);
                backLeft.setPower(power);
                frontRight.setPower(power - correction);
                backRight.setPower(power - correction);
            }
        }
        stopMotors();
    }

    public void strafe(double distance, double power, boolean directionLeft) {
        frontLeft.resetEncoder();
        backRight.resetEncoder();
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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

        while((Math.abs(frontLeft.getDistance()) + (Math.abs(backRight.getDistance()))/2) < Math.abs(distance) && FTCUtil.isOpModeActive()){}
        stopMotors();
    }

    public void drive(double drive, double turn, double strafe) {
        frontLeft.setPower(drive + strafe + turn);
        backLeft.setPower(drive - strafe + turn);
        frontRight.setPower(drive - strafe - turn);
        backRight.setPower(drive + strafe - turn);
    }
}