package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Left Auto", group="Linear Opmode")
public class LeftAuto extends LinearOpMode {
    private ElapsedTime runtime=new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        runtime.reset();
        Robot robot=new Robot(hardwareMap, telemetry);

        robot.driveStraight(18);
        if(robot.getRed() > 300) {
            robot.grip();
            robot.slideUp();
            robot.driveStraight(.5);
            robot.unGrip();
            robot.slideDown();
            robot.driveStrafe(23);
        } else if(robot.getGreen() > 300){
            robot.grip();
            robot.slideUp();
            robot.driveStraight(.5);
            robot.unGrip();
            robot.slideDown();
            robot.driveStraight(-1);
        } else if(robot.getBlue() > 300) {
            robot.grip();
            robot.slideUp();
            robot.driveStraight(.5);
            robot.unGrip();
            robot.slideDown();
            robot.driveStrafe(-23);
        }
    }
}
