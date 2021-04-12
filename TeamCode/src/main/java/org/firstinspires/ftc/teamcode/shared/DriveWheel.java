package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.hardware.DcMotor;

public class DriveWheel {
    private static final double ticksPerRotation = 537.7;
    public static final double WHEEL_CIRCUMFERENCE = 12.3684816931;
    private DcMotor dcMotor;
    private String deviceName;

    public DriveWheel(String deviceName, DcMotor.Direction direction) {
        this.deviceName = deviceName;
        dcMotor = FTCUtil.hardwareMap.get(DcMotor.class, deviceName);
        dcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dcMotor.setDirection(direction);
        dcMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setMode(DcMotor.RunMode mode) {
        dcMotor.setMode(mode);
    }

    public double getDistance() {
        double position = dcMotor.getCurrentPosition();
        double rotations = position / ticksPerRotation;
        return rotations * WHEEL_CIRCUMFERENCE;
    }

    public void resetEncoder() {
        dcMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setPower(double power){
        dcMotor.setPower(power);
    }

    public void setTargetDistance(double distanceInches){
        double motorTarget = dcMotor.getCurrentPosition() + (distanceInches * ticksPerRotation);
        dcMotor.setTargetPosition((int) motorTarget);
    }
}
