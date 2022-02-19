package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "DiagonalDrive", group = "Run")
public class DiagonalDrive extends LinearOpMode {

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

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            double rightStick_Y = -gamepad1.right_stick_y;
            double rightStick_X = -gamepad1.right_stick_x;
            double leftStick_Y = -gamepad1.left_stick_y;
            double leftStick_X = -gamepad1.left_stick_x;
            boolean rightStick = gamepad1.right_stick_button;
            boolean leftStick = gamepad1.left_stick_button;
            float rightTrigger = gamepad1.right_trigger;
            boolean rightBumper = gamepad1.right_bumper;
            float leftTrigger = gamepad1.left_trigger;
            boolean leftBumper = gamepad1.left_bumper;
            boolean button_y = gamepad1.y;
            boolean button_a = gamepad1.a;
            boolean button_x = gamepad1.x;
            boolean button_b = gamepad1.b;
            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            final double v1 = r * Math.cos(robotAngle) + rightStick_X;
            final double v2 = r * Math.sin(robotAngle) - rightStick_X;
            final double v3 = r * Math.sin(robotAngle) + rightStick_X;
            final double v4 = r * Math.cos(robotAngle) - rightStick_X;

            final double max = 1 / Math.max(Math.max(Math.abs(v1), Math.abs(v2)), Math.max(Math.abs(v3), Math.abs(v4)));

            leftFront.setPower(v3 * max);
            rightFront.setPower(v4 * max);
            leftBack.setPower(v1 * max);
            rightBack.setPower(v2 * max);

            if (button_x) {
                duck.setPower(1);
            } else if (button_b) {
                duck.setPower(-1);
            } else {
                duck.setPower(0);
            }

            if (button_a) {
                output.setPower(1);
            } else if (button_y) {
                output.setPower(-1);
            } else {
                output.setPower(0);
            }

            if (rightTrigger > 0) {
                intake.setPower(1);
            } else if (leftTrigger > 0) {
                intake.setPower(-1);
            } else {
                intake.setPower(0);
            }
        }
    }
}
