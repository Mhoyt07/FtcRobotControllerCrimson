package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class ArmSubsystem {
    DcMotor arm;
    OpMode opMode;
    public ArmSubsystem(HardwareMap hardwareMap, OpMode opMode) {
        this.opMode = opMode;
        //arm motor
        DcMotor arm = hardwareMap.get(DcMotor.class, "arm");

        //reverse motor direction
        //arm.setDirection(DcMotorSimple.Direction.REVERSE);

        //resets encoder
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //sets the initial target position to 0
        arm.setTargetPosition(Constants.arm_pos_1);
        //sets the run mode to be run to position
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    //functions that make arm move to positions
    public void run_to_1() {
        arm.setTargetPosition(Constants.arm_pos_1);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void run_to_2() {
        arm.setTargetPosition(Constants.arm_pos_2);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void run_to_3() {
        arm.setTargetPosition(Constants.arm_pos_3);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void run_to_4() {
        arm.setTargetPosition(Constants.arm_pos_4);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void run_to_5() {
        arm.setTargetPosition(Constants.arm_pos_5);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public int current_position() {
        return arm.getCurrentPosition();
    }
}
