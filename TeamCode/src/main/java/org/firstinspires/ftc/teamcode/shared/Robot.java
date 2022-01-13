package org.firstinspires.ftc.teamcode.shared;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    private Chassis chassis;
    private Telemetry telemetry;

    public Robot(Telemetry telemetry) {
        this.telemetry = telemetry;
        chassis = new Chassis(telemetry);
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void driveStraight(double distance, double power){
        chassis.driveStraight(distance, power);
    }

    public void turnAuto(double degree, double power){
        chassis.turnAuto(degree, power);
    }

    public void drive(double drive, double turn, double strafe){
        chassis.drive(drive, turn, strafe);
    }


}
