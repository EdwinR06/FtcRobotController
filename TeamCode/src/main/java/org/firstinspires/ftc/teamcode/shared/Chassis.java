package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

//Runs Completed
public class Chassis {
    private Motor frontLeft;
    private Motor frontRight;
    private Motor backLeft;
    private Motor backRight;
    private double error;
    private double correctionSum;
    private final double propCoef = 0.01;
    private final double derCoef = 0.000000000000000000000001;
    private final double intCoef = 0.000000000000000000000001;
    private double correction;
    private double previousError;
    private double proportional;
    private double derivative;
    private double integral;
    private double distanceTurn;
    private final double baseRad = 24.6138172578/2;
    private double correctionTotal;

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

    public double correction(double error, double previousError, double power, double correctionSum){
        proportional = propCoef * error;
        derivative = derCoef * (error - previousError);
        integral = correctionSum * intCoef;
        if(power < .95 && power > -.95){
            correction = power + proportional + derivative + integral;
        } else {
            correction = power - proportional - derivative - integral;
        }
        return correction;
    }

    public void driveStraight(double distance, double power) {
        frontLeft.resetEncoder();
        backRight.resetEncoder();
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        setPowers(power);

        while (Math.abs(frontLeft.getDistance()) < Math.abs(distance-1) && Math.abs(backRight.getDistance()) < Math.abs(distance-1) && FTCUtil.isOpModeActive()) {
            error = Math.abs(frontLeft.getDistance()) - Math.abs(backRight.getDistance());

            correctionTotal = correction(error, previousError, power, correctionSum);

            if(((frontLeft.getDistance()) + (backRight.getDistance()))/2 >= (Math.abs(distance))*0.9){

                if(error > 0 ){
                    frontLeft.setPower(Range.clip(correctionTotal*.9, -1.0, 1.0));
                    backLeft.setPower(Range.clip(correctionTotal*.9, -1.0, 1.0));
                    frontRight.setPower(Range.clip(power*.9, -1.0, 1.0));
                    backRight.setPower(Range.clip(power*.9, -1.0, 1.0));
                } else {
                    frontLeft.setPower(Range.clip(power*9, -1.0, 1.0));
                    backLeft.setPower(Range.clip(power*.9, -1.0, 1.0));
                    frontRight.setPower(Range.clip(correctionTotal*.9, -1.0, 1.0));
                    backRight.setPower(Range.clip(correctionTotal*.9, -1.0, 1.0));
                }
                previousError = error;
                correctionSum += correctionTotal;
            } else {

                if(error > 0 ){
                    frontLeft.setPower(Range.clip(correctionSum, -1.0, 1.0));
                    backLeft.setPower(Range.clip(correctionSum, -1.0, 1.0));
                    frontRight.setPower(Range.clip(power, -1.0, 1.0));
                    backRight.setPower(Range.clip(power, -1.0, 1.0));
                } else {
                    frontLeft.setPower(Range.clip(power, -1.0, 1.0));
                    backLeft.setPower(Range.clip(power, -1.0, 1.0));
                    frontRight.setPower(Range.clip(correctionSum, -1.0, 1.0));
                    backRight.setPower(Range.clip(correctionSum, -1.0, 1.0));
                }
                previousError = error;
                correctionSum += correctionSum;
            }

        }

        stopMotors();
    }

    // Positive degree = right turn, negative degree = left turn
    public void turnAuto(double degree, double power){
        frontLeft.resetEncoder();
        backRight.resetEncoder();

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(-power);
        frontRight.setPower(-power);

        distanceTurn = (degree / 360.0) * baseRad * Math.PI;

        while (Math.abs(frontLeft.getDistance()) < Math.abs(distanceTurn) && Math.abs(backRight.getDistance()) < Math.abs(distanceTurn) && FTCUtil.isOpModeActive()){
        }

        stopMotors();
    }

    public void drive(double drive, double turn, double strafe) {
        frontLeft.setPower(drive - strafe + turn);
        backLeft.setPower(drive + strafe + turn);
        frontRight.setPower(drive + strafe - turn);
        backRight.setPower(drive - strafe - turn);
    }

}