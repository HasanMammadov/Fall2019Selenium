package officeHours;

import java.util.HashMap;
import java.util.Iterator;

public class IteratorPractice {
    public static void main(String[] args) {
        HashMap<String,String> personalInfo= new HashMap<>();

        personalInfo.put("name","Bryan");
        personalInfo.put("student_id","232423423");
        personalInfo.put("major","computer sience");

        Iterator<String> mapIterator = personalInfo.keySet().iterator();


        while (mapIterator.hasNext()){

String key =mapIterator.next();
            System.out.println(key+ ": "+ personalInfo.get(key));


        }



    }
}
