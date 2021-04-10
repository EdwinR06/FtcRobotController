package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FTCUtil {
    public static HardwareMap hardwareMap;
    public static Telemetry telemetry;
    public static GridLogger gridLogger;
    private static LinearOpMode opMode;

    public static void setOpMode(LinearOpMode opMode){
        FTCUtil.opMode = opMode;
        FTCUtil.telemetry = opMode.telemetry;
        FTCUtil.hardwareMap = opMode.hardwareMap;
    }

    public static LinearOpMode getOpMode() {
        return opMode;
    }
}
