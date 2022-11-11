package org.firstinspires.ftc.teamcode.shared.swing_arm_robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SwingArm {
    private DcMotor swingArm = null;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private static final double TICKS_PER_INCH=39.6;
    private static final double ROTATION_DISTANCE=10;

    public SwingArm(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        swingArm = hardwareMap.get(DcMotor.class, "spinning_arm_motor");

        swingArm.setDirection(DcMotor.Direction.FORWARD);
    }

    public void swing() {
        swingArm.setPower(.2);
    }

    public void unSwing() {
        swingArm.setPower(-.2);
    }
}
