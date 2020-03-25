package day13;

import org.testng.annotations.Test;

public class SystemProperties {




    @Test
    public void test(){

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));

        String pathDownloads = System.getProperty("user.home")+"/Downloads";

        System.out.println(pathDownloads);

        System.out.println(System.getProperty("os.arch"));

    }
}
