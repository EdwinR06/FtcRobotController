package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.TimeUnit;

public class LinearSlide {
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private DcMotor linearSlide = null;
    private static final double Ticks_Per_Inch=39.6;

    public LinearSlide(HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap=hardwareMap;
        this.telemetry=telemetry;

        linearSlide = hardwareMap.get(DcMotor.class, "linear_slide");

        linearSlide.setDirection(DcMotor.Direction.FORWARD);

        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void slideUp() throws InterruptedException {
        double ticksToRun=25*Ticks_Per_Inch;

        int tickSoFar=0;
        int startPosition=linearSlide.getCurrentPosition();

        linearSlide.setPower(0.9);

        while (tickSoFar<ticksToRun){
            tickSoFar=Math.abs(linearSlide.getCurrentPosition()-startPosition);
        }
        linearSlide.setPower(0.36);
        TimeUnit.MILLISECONDS.sleep(1000);
        slideDown();
    }
    public void slideDown() throws InterruptedException {
        double ticksToRun=25*Ticks_Per_Inch;

        int tickSoFar=0;
        int startPosition=linearSlide.getCurrentPosition();

        linearSlide.setPower(-0.9);

        while (tickSoFar<ticksToRun){
            tickSoFar=Math.abs(linearSlide.getCurrentPosition()-startPosition);
        }
        linearSlide.setPower(-0.36);
        TimeUnit.MILLISECONDS.sleep(1000);
        linearSlide.setPower(0);
    }
}
