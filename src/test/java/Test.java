import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Test {

    @org.junit.jupiter.api.Test
    public void testMinor() {
        List<Person> minors = new ArrayList<>();
        minors = Main.minor();
        int age = 18;
        int sizeMinor = minors.size();
        int agePersonMinor = minors.get(new Random().nextInt(sizeMinor)).getAge();
        Assertions.assertTrue(age > agePersonMinor);
    }

    @org.junit.jupiter.api.Test
    public void testConscript() {
        List<Person> conscripts = new ArrayList<>();
        conscripts = Main.conscript();
        int sizeConscript = conscripts.size();
        int firstAge = 18;
        int lastAge = 27;
        String sexOriginal = "MAN";
        int ageConscript = conscripts.get(new Random().nextInt(sizeConscript)).getAge();
        String sexConscript = String.valueOf(conscripts.get(new Random().nextInt(sizeConscript)).getSex());
        Assertions.assertTrue(ageConscript >= firstAge && ageConscript < lastAge);
        Assertions.assertEquals(sexOriginal, sexConscript);
    }

    @org.junit.jupiter.api.Test
    public void testWorker() {
        List<Person> workers = new ArrayList<>();
        workers = Main.worker();
        int sizeWorker = workers.size();
        int firstAge = 18;
        int lastAgeMan = 65;
        int ageWorker = workers.get(new Random().nextInt(sizeWorker)).getAge();
        Assertions.assertTrue(ageWorker > firstAge && ageWorker < lastAgeMan);

    }
}