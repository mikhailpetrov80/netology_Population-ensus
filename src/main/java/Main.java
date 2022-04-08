import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static Collection<Person> persons() {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        return persons;

    }

    public static List<Person> minor() {

        Stream<Person> minor = persons().stream();
        List<Person> m = minor.filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());
        //.count();

        return m;
    }

    public static List<Person> conscript() {

        Stream<Person> conscript = persons().stream();
        List<Person> c = conscript.filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() < 27)
                //.map(person -> person.getFamily())
                .collect(Collectors.toList());

        return c;
    }

    public static List<Person> worker() {

        Stream<Person> workers = persons().stream();
        List<Person> w = workers.filter(person -> person.getAge() > 18)
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .filter(person -> person.getAge() < 65)
                .filter(person -> !Objects.equals(person.getSex().equals(Sex.WOMAN), person.getAge() > 60))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        return w;
    }

    public static void main(String[] args) {

        minor().stream().count();
        conscript().stream().map(Person::getFamily).collect(Collectors.toList());
        worker();
    }
}
