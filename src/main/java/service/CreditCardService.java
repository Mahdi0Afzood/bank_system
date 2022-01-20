package service;

import exceptions.DigitsNumber;
import model.CreditCard;
import org.w3c.dom.ls.LSOutput;
import repository.CreditCardRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CreditCardService {
    private CreditCardRepository creditCardRepository;

    private String produceCardNumber(){
        Random random = new Random();
        String cardNumber1 = String.format("%08d",random.nextInt(10000_0000));
        String cardNumber2 = String.format("%08d",random.nextInt(10000_0000));
        return cardNumber1 + cardNumber2 ;
    }

    private int produceCCV2(){
        Random random = new Random();
        String ccv2 = String.format("%4d",random.nextInt(1_0000));
        return Integer.valueOf(ccv2);
    }

    private boolean cardValid(int password){
        if (password !=6) throw new DigitsNumber("password must be 6 digits ");
        else return true;
    }

    private List<Date> addDate() throws ParseException {
        Date startDate = Date.valueOf(LocalDate.now());
        Date expiredDate = Date.valueOf(LocalDate.of(LocalDate.now().getYear() + 2 ,LocalDate.now().getMonthValue() , LocalDate.now().getDayOfMonth() ));
        List<Date> dateList = new ArrayList<>();
        dateList.add(startDate);
        dateList.add(expiredDate);
        return dateList;
    }

    public boolean add(int account_id , int password ) throws SQLException, ClassNotFoundException, ParseException {
        creditCardRepository = new CreditCardRepository();
        cardValid(password);
        List<Date> dateList = addDate();
        String cardNumber = produceCardNumber();
        int ccv2 = produceCCV2();
        CreditCard creditCard = new CreditCard(null , cardNumber , password , ccv2 , dateList.get(0) , dateList.get(1) );
        return creditCardRepository.add(account_id,creditCard);
    }


}
