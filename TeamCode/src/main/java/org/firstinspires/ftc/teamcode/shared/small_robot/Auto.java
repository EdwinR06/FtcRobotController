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
        int red;
        int blue;
        int green;
        while(opModeIsActive()) {
            red = robot.getRed();
            blue = robot.getBlue();
            green = robot.getGreen();
            if(red > 150 && !(blue >= 125) && !(green >= 125)) {
                robot.driveStraight(2);
                robot.driveTurn(-18);
                robot.driveStraight(23);
                break;
            } else if (blue > 150 && !(green >= 125) && !(red >= 125)) {
                robot.driveStraight(2);
                robot.driveTurn(18);
                robot.driveStraight(23);
                break;
            } else if(green > 150) {
                robot.driveStraight(5);
                break;
            }
        }
    }
}
