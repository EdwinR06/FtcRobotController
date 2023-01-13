package org.firstinspires.ftc.teamcode.shared.small_robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Small Tele 1", group="Iterative Opmode")
public class Tele1 extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private Robot robot;
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
    public void init_loop(){}

    @Override
    public void loop() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //claw = (Servo) hardwareMap.get(Servo.class, "claw_servo");

        runtime.reset();

        double drive = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn  =  gamepad1.right_stick_x;
        boolean slideup = gamepad1.a;
        boolean slidedown = gamepad1.b;
        boolean gripper = gamepad1.x;
        boolean ungripper = gamepad1.y;

        if(gripper) {
            robot.grip();
        } else if(ungripper) {
            robot.unGrip();
        }


        robot.drive(drive, turn, strafe);

        /*if(gamepad1.b)
            clawPosition += CLAW_SPEED;
        else if(gamepad1.y)
            clawPosition -= CLAW_SPEED;

        clawPosition = Range.clip(clawPosition, CLAW_MIN_RANGE, CLAW_MAX_RANGE);
        claw.setPosition(clawPosition);*/

        if(slideup){
            try {
                robot.slideUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(slidedown){
            try {
                robot.slideDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //telemetry.addData("claw","%2f", clawPosition);
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();

    }
    @Override
    public void stop(){}
}
