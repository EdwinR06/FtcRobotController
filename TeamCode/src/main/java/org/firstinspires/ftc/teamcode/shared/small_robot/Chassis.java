package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.TimeUnit;

public class Chassis {
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private DcMotor leftFront = null;
    private DcMotor leftRear = null;
    private DcMotor rightFront = null;
    private DcMotor rightRear = null;
    private DcMotor linearSlide = null;
    private static final double Ticks_Per_Inch=39.6;

    public Chassis(HardwareMap hardwareMap,  Telemetry telemetry){
        this.hardwareMap=hardwareMap;
        this.telemetry=telemetry;

        leftFront  = hardwareMap.get(DcMotor.class, "left_front");
        leftRear = hardwareMap.get(DcMotor.class, "left_rear");
        rightFront  = hardwareMap.get(DcMotor.class, "right_front");
        rightRear = hardwareMap.get(DcMotor.class, "right_rear");
        linearSlide = hardwareMap.get(DcMotor.class, "linear_slide");

        leftFront.setDirection(DcMotor.Direction.FORWARD);
        leftRear.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightRear.setDirection(DcMotor.Direction.REVERSE);
        linearSlide.setDirection(DcMotor.Direction.FORWARD);

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive(double drive, double turn, double strafe){
        leftFront.setPower(Range.clip(drive-turn-strafe, -0.45, 0.45));
        leftRear.setPower(Range.clip(drive-turn+strafe, -0.45, 0.45));
        rightFront.setPower(Range.clip(drive+turn+strafe, -0.45, 0.45));
        rightRear.setPower(Range.clip(drive+turn-strafe, -0.45, 0.45));
    }

    public void driveStraight(double distance){
        double ticksToRun=Math.abs(distance)*Ticks_Per_Inch;
        int ticksSoFar=0;
        int startPos=rightRear.getCurrentPosition();
        if (distance>0){
            leftFront.setPower(-0.25);
            leftRear.setPower(-0.25);
            rightFront.setPower(-0.25);
            rightRear.setPower(-0.25);
        } else {
            leftFront.setPower(0.25);
            leftRear.setPower(0.25);
            rightFront.setPower(0.25);
            rightRear.setPower(0.25);
        }
        while (ticksSoFar<ticksToRun){
            ticksSoFar=Math.abs(rightRear.getCurrentPosition()-startPos);
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    public void driveTurn(double turnDistance){
        double ticksToRun=Math.abs(turnDistance)*Ticks_Per_Inch;
        int ticksSoFar=0;
        int startPos=rightRear.getCurrentPosition();
        if (turnDistance>0){
            leftFront.setPower(-0.25);
            leftRear.setPower(-0.25);
            rightFront.setPower(0.25);
            rightRear.setPower(0.25);
        } else {
            leftFront.setPower(0.25);
            leftRear.setPower(0.25);
            rightFront.setPower(-0.25);
            rightRear.setPower(-0.25);
        }
        while (ticksSoFar<ticksToRun){
            ticksSoFar=Math.abs(rightRear.getCurrentPosition()-startPos);
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    public void driveStrafe(double strafeDistance){
        double ticksToRun=Math.abs(strafeDistance)*Ticks_Per_Inch;
        int ticksSoFar=0;
        int startPos=rightRear.getCurrentPosition();
        if (strafeDistance>0){
            leftFront.setPower(-0.25);
            leftRear.setPower(0.25);
            rightFront.setPower(0.25);
            rightRear.setPower(-0.25);
        } else {
            leftFront.setPower(0.25);
            leftRear.setPower(-0.25);
            rightFront.setPower(-0.25);
            rightRear.setPower(0.25);
        }
        while (ticksSoFar<ticksToRun){
            ticksSoFar=Math.abs(rightRear.getCurrentPosition()-startPos);
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    public void slide(double slideDistance) throws InterruptedException {
        double ticksToRun=Math.abs(slideDistance)*Ticks_Per_Inch;
        int ticksSoFar=0;
        int startPos=linearSlide.getCurrentPosition();
        if (slideDistance>0){
            linearSlide.setPower(0.75);
            TimeUnit.MILLISECONDS.wait(500);

            linearSlide.setPower(0.36);
            TimeUnit.MILLISECONDS.wait(5000);
        } else {
            linearSlide.setPower(-0.75);
            TimeUnit.MILLISECONDS.wait(500);

            linearSlide.setPower(-0.36);
            TimeUnit.MILLISECONDS.wait(5000);
        }
        while (ticksSoFar<ticksToRun){
            ticksSoFar=Math.abs((linearSlide.getCurrentPosition()-startPos));
        }
        linearSlide.setPower(0);
    }
}
