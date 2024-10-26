package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class teleop_drive extends LinearOpMode{


    @Override
    public void runOpMode() {
        DcMotor l_motor = hardwareMap.get(DcMotor.class, "l_motor");
        DcMotor r_motor = hardwareMap.get(DcMotor.class, "r_motor");

        //l_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //r_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            //getting joystick values for motor speeds
            //left y value
            double ly = gamepad1.left_stick_y;
            //right x value
            double rx = gamepad1.right_stick_x;

            //set motor speeds with joystick values
            l_motor.setPower(ly + rx);
            r_motor.setPower(ly - rx);
        }
    }
}
