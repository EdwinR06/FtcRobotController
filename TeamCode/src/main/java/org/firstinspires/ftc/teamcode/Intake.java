package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {

    private DcMotor intakeMotor = null;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");

        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    void intake(double power) {
        intakeMotor.setPower(power);
    }

    void deposit(double power) {
        intakeMotor.setPower(-power);
    }

    void intakeAuto() {
        intakeMotor.setPower(1);
    }

    void depositAuto(){
        intakeMotor.setPower(-1);
    }

}
