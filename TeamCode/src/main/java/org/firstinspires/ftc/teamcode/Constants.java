package org.firstinspires.ftc.teamcode;

public class Constants {
    //arm constants
    //pivot constants
    //ticks per full rotation
    public static final int pivot_ticks = 288;
    //pivot positions
    public static final int pivot_pos_1 = 0;
    public static final int pivot_pos_2 = pivot_pos_1 + pivot_ticks/4;
    public static final int pivot_pos_3 = pivot_pos_1 + pivot_ticks/2;
    public static final int pivot_pos_4 = pivot_pos_1 + pivot_ticks*3/4;

    //arm constants
    //ticks per full rotation
    public static final double arm_ticks = 751.8;
    //arm positions
    public static final int arm_pos_1 = 0;
    public static final int arm_pos_2 = (int) (arm_pos_1 + arm_ticks*2);
    public static final int arm_pos_3 = (int) (arm_pos_1 + arm_ticks*3);
    public static final int arm_pos_4 = (int) (arm_pos_1 + arm_ticks*4);
    public static final int arm_pos_5 = (int) (arm_pos_1 + arm_ticks*5);
}
