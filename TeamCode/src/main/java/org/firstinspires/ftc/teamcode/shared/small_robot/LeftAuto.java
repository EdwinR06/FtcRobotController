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

        robot.unGrip();
        sleep(1000);
        robot.driveStraight(19);

        robot.grip();
        sleep(1000);
        robot.driveTurn(6);
        robot.driveStraight(12);
        robot.slideRaise();
        sleep(2350);
        robot.unGrip();
        sleep(800);
        robot.slideLower();
        sleep(1000);
    }
}

