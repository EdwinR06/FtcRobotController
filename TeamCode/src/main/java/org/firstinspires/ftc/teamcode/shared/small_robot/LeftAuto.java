package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Left Auto", group="Linear Opmode")
public class LeftAuto extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        waitForStart();
        runtime.reset();
        Robot robot = new Robot(hardwareMap, telemetry);

        robot.grip();
        sleep(200);
        robot.driveStraight(19.25);

        robot.driveTurn(8);
        robot.driveStraight(12);
        robot.slideRaise();
        sleep(2350);
        robot.driveTurn(2.25);
        robot.driveStraight(1);
        robot.slideLower();
        sleep(500);
        robot.unGrip();
        sleep(800);
        robot.driveStraight(-4);
        robot.slideLower();
        sleep(500);

    }
}

