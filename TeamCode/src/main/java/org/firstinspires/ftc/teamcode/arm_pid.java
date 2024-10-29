package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class arm_pid extends LinearOpMode {

    @Override
    public void runOpMode() {
        //define motor
        DcMotor arm_motor = hardwareMap.get(DcMotor.class, "arm");

        //reset arm motor
        arm_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //puts the arm in the run to position mode
        arm_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //arm constants
        //arm tick range
        int range = 100;
        //arm set positions
        int pos_1 = 0;
        int pos_2 = pos_1 + 25;
        int pos_3 = pos_1 + 50;
        int pos_4 = pos_1 + 75;
        int pos_5 = pos_1 + 100;

        waitForStart();
        while (opModeIsActive()) {
            //when a button is pressed
            if (gamepad1.a) {
                arm_motor.setTargetPosition(pos_1);
            } else if (gamepad1.left_trigger >= 0.5) {
                arm_motor.setTargetPosition(pos_2);
            } else if (gamepad1.left_bumper) {
                arm_motor.setTargetPosition(pos_3);
            } else if (gamepad1.right_bumper) {
                arm_motor.setTargetPosition(pos_4);
            } else if (gamepad1.right_trigger >= 0.5) {
                arm_motor.setTargetPosition(pos_5);
            }

            //gets current arm position
            int arm_pos = arm_motor.getCurrentPosition();
            telemetry.addData("Arm Motor Current Position", arm_pos);
            telemetry.update();
        }
    }
}
