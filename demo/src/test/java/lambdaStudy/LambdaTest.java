package lambdaStudy;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class LambdaTest{
    public static void main(String[] args) {
        //创建线程举例
        //原写法
        Thread td=new Thread(new Runnable() {
            @Override
            public void run() {
                out.println("hello,,,");
            }
        });
        td.start();
        //lambda写法
        Thread td1=new Thread(()-> out.println("hello,lambda"));
        td1.start();
        //排序
        List<String> list= Arrays.asList(new String[]{"b","c","a"});
//        //匿名类写法
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
        //lambda写法
        list.forEach((s)-> System.out.println("我是String排序前的数据:"+s));

        Collections.sort(list,String::compareTo);
        list.forEach((s)-> System.out.println("我是String排序后的结果:"+s));

        List<String> proNames=Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> lowercaseNames=new ArrayList<>();
        for (String str :proNames){
            lowercaseNames.add(str.toLowerCase());
        }
        List<String> lowercaseNames1=proNames.stream().map(name->name.toLowerCase()).collect(Collectors.toList());
        lowercaseNames1.forEach(System.out::println);
        testPlayers();
    }
    public  static   void testPlayers(){
        String []players={"Rafel Nadal","Novak Djokovic","Stanislas Wawrinka","David Ferrer","Roger Federer","Andy Murray","Tomas Berdych","Juan Martin Del Potro","Richard Gasquet","John Isner"};
        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
             return o1.compareTo(o2);
            }
        });
        Comparator<String> comparable=(String s1,String s2)->(s1.compareTo(s2));
        Arrays.stream(players).sorted(String::compareTo);
        Arrays.sort(players,comparable);
        // 1.1 使用匿名内部类根据 surname 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" ")));
            }
        });
        Comparator<String> sortBySurname=(s1,s2)->(s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        Arrays.sort(players,sortBySurname);

        System.out.println("给程序员加薪%5:");


        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };
        Consumer<Person>  givePerson=e->e.setSalary(e.getSalary()/100*5+e.getSalary());

        javaProgrammers.forEach(givePerson);

        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> oushuList=list.stream().filter(o->o%2==0).collect(Collectors.toList());
        //数组转换
        String []stringArray=new String[]{"a","b","c"};
        List<String> listString= Stream.of(stringArray).collect(Collectors.toList());
        Set<String> setString=Stream.of(stringArray).collect(Collectors.toSet());
        //列表数组
        String []ss=listString.stream().toArray(String[]::new);

        for (String s : ss) {
            System.out.println(String.format("转换后的数组为%s",s));
        }

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
        Predicate<Person> ageFilter=(p)->(p.getAge()>25);
        Predicate<Person> salaryFilter=(p)->(p.getSalary()>1400);
        Predicate<Person> genderFilter=(p)->(("female").equals(p.getSalary()));

        System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    }
}