package Pages;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomFunctions {
    public static Boolean  stringComparon (String stringTesting , String comparing ){
    if (stringTesting.equals(comparing)){
    return  true ;
    }
    else {
    return  false ; }
}
    public  static  String dateNow(){
    String pattern = "dd/MM/yyyy";
    String dateInStringNow =new SimpleDateFormat(pattern).format(new Date());
    System.out.println(dateInStringNow);
    return dateInStringNow;
}
     public static String oldDate(){
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
    Date date = new Date(System.currentTimeMillis()-7*24*60*60*1000);
    String  yesterdayDate= dateFormat.format(date);
    System.out.println(yesterdayDate);
    return yesterdayDate;
}


}
