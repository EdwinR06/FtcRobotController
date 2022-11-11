package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SpinningArm {
    private DcMotor spinningArm = null;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private static final double TICKS_PER_INCH=39.6;
    private static final double ROTATION_DISTANCE=10;

    public SpinningArm(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        spinningArm = hardwareMap.get(DcMotor.class, "spinning_arm_motor");

        spinningArm.setDirection(DcMotor.Direction.FORWARD);
    }

    /*void spin(){

        double ticksToRun=Math.abs(ROTATION_DISTANCE)*TICKS_PER_INCH;
        int ticksSoFar = 0;
        int startPos=spinningArm.getCurrentPosition();
        spinningArm.setPower(0.2);
        while (ticksSoFar<ticksToRun){
            ticksSoFar = Math.abs(spinningArm.getCurrentPosition() - startPos);
        }
        spinningArm.setPower(0);

    }*/

    void spinLeft(boolean spin){
        if(spin) {
            spinningArm.setPower(.7);
        }
        spinningArm.setPower(0);
    }
    void spinRight(boolean spin) {
        if (spin) {
            spinningArm.setPower(-.7);
        }
        spinningArm.setPower(0);
    }

    void spinLeftAuto(){
        spinningArm.setPower(.6);

    }

    void spinRightAuto(){
        spinningArm.setPower(-.6);
    }



}

