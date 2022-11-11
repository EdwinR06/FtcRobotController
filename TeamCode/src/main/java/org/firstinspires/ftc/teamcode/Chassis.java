package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Chassis {
    private DcMotor leftFront = null;
    private DcMotor leftRear = null;
    private DcMotor rightFront = null;
    private DcMotor rightRear = null;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private static final double TICKS_PER_INCH=39.6;
    private double baseDi = 32.5;//24.6138172578;


    public Chassis(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        leftFront = hardwareMap.get(DcMotor.class, "front_left_motor");
        leftRear = hardwareMap.get(DcMotor.class, "back_left_motor");
        rightFront = hardwareMap.get(DcMotor.class, "front_right_motor");
        rightRear = hardwareMap.get(DcMotor.class, "back_right_motor");

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.FORWARD);
    }

    void driveStraight(double distance){

        double ticksToRun=Math.abs(distance)*TICKS_PER_INCH;
        int ticksSoFar = 0;
        int startPos=leftFront.getCurrentPosition();
        if (distance<0) {
            leftFront.setPower(-0.2);
            leftRear.setPower(-0.2);
            rightFront.setPower(-0.2);
            rightRear.setPower(-0.2);
        } else {
            leftFront.setPower(0.2);
            leftRear.setPower(0.2);
            rightFront.setPower(0.2);
            rightRear.setPower(0.2);
        }
        while (ticksSoFar<ticksToRun){
            ticksSoFar = Math.abs(leftFront.getCurrentPosition() - startPos);
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);

    }

    void pointTurn(double angle,boolean rightTurn) {
        double turnDistance = (angle/360.0)*baseDi*Math.PI;
        double TicksSoFar = 0;
        double TickstoRun = turnDistance*TICKS_PER_INCH;
        int startPos=leftFront.getCurrentPosition();
        double power = 0.25;
        if (!rightTurn){
            power=-power;
        }
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(-power);
        rightRear.setPower(-power);
        while (TicksSoFar<TickstoRun){
            TicksSoFar = Math.abs(leftFront.getCurrentPosition()-startPos);
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    void drive(double drive, double turn, double strafe) {
        leftFront.setPower(drive + strafe + turn);
        leftRear.setPower(drive - strafe + turn);
        rightFront.setPower(drive - strafe - turn);
        rightRear.setPower(drive + strafe - turn);
    }

}