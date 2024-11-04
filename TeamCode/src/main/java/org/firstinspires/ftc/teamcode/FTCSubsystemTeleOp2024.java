package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PivotSubsystem;

@TeleOp
public class FTCSubsystemTeleOp2024 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {


        //init drive subsystem
        DriveSubsystem dt = new DriveSubsystem(hardwareMap);

        //init pivot subsystem
        PivotSubsystem pivot_subsystem = new PivotSubsystem(hardwareMap, this);

        waitForStart();
        while (opModeIsActive()) {
            //drivetrian stuff
            dt.arcade_drive(gamepad1.right_stick_x, gamepad1.left_stick_y);

            //pivot stuff
            if (gamepad2.b) {
                pivot_subsystem.to_1();
            } else if (gamepad2.y) {
                pivot_subsystem.to_2();
            } else if (gamepad2.x) {
                pivot_subsystem.to_3();
            } else if (gamepad2.a) {
                pivot_subsystem.to_4();
            }
        }
    }
}
