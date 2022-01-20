package view;

import service.BranchService;

import java.sql.SQLException;
import java.util.Scanner;

public class BossPanel {


    private static Graphics.foregroundColor foregroundColor = new Graphics.foregroundColor();
    private static Graphics.backgroundColor backgroundColor = new Graphics.backgroundColor();
    private static Scanner input = new Scanner(System.in);
    private static BranchService branch = new BranchService();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        bossPanel();
    }

    static void bossPanel() throws SQLException, ClassNotFoundException {
        System.out.println("--------------------------------");
        System.out.println(foregroundColor.CYAN_COLOR_CODE+"    Welcome To Boss Panel   "+foregroundColor.RESET_COLOR_CODE);
        while(true){
            System.out.println("--------------------------------");
            System.out.println(foregroundColor.MAGENTA_COLOR_CODE+
                    "1- Create New Branch " +
                    "\n2- Show Branches " +
                    "\n3- Search Branch Information " +
                    "\n4- Delete Branch " +
                    "\n5- Update Branch " +
                    "\n6- Exit "
                    + foregroundColor.RESET_COLOR_CODE);
            System.out.println("--------------------------------");
            System.out.println(foregroundColor.RED_COLOR_CODE+
                    "Enter your desired number "+foregroundColor.RESET_COLOR_CODE);
            System.out.println("--------------------------------");
            int num = input.nextInt();
            System.out.println("--------------------------------");

            if (num==1){
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "Please enter bank name : " + foregroundColor.RESET_COLOR_CODE);
                String inputStr1 = input.next();
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "Please enter address : " + foregroundColor.RESET_COLOR_CODE);
                String inputStr2 = input.next();
                branch.add(inputStr1,inputStr2);
            }
            else if (num==2){
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "Please enter bank name : " + foregroundColor.RESET_COLOR_CODE);
                String inputStr1 = input.next();
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "The branches are : " + foregroundColor.RESET_COLOR_CODE);
                branch.findAll(inputStr1);
            }
            else if (num==3){
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "Please search by branch id : " + foregroundColor.RESET_COLOR_CODE);
                int inputStr2 = input.nextInt();
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "Your specific branch information is : " + foregroundColor.RESET_COLOR_CODE);
                branch.find(inputStr2);
            }
            else if (num==4){
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "Please delete by branch id : " + foregroundColor.RESET_COLOR_CODE);
                int inputStr2 = input.nextInt();
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.RED_COLOR_CODE+
                        "!!!!!!!ARE SURE TO DELETE BRANCH (N/y) !!!!!!!"+foregroundColor.RESET_COLOR_CODE);
                if (input.next().equalsIgnoreCase("y")) branch.delete(inputStr2);
            }
            else if (num == 5){
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "Please update by branch id : " + foregroundColor.RESET_COLOR_CODE);
                int inputStr2 = input.nextInt();
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.BLUE_COLOR_CODE+
                        "Please enter new address : " + foregroundColor.RESET_COLOR_CODE);
                String address = input.next();
                branch.update(inputStr2,address);
            }
            else if (num == 6){
                System.out.println(foregroundColor.GREEN_COLOR_CODE+
                        "Have a good time"+foregroundColor.RESET_COLOR_CODE);
                break;
            }
        }
    }
}
