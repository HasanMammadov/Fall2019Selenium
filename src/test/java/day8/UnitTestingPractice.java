package day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestingPractice {
    public static void main(String[] args) {
String expected = "cba";
String toReverse = "abc";
String actual = reverse(toReverse);

      //  System.out.println(verifyEquals(actual, actual));
        verifyEquals(actual,expected);

    }
    @Test(description = "Verify if method can reverse a string")//fust for information
    public void test(){
   String expected = "elppa";
   String actual = reverse("apple");

        Assert.assertEquals(actual,expected);//Assert TestNG den gelr. any data type we can compare

    }
    @Test(description = "Verify if method can reverse a string")
    public void test2(){
        String expected = "rac";
        String actual = reverse("car");

        Assert.assertEquals(actual,expected);

    }


    public static boolean verifyEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Test pass");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
            return true;
        }else {
            System.out.println("Test fail");
            System.out.println("Expected "+expected);
            System.out.println("Actual "+actual);
            return false;
        }




    }



    public static String reverse(String str){

        String result="";

        for (int i = str.length()-1; i >=0 ; i--) {
            result+=str.charAt(i);
        }



        return  result;
    }
}
