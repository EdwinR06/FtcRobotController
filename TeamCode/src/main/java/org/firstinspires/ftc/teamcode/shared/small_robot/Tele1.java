package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Small Tele 1", group="Iterative Opmode")
public class Tele1 extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private Robot robot;
    private static final double Ticks_Per_Inch=39.6;
    //private Servo claw = null;

    //double clawPosition = CLAW_HOME;
    //final double CLAW_SPEED = 0.25;

    private final static double CLAW_HOME = 0;
    private final static double CLAW_MIN_RANGE = -1;
    private final static double CLAW_MAX_RANGE = 5;

    @Override
    public void init(){
        robot=new Robot(hardwareMap, telemetry);
    }

    @Override
    public void init_loop(){
    }

    @Override
    public void loop() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //claw = (Servo) hardwareMap.get(Servo.class, "claw_servo");

        runtime.reset();

        double drive = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;
        boolean slideup = gamepad1.a;
        boolean slidedown = gamepad1.b;
        boolean gripper = gamepad1.x;
        boolean ungripper = gamepad1.y;

        if (gripper) {
            robot.grip();
        } else if (ungripper) {
            robot.unGrip();
        }

        robot.drive(drive, turn, strafe);

        if(slideup){
            robot.slideRaise();
            /*try {
                robot.slideRaise();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

        if(slidedown){
            robot.slideLower();
            /*try {
                robot.slideLower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }

