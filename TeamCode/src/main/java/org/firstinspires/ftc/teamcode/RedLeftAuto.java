package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a four wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
@Autonomous(name="red left", group="Iterative Opmode")
//@Disabled
public class RedLeftAuto extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode(){

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        waitForStart();
        runtime.reset();
        Robot robot=new Robot(hardwareMap, telemetry);

        /*while(opModeIsActive()) {
            telemetry.addData("Left Front Encoder", leftFront.getCurrentPosition());
            telemetry.update();
        }*/
        /*
        robot.driveStraight(5);
        robot.pointTurn(90, false);
        robot.driveStraight(23);
        robot.pointTurn(45, false);
        robot.driveStraight(2);
        robot.spinRightAuto();
        sleep(2500);
        robot.driveStraight(-2);
        robot.pointTurn(130, true);
        robot.driveStraight(23);
        */
        robot.driveStraight(-6);
        robot.pointTurn(28, true);
        robot.driveStraight(-29);
        robot.pushBlockForward();
        sleep(2500);
        robot.resetBumper();
        sleep(250);
        robot.driveStraight(6);
        robot.pointTurn(30, true);
        robot.driveStraight(43.25);
        robot.spinRightAuto();
        sleep(3000);
        robot.pointTurn(125, true);
        robot.driveStraight(23.5);

    }
}
