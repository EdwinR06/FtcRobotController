package org.firstinspires.ftc.teamcode.shared;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FTCUtil {
    public static HardwareMap hardwareMap;
    public static Telemetry telemetry;
    public static GridLogger gridLogger;
    private static OpMode opMode;
    private static LinearOpMode linearOpMode;

    public static void setOpMode(OpMode opMode){
        FTCUtil.opMode = opMode;
        FTCUtil.telemetry = opMode.telemetry;
        FTCUtil.hardwareMap = opMode.hardwareMap;

        if(opMode instanceof LinearOpMode){
            linearOpMode = (LinearOpMode)opMode;
        }
    }

    public static OpMode getOpMode() {
        return opMode;
    }

    public static boolean isOpModeActive(){
        if (linearOpMode != null){
            return linearOpMode.opModeIsActive();
        } else return true;
    }
}
