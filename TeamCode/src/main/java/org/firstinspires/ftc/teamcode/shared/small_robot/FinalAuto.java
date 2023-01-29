package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Final Auto", group="Linear Opmode")
public class FinalAuto extends LinearOpMode  {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        waitForStart();
        runtime.reset();
        Robot robot = new Robot(hardwareMap, telemetry);

        robot.grip();
        sleep(200);
        robot.driveStraight(23);
        robot.unGrip();
        sleep(200);


    }
}
