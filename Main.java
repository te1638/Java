public class Main {
    public static void main(String[] args) {
        DoublyLinkedList names = new DoublyLinkedList();
        names.addFirst("Mike");
        System.out.println(names);
        names.addFirst("John");
        names.addLast("Jakob");
        System.out.println(names);

        names.addFirst("Marry");
        names.addLast("Kaizerine");


        System.out.println(names);
        names.deleteOneElement(0);
        names.deleteOneElement(0);
        names.deleteOneElement(0);
        System.out.println(names);

        System.out.println("Size: " + names.getSize());
    }
}