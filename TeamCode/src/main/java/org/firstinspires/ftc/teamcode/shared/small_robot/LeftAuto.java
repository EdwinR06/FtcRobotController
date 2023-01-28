package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Left Auto", group="Linear Opmode")
public class LeftAuto extends LinearOpMode {
    private ElapsedTime runtime=new ElapsedTime();

    @Override
    public void runOpMode() {
        waitForStart();
        runtime.reset();
        Robot robot=new Robot(hardwareMap, telemetry);

        robot.driveStraight(18);
        robot.driveTurn(1);
        if(robot.getRed() > 250) {
            robot.driveStrafe(23);
        } else if(robot.getGreen() > 250){
            robot.driveStraight(3);
        } else if(robot.getBlue() > 250) {
            robot.driveStrafe(-23);
        }

    }
}
