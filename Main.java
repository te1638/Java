
public class Main {
    public static void main(String[] args) {


        listAction();
        String name1 = "Иванов";
        String name2 = "Крюков";

        telephoneDirectory(name1);
        telephoneDirectory(name2);
    }

    public static void listAction() {
        Catalog catalog = new WordCatalog();
        catalog.add("Apple");
        catalog.add("Word");
        catalog.add("Squirrel");
        catalog.add("Moscow");
        catalog.add("Orange");
        catalog.add("World");
        catalog.add("Squirrels");
        catalog.add("Moscow");
        catalog.add("Cola");
        catalog.add("Word");
        catalog.add("Squirrel");
        catalog.add("Moscow");
        catalog.printUnique();
    }

    public static void telephoneDirectory(String name) {

        System.out.println("\nПоиск в телефонном справочнике по фамилии: " + name);


        TelephoneDirectory td = new TelephoneDirectory();
        td.add("55-44-33", "Павлов");
        td.add("55-44-31", "Иванов");
        td.add("55-44-32", "Чашкин");
        td.add("55-44-34", "Бурунов");
        td.add("55-44-35", "Иванов");
        td.add("55-44-36", "Крюков");
        td.add("31-44-36", "Крюков");
        td.get(name);
    }

}


