package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp
public class second_tele_op extends LinearOpMode{

    @Override
    public void runOpMode() {
        Gyroscope imu = hardwareMap.get(Gyroscope.class, "imu");
        DcMotor l_motor = hardwareMap.get(DcMotor.class, "l_motor");
        DcMotor r_motor = hardwareMap.get(DcMotor.class, "r_motor");
        DcMotorEx arm_motor = hardwareMap.get(DcMotorEx.class, "arm");

        //l_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //r_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        //resets motor encoder
        arm_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //turns motor on
        arm_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //arm encoder constants
        //PID Coefficients for arm motor
        PIDFCoefficients arm_pidf = new PIDFCoefficients(0,0,0,0);
        //sets pid constants for dc motors
        arm_motor.setPIDFCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, arm_pidf);
        //sets arm motor position tolerance, meaning how far off in ticks the position can be
        arm_motor.setTargetPositionTolerance(0);
        //ticks per full rotation of motor
        int ticks = 28;
        //arm positions
        int pos_1 = 0;
        int pos_2 = pos_1 + 48;
        int pos_3 = pos_1 + 96;

        waitForStart();

        while (opModeIsActive()) {
            //gets joystick values from game pad 1
            double rx = gamepad1.right_stick_x;
            double ly = -gamepad1.left_stick_y;
            //sets drive motor speeds
            r_motor.setPower(ly-rx);
            l_motor.setPower(ly+rx);

            //gets current position of arm motor using encoder
            double arm_pos = arm_motor.getCurrentPosition();
            //gets number of arm motor rotations
            double arm_rotations = arm_pos/ticks;


            //tels motor to run to positions
            if (gamepad1.a) {
                arm_motor.setTargetPosition(pos_1);
            } else if(gamepad1.b) {
                arm_motor.setTargetPosition(pos_2);
            } else if(gamepad1.x) {
                arm_motor.setTargetPosition(pos_3);
            }



        }
    }
}
