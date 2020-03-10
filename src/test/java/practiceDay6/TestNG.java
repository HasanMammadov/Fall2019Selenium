package practiceDay6;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG {

    @BeforeClass
public void beforeClass(){
        System.out.println("Before Class");

}
    @BeforeMethod
    public void setup() {
        System.out.println("Before Method");
    }

    @Test
    public void test1() {
        String word1 = "java";
        String word2 = "java";
        System.out.println("Test1");
        Assert.assertEquals(word1, word2);

    }
@Ignore
    @Test
    public void test2() {
        String word1 = "java";
        String word2 = "javaScript";
    System.out.println("Test2");
        Assert.assertEquals(word1, word2);

    }
    @Test(priority = 1)
    public void test3() {
        System.out.println("Test3");
        Assert.assertTrue(5>10);

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

}