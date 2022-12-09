package org.firstinspires.ftc.teamcode.shared.swing_arm_robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SwingArm {
    private DcMotor swingArmRight = null;
    private DcMotor swingArmLeft = null;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private static final double TICKS_PER_ROTATION=537.6;

    public SwingArm(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        swingArmRight = hardwareMap.get(DcMotor.class, "right_arm");
        swingArmLeft = hardwareMap.get(DcMotor.class, "left_arm");


        swingArmRight.setDirection(DcMotor.Direction.REVERSE);
        swingArmLeft.setDirection(DcMotor.Direction.FORWARD);

    }

    public void swing() {
        double ticksToRun = TICKS_PER_ROTATION * (112.0/360.0);
        int ticksSoFar = 0;
        int startPos = swingArmRight.getCurrentPosition();
        swingArmRight.setPower(.5);
        swingArmLeft.setPower(.5);

        telemetry.addData("ticks so far",ticksSoFar);
        telemetry.addData("ticks to run",ticksToRun);
        telemetry.update();

        while (ticksSoFar<ticksToRun){
            ticksSoFar = Math.abs(swingArmRight.getCurrentPosition() - startPos);
            telemetry.addData("ticks",ticksSoFar);
            telemetry.update();

            if(ticksSoFar >= TICKS_PER_ROTATION * (25/360)){
                swingArmRight.setPower(.6);
                swingArmLeft.setPower(.6);
            } else if(ticksSoFar >= TICKS_PER_ROTATION * (80/360)) {
                swingArmRight.setPower(.03);
                swingArmLeft.setPower(0.03);
            }
        }
        swingArmRight.setPower(0);
        swingArmLeft.setPower(0);
    }

    public void unSwing() {
        double ticksToRun = TICKS_PER_ROTATION * (112.0 / 360.0);
        int ticksSoFar = 0;
        int startPos = swingArmRight.getCurrentPosition();

        swingArmRight.setPower(-.2);
        swingArmLeft.setPower(-.2);

        telemetry.addData("ticks so far", ticksSoFar);
        telemetry.addData("ticks to run", ticksToRun);
        telemetry.update();

        while (ticksSoFar < ticksToRun) {
            ticksSoFar = Math.abs(swingArmRight.getCurrentPosition() - startPos);
            telemetry.addData("ticks", ticksSoFar);
            telemetry.update();

            if(ticksSoFar >= TICKS_PER_ROTATION * (25.0/360.0)){
                swingArmRight.setPower(.03);
                swingArmLeft.setPower(.03);
            } else if(ticksSoFar >= TICKS_PER_ROTATION * (80.0/360.0)) {
                swingArmRight.setPower(.05);
                swingArmLeft.setPower(.05);
            }
        }
        swingArmRight.setPower(0);
        swingArmLeft.setPower(0);
    }
}
