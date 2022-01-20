package view;

import model.Account;
import model.AccountType;
import model.CreditCard;
import model.EmployeeType;
import org.postgresql.util.PSQLException;
import service.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class EmployeePanel {
    private static Graphics.foregroundColor foregroundColor = new Graphics.foregroundColor();
    private static Graphics.backgroundColor backgroundColor = new Graphics.backgroundColor();
    private static Scanner input = new Scanner(System.in);
    private static ValidationService validationService = new ValidationService();
    private static PersonService personService = new PersonService();
    private static EmployeeService employeeService = new EmployeeService();
    private static ClientService clientService = new ClientService();
    private static AccountService accountService = new AccountService();
    private static CreditCardService creditCardService = new CreditCardService();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        employeePanel();
    }

    static void employeePanel() throws SQLException, ClassNotFoundException {
        System.out.println("--------------------------------");
        System.out.println(foregroundColor.CYAN_COLOR_CODE + "    Welcome To Employee Panel   " + foregroundColor.RESET_COLOR_CODE);
        System.out.println("--------------------------------");
        System.out.println(foregroundColor.YELLOW_COLOR_CODE + "please enter username and password " + foregroundColor.RESET_COLOR_CODE);
        String[] inputStr = input.nextLine().trim().split(" ");
        boolean service = false;
        try {
            service = validationService.isEmployee(inputStr[0], inputStr[1]);
        } catch (SQLException exception) {
            System.out.println(foregroundColor.RED_COLOR_CODE +
                    "YOU HAVE NOT ALLOWED ACCESS TO EMPLOYEE PANEL ,YOUR ACCOUNT MUST FIRST CREATE BY ADMIN OR BOSS " +
                    foregroundColor.RESET_COLOR_CODE);
        }

        if (service) {
            while (true) {
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.MAGENTA_COLOR_CODE +
                        "1- Show your Information " +
                        "\n2- Create Account " +
                        "\n3- Find Account " +
                        "\n4- Show All Account " +
                        "\n5- Update Account " +
                        "\n6- Delete Account " +
                        "\n7- Create Credit Card " +
                        "\n8- Find Credit Card " +
                        "\n9- Update Credit Card " +
                        "\n10- Delete Credit Card " +
                        "\n11- Find Transactions" +
                        "\n12- Show All Transactions " +
                        "\n13- Exit "
                        + foregroundColor.RESET_COLOR_CODE);
                System.out.println("--------------------------------");
                System.out.println(foregroundColor.RED_COLOR_CODE +
                        "Enter your desired number " + foregroundColor.RESET_COLOR_CODE);
                System.out.println("--------------------------------");
                int num =input.nextInt();
                System.out.println("--------------------------------");
                if (num == 1) {
                    employeeService.findByUP(inputStr[0], inputStr[1]);
                } else if (num == 2) {
                    System.out.println(foregroundColor.BLUE_COLOR_CODE + "Please enter client 1- fist name" +
                            " 2- last name 3- address 4- username 5- password 6- birth date 7- national code" +
                            " 8- phone number" + foregroundColor.RESET_COLOR_CODE);
                    System.out.println("--------------------------------");
                    input.nextLine();
                    String[] inputs = input.nextLine().trim().split(" ");
                    try {
                        personService.add(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4],
                                Date.valueOf(inputs[5]), Integer.valueOf(inputs[6]),
                                Integer.valueOf(inputs[7]));
                    } catch (PSQLException Exception) {
                        System.out.println("--------------------------------");
                        System.out.println(foregroundColor.RED_COLOR_CODE + "you enter repetitive username or national code " +
                                "please enter another username , national code " + backgroundColor.RESET_COLOR_CODE);
                    }
                    try {
                        clientService.add(inputs[3]);
                        int id_client = clientService.findByUser(inputs[3]);
                        System.out.println("the client id is : " + id_client);;
                    } catch (PSQLException Exception) {
                        System.out.println("--------------------------------");
                        System.out.println(foregroundColor.RED_COLOR_CODE + "The username is" +
                                "repetitive " + backgroundColor.RESET_COLOR_CODE);
                    }
                    try {
                        System.out.println(foregroundColor.BLUE_COLOR_CODE + "Please select account type : " +
                                "1- CHECKING_ACCOUNT\n" +
                                "2- SAVINGS_ACCOUNT\n" +
                                "3- FIXED_ACCOUNT_1YEAR\n" +
                                "4- FIXED_ACCOUNT_2YEAR\n" +
                                "And initial balance " + foregroundColor.RESET_COLOR_CODE);
                        String[] inputs2 = input.nextLine().trim().split(" ");
                        accountService.add(inputs[3], AccountType.valueOf(inputs2[0]), Double.valueOf(inputs2[1]));

                    } catch (Exception e) {
                        System.out.println("--------------------------------");
                        System.out.println(foregroundColor.RED_COLOR_CODE + e + backgroundColor.RESET_COLOR_CODE);
                    }
                } else if (num == 3) {
                    try {
                        System.out.println(foregroundColor.BLUE_COLOR_CODE +
                                "Please enter client id"
                                + foregroundColor.RESET_COLOR_CODE);
                        Account account = accountService.find(input.nextInt());
                        System.out.println("--------------------------------");
                        System.out.println(foregroundColor.GREEN_COLOR_CODE+
                                "account id   : " + account.getId()+
                                "\naccount type : " + account.getAccountType()+
                                "\nbalance      : " + account.getBalance()+
                                foregroundColor.RESET_COLOR_CODE);
                    } catch (Exception e) {
                        System.out.println("--------------------------------");
                        System.out.println("not found !");
                    }
                } else if (num == 4) {
                    try {
                        accountService.findAll();
                    } catch (Exception e){
                        System.out.println("not found !");
                    }

                } else if (num == 5) {
                    try{
                        System.out.println(foregroundColor.BLUE_COLOR_CODE +
                                "Please enter client id"
                                + foregroundColor.RESET_COLOR_CODE);
                        System.out.println("--------------------------------");
                        int firstInput = input.nextInt();
                        System.out.println("--------------------------------");
                        System.out.println(foregroundColor.BLUE_COLOR_CODE +
                                "Please enter new account type " +
                                "\n1- CHECKING_ACCOUNT       " +
                                "\n2- SAVINGS_ACCOUNT          " +
                                "\n3- FIXED_ACCOUNT_1YEAR      " +
                                "\n4- FIXED_ACCOUNT_2YEAR      " +
                                "\nAnd new balance "
                                + foregroundColor.RESET_COLOR_CODE);
                        input.nextLine();
                        String[] inputs = input.nextLine().trim().split(" ");
                        System.out.println("--------------------------------");
                        if (accountService.update(firstInput,inputs[0],Double.parseDouble(inputs[1]))) System.out.println("the account updated successfully");
                        else System.out.println("sorry ! system can't change account information");
                    }catch(Exception e){
                        System.out.println("the account is invalid");
                    }
                }else if (num == 6 ){
                    try {
                        System.out.println(foregroundColor.BLUE_COLOR_CODE +
                                "Please enter client id"
                                + foregroundColor.RESET_COLOR_CODE);
                        System.out.println("--------------------------------");
                        int firstInput = input.nextInt();
                        if (accountService.delete(firstInput)) System.out.println("delete successfully");
                        else System.out.println("sorry ! system can't delete this account ");
                    } catch (Exception e) {
                        System.out.println("the account is invalid");
                    }
                } else if (num==7){
                    System.out.println(foregroundColor.BLUE_COLOR_CODE +
                            "Please enter account id"
                            + foregroundColor.RESET_COLOR_CODE);
                    int id = input.nextInt();
                    System.out.println("--------------------------------");
                    System.out.println(foregroundColor.BLUE_COLOR_CODE +
                            "Please enter card password "
                            + foregroundColor.RESET_COLOR_CODE);
                    int password = input.nextInt();
                    try {
                        creditCardService.add(id,password);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if (num == 13) {
                    System.out.println(foregroundColor.GREEN_COLOR_CODE +
                            "Have a good time" + foregroundColor.RESET_COLOR_CODE);
                    break;
                }
            }

        }
    }

}


