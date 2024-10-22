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
    private DcMotor arm_motor;

    //arm encoder values
    //pulses per rotation of motor
    double ppr;
    //diameter of spool
    double diameter;
    //circumference of spool
    double circ;
    //arm position value
    int arm_pos;
    //revolutions of spool
    double revolutions;
    //angle of spool
    double angle;
    //distance of extended string
    double distance;



    //Joystick values
    double rx;
    double ly;


    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        l_motor = hardwareMap.get(DcMotor.class, "l_motor:");
        r_motor = hardwareMap.get(DcMotor.class, "r_motor");
        arm_motor = hardwareMap.get(DcMotor.class, "arm_motor");

        //l_motor.setDirection(DcMotorSimple.Direction.Reverse);
        //r_motor.setDirection(DcMotorSimple.Direction.Reverse);

        arm_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Reset the motor encoder
        arm_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // Turn the motor back on when we are done

        //arm encoder values
        //pulses per rotation of motor
        ppr = 28;
        //diameter of spool
        diameter = 0;
        //circumference of spool
        circ = Math.PI * diameter;

        waitForStart();

        while (opModeIsActive()) {
            //gets x and y stick values from controller
            rx = gamepad1.right_stick_x;
            ly = -gamepad1.left_stick_y;
            //gets encoder value for current position of arm encoder
            arm_pos = arm_motor.getCurrentPosition();
            //revolutions of spool
            revolutions = arm_pos/ppr;

            //angle of spool starting form 0 degrees
            angle = revolutions * 360;
            distance = circ * revolutions;

            //sets motor speeds for arcade driving using stick values
            l_motor.setPower(ly + rx);
            r_motor.setPower(ly - rx);
        }
    }
}
