package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Chassis {
    private DriveWheel frontLeft;
    private DriveWheel frontRight;
    private DriveWheel backLeft;
    private DriveWheel backRight;
    private static final double LOOK_AHEAD_DISTANCE = 12;

    public Chassis() {
        FTCUtil.telemetry.addData("Status", "Initialized");
        frontLeft = new DriveWheel("frontLeftMotor", DcMotor.Direction.FORWARD);
        frontRight = new DriveWheel("frontRightMotor", DcMotor.Direction.REVERSE);
        backLeft = new DriveWheel( "backLeftMotor", DcMotor.Direction.FORWARD);
        backRight = new DriveWheel( "backRightMotor", DcMotor.Direction.REVERSE);
    }

    private void stopMotors() {
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }

    private void setPowers(double motorPower){
        frontLeft.setPower(motorPower);
        frontRight.setPower(motorPower);
        backLeft.setPower(motorPower);
        backRight.setPower(motorPower);
    }

    public void driveStraight(double distance, double power) {
        frontLeft.resetEncoder();
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        setPowers(power);

        while (Math.abs(frontLeft.getDistance()) < Math.abs(distance) && FTCUtil.getOpMode().opModeIsActive()) {
        }
        stopMotors();
    }
}
