package view;

import service.ClientService;
import service.ValidationService;

import java.sql.SQLException;
import java.util.Scanner;

/*public class ClientPanel {
    private static Graphics.foregroundColor foregroundColor = new Graphics.foregroundColor();
    private static Graphics.backgroundColor backgroundColor = new Graphics.backgroundColor();
    private static Scanner input = new Scanner(System.in);
    private static ClientService branch = new ClientService();
    private static ValidationService validationService = new ValidationService();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        clientPanel();
    }

    static void clientPanel() throws SQLException, ClassNotFoundException {
        System.out.println("--------------------------------");
        System.out.println(foregroundColor.CYAN_COLOR_CODE + "    Welcome To Client Panel   " + foregroundColor.RESET_COLOR_CODE);
        System.out.println("--------------------------------");
        System.out.println(foregroundColor.YELLOW_COLOR_CODE + "Enter your first and last name : "+foregroundColor.RESET_COLOR_CODE);
        String[] inputStr = input.nextLine().trim().split(" ");
        if (validationService.valid(inputStr[0],inputStr[1])){
            while(true) {
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.MAGENTA_COLOR_CODE +
                        "1- Show your Information " +
                        "\n2- Search account Information " +
                        "\n3- Deposit " +
                        "\n4- Withdraw " +
                        "\n5- card to card " +
                        "\n6- Exit "
                        + foregroundColor.RESET_COLOR_CODE);
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.RED_COLOR_CODE +
                        "Enter your desired number " + foregroundColor.RESET_COLOR_CODE);
                System.out.println("--------------------------------");
                int num = input.nextInt();
                System.out.println("--------------------------------");
                if (num==1){

                }
                else if (num==2){

                }
                else if (num==3){

                }
                else if (num==4){

                }
                else if (num==5){

                }
                else if (num==6){
                    System.out.println(foregroundColor.GREEN_COLOR_CODE+
                            "Have a good time"+foregroundColor.RESET_COLOR_CODE);
                    break;
                }
            }

        }else System.out.println("you are not verify ! ");
    }
}*/
