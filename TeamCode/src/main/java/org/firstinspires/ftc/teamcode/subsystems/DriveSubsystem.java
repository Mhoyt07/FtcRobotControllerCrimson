package org.firstinspires.ftc.teamcode.subsystems;

import android.view.DragEvent;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem {
    DcMotorEx back_right;
    DcMotorEx back_left;
    public DriveSubsystem(HardwareMap hardwareMap) {
        //reference drive motors
        back_right = hardwareMap.get(DcMotorEx.class, "br");
        back_left = hardwareMap.get(DcMotorEx.class, "bl");

        //reverse motors
        //back_right.setDirection(DcMotorSimple.Direction.REVERSE);
        //back_left.setDirection(DcMotorSimple.Direction.REVERSE);



    }

    public void arcade_drive(double rx, double ly) {
        back_right.setPower(ly - rx);
        back_left.setPower(ly + rx);
    }
}
