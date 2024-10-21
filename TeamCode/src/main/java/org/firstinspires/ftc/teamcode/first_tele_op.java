package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.IMU;

@TeleOp
public class first_tele_op extends LinearOpMode{
    private Gyroscope imu;
    private DcMotor l_motor;
    private DcMotor r_motor;
    double rx;
    double ly;


    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        l_motor = hardwareMap.get(DcMotor.class, "l_motor:");
        r_motor = hardwareMap.get(DcMotor.class, "r_motor");

        //l_motor.setDirection(DcMotorSimple.Direction.Reverse);
        //r_motor.setDirection(DcMotorSimple.Direction.Reverse);


        while (opModeIsActive()) {
            rx = gamepad1.right_stick_x;
            ly = -gamepad1.left_stick_y;

            l_motor.setPower(ly + rx);
            r_motor.setPower(ly - rx);
        }
    }
}
