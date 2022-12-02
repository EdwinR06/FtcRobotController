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


        swingArmRight.setDirection(DcMotor.Direction.FORWARD);
        swingArmLeft.setDirection(DcMotor.Direction.FORWARD);

    }

    public void swing() {
        double ticksToRun = TICKS_PER_ROTATION * (102/360);
        int ticksSoFar = 0;
        int startPos = swingArmRight.getCurrentPosition();
        swingArmRight.setPower(1);
        swingArmLeft.setPower(1);

        while (ticksSoFar<ticksToRun){
            ticksSoFar = Math.abs(swingArmRight.getCurrentPosition() - startPos);
            if(ticksSoFar >= TICKS_PER_ROTATION * (25/360)){
                swingArmRight.setPower(.75);
                swingArmLeft.setPower(.75);
            } else if(ticksSoFar >= TICKS_PER_ROTATION * (80/360)) {
                swingArmRight.setPower(.6);
                swingArmLeft.setPower(.6);
            }
        }
        swingArmRight.setPower(0);
        swingArmLeft.setPower(0);
    }

    public void unSwing() {
        swingArmRight.setPower(-.2);
        swingArmLeft.setPower(-.2);
    }
}
