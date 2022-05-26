package org.firstinspires.ftc.teamcode.shared;

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
@Autonomous(name="blue right", group="Iterative Opmode")
//@Disabled
public class BlueRightAuto extends LinearOpMode {
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
        robot.driveStraight(3);
        robot.pointTurn(92, true);
        robot.driveStraight(23);
        robot.spinLeftAuto();
        sleep(2500);
        robot.pointTurn(75, false);
        robot.driveStraight(23);
        */
        robot.driveStraight(-6);
        robot.pointTurn(28, false);
        robot.driveStraight(-29);
        robot.pushBlockForward();
        sleep(2500);
        robot.resetBumper();
        sleep(250);
        robot.driveStraight(6);
        robot.pointTurn(30, false);
        robot.driveStraight(43.25);
        robot.spinLeftAuto();
        sleep(3000);
        robot.pointTurn(125, false);
        robot.driveStraight(23.5);
    }
}
