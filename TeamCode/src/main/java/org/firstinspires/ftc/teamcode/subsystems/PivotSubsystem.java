package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Constants;

public class PivotSubsystem {
    //pivot motors
    DcMotor pivot_1;
    DcMotor pivot_2;

    public PivotSubsystem(HardwareMap hardwareMap, OpMode opMode) {
        //reference pivot motors
        pivot_1 = hardwareMap.get(DcMotor.class, "pivot1");
        pivot_2 = hardwareMap.get(DcMotor.class, "pivot2");

        //reverse motors
        //pivot_1.setDirection(DcMotorSimple.Direction.REVERSE);
        //pivot_2.setDirection(DcMotorSimple.Direction.REVERSE);

        //initializing the pivot motors
        //resets encoder to 0
        pivot_1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pivot_2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //sets the pivot target position to 0
        pivot_1.setTargetPosition(Constants.pivot_pos_1);
        pivot_2.setTargetPosition(Constants.pivot_pos_1);

        //sets the pivot motors to be a run to position mode
        pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    //code to make the pivot move to positions
    public void to_1() {
        pivot_1.setTargetPosition(Constants.pivot_pos_1);
        pivot_2.setTargetPosition(Constants.pivot_pos_1);
        pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void to_2() {
        pivot_1.setTargetPosition(Constants.pivot_pos_2);
        pivot_2.setTargetPosition(Constants.pivot_pos_2);
        pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void to_3() {
        pivot_1.setTargetPosition(Constants.pivot_pos_3);
        pivot_2.setTargetPosition(Constants.pivot_pos_3);
        pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void to_4() {
        pivot_1.setTargetPosition(Constants.pivot_pos_4);
        pivot_2.setTargetPosition(Constants.pivot_pos_4);
        pivot_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivot_2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    //returns current position of pivot
    public int current_position1() {
        return pivot_1.getCurrentPosition();
    }
    public int current_position2() {
        return pivot_2.getCurrentPosition();
    }
}

