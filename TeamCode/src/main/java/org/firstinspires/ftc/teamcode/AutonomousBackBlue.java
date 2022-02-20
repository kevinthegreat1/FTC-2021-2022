package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "AutonomousBackBlue", group = "Pushbot")
public class AutonomousBackBlue extends LinearOpMode {

    @Override
    public void runOpMode() {
        /* Declare OpMode members. */
        DcMotor leftFront = hardwareMap.dcMotor.get("leftFront");
        DcMotor rightFront = hardwareMap.dcMotor.get("rightFront");
        DcMotor leftBack = hardwareMap.dcMotor.get("leftBack");
        DcMotor rightBack = hardwareMap.dcMotor.get("rightBack");
        DcMotor intake = hardwareMap.dcMotor.get("intake");
        DcMotor output = hardwareMap.dcMotor.get("output");
        DcMotor duck = hardwareMap.dcMotor.get("duck");

        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.REVERSE);
        output.setDirection(DcMotor.Direction.FORWARD);
        duck.setDirection(DcMotor.Direction.FORWARD);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        leftFront.setPower(-1);
        rightFront.setPower(1);
        leftBack.setPower(-1);
        rightBack.setPower(1);
        sleep(1000);
        leftFront.setPower(1);
        rightFront.setPower(1);
        leftBack.setPower(1);
        rightBack.setPower(1);
        sleep(10000);
    }
}
