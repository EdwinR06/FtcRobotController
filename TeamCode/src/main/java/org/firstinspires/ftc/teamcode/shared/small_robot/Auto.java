package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto", group="Linear Opmode")
public class Auto extends LinearOpMode {
    private ElapsedTime runtime=new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        runtime.reset();
        Robot robot=new Robot(hardwareMap, telemetry);

        robot.driveStraight(30);

        robot.driveStraight(-30);

        robot.driveTurn(30);

        robot.driveTurn(-30);

        robot.driveStrafe(10);

        robot.driveStrafe(-10);

        robot.linear(10);
    }
}
