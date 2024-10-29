package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp

public class spider_drive extends LinearOpMode {
    double y_left;
    double x_left;
    double y_right;
    double x_right;
    double Yaw;
    double Pitch;
    double Roll;
    YawPitchRollAngles robotOrientation;
    double rotx;
    double roty;
    double denominator;
    // todo: write your code here




    @Override
    public void runOpMode() {

        DcMotor fr = hardwareMap.get(DcMotor.class, "fr");
        DcMotor br = hardwareMap.get(DcMotor.class, "br");
        DcMotor bl = hardwareMap.get(DcMotor.class, "bl");
        DcMotor fl = hardwareMap.get(DcMotor.class, "fl");
        IMU imu = hardwareMap.get(IMU.class, "imu");

        br.setDirection(DcMotorSimple.Direction.REVERSE);
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        // Initialize IMU directly
        imu.initialize(
                new IMU.Parameters(
                        new RevHubOrientationOnRobot(
                                new Orientation(
                                        AxesReference.INTRINSIC,
                                        AxesOrder.ZYX,
                                        AngleUnit.DEGREES,
                                        90,
                                        0,
                                        0,
                                        0  // acquisitionTime, not used
                                )
                        )
                )
        );

        telemetry.addData("IMU Status", "Initialized");
        telemetry.update();

        // Create an object to receive the IMU angles
        YawPitchRollAngles robotOrientation;
        robotOrientation = imu.getRobotYawPitchRollAngles();


        while (opModeIsActive()) {
            // Create an object to receive the IMU angles
            robotOrientation = imu.getRobotYawPitchRollAngles();

            // Now use these simple methods to extract each angle
            // (Java type double) from the object you just created:
            Yaw   = robotOrientation.getYaw(AngleUnit.RADIANS);
            Pitch = robotOrientation.getPitch(AngleUnit.DEGREES);
            Roll  = robotOrientation.getRoll(AngleUnit.DEGREES);

            y_left = -gamepad1.left_stick_y;
            x_left = gamepad1.left_stick_x;
            y_right = -gamepad1.right_stick_y;
            x_right = gamepad1.right_stick_x;

            if (gamepad1.start) {
                imu.resetYaw();
            }

            rotx = x_right*Math.cos(-Yaw) - y_right*Math.sin(-Yaw);
            roty = x_right*Math.sin(-Yaw) + y_right*Math.cos(-Yaw);
            denominator = Math.max(Math.abs(rotx) + Math.abs(roty),1);

            fr.setPower(y_left-x_left);
            br.setPower(y_left-x_left);
            bl.setPower(y_left+x_left);
            fl.setPower(y_left+x_left);
            if (roty != 0 || rotx != 0) {
                fr.setPower((roty - rotx)/denominator);
                br.setPower((roty + rotx)/denominator);
                bl.setPower((roty - rotx)/denominator);
                fl.setPower((roty + rotx)/denominator);
            }
            if (y_left == 0 && x_left == 0 && x_right == 0 && y_right ==0) {
                fr.setPower(0);
                br.setPower(0);
                bl.setPower(0);
                fl.setPower(0);
            }
        }
    }
}