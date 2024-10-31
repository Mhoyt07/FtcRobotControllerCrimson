package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class FTCRobot2024 extends LinearOpMode {

    public void runOpMode() {
        //drivetrain motors
        DcMotor bl = hardwareMap.get(DcMotor.class, "bl");
        DcMotor br = hardwareMap.get(DcMotor.class, "br");
        //pivot motors
        DcMotor pivot_1 = hardwareMap.get(DcMotor.class, "pivot1");
        DcMotor pivot_2 = hardwareMap.get(DcMotor.class, "pivot2");
        //arm motor
        DcMotor arm = hardwareMap.get(DcMotor.class, "arm");
        //clamp servo
        Servo claw = hardwareMap.get(Servo.class, "claw");

        //resets all motor encoders
        pivot_1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pivot_2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        //sets motors to pid run to position mode
        pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //motor direction switching
        //bl.setDirection(DcMotorSimple.Direction.REVERSE);
        //br.setDirection(DcMotorSimple.Direction.REVERSE);
        //pivot_1.setDirection(DcMotorSimple.Direction.REVERSE);
        //pivot_2.setDirection(DcMotorSimple.Direction.REVERSE);
        //arm.setDirection(DcMotorSimple.Direction.REVERSE);

        //pivot constants
        //ticks per full rotation
        int pivot_ticks = 288;
        //pivot positions
        int pivot_pos_1 = 0;
        int pivot_pos_2 = pivot_pos_1 + pivot_ticks/4;
        int pivot_pos_3 = pivot_pos_1 + pivot_ticks/2;
        int pivot_pos_4 = pivot_pos_1 + pivot_ticks*3/4;

        //arm constants
        //ticks per full rotation
        int arm_ticks = 28;
        //arm positions
        int arm_pos_1 = 0;
        int arm_pos_2 = arm_pos_1 + arm_ticks*2;
        int arm_pos_3 = arm_pos_1 + arm_ticks*3;
        int arm_pos_4 = arm_pos_1 + arm_ticks*4;
        int arm_pos_5 = arm_pos_1 + arm_ticks*5;

        //claw constants
        //sets the range of the claw
        claw.scaleRange(0.0, 1.0);
        //claw positions
        double open_position = 0.0;
        double close_position = 0.5;





        waitForStart();
        while (opModeIsActive()) {
            //gets joystick values
            //left joystick y value
            double ly = -gamepad1.left_stick_y;
            //right joystick x value
            double rx = gamepad1.right_stick_x;

            //gives power to drive motors in arcade drive
            bl.setPower(ly-rx);
            br.setPower(ly+rx);

            //pivot  code
            //gets current pivot position
            int pivot1_pos = pivot_1.getCurrentPosition();
            int pivot2_pos = pivot_2.getCurrentPosition();
            //pivot set position
            if (gamepad2.b) {
                pivot_1.setTargetPosition(pivot_pos_1);
                pivot_2.setTargetPosition(pivot_pos_1);
            } else if (gamepad2.y) {
                pivot_1.setTargetPosition(pivot_pos_2);
                pivot_2.setTargetPosition(pivot_pos_2);
            } else if (gamepad2.x) {
                pivot_1.setTargetPosition(pivot_pos_3);
                pivot_2.setTargetPosition(pivot_pos_3);
            } else if (gamepad2.a) {
                pivot_1.setTargetPosition(pivot_pos_4);
                pivot_2.setTargetPosition(pivot_pos_4);
            }

            //arm code
            //gets current arm position
            int arm_pos = arm.getCurrentPosition();
            //arm set position
            if (gamepad2.left_bumper) {
                arm.setTargetPosition(arm_pos_1);
            } else if (gamepad2.dpad_right) {
                arm.setTargetPosition(arm_pos_2);
            } else if (gamepad2.dpad_up) {
                arm.setTargetPosition(arm_pos_3);
            } else if (gamepad2.dpad_left) {
                arm.setTargetPosition(arm_pos_4);
            } else if (gamepad2.dpad_down) {
                arm.setTargetPosition(arm_pos_5);
            }

            //claw code
            if (gamepad2.right_bumper) {
                claw.setPosition(close_position);
            } else if (gamepad2.right_trigger >= 0.5) {
                claw.setPosition(open_position);
            }

        }
    }
}
