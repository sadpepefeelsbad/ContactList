import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        boolean running = true;

        System.out.print("""
                Добро пожаловать в приложение "Список контактов"!\s
                1. Добавить контакт\s
                2. Просмотреть список контактов\s
                3. Найти контакт по имени\s
                4. Удалить контакт\s
                5. Выход\s
                """);

        while (running) {

            System.out.print("Выберите действие (введите номер): ");

            try {
                int op = Integer.parseInt(scanner.nextLine());
                if (op > 5 || op < 1) {
                    throw new IllegalArgumentException();
                } else {
                    switch (op) {
                        case 1 -> {
                            System.out.print("Введите имя контакта: ");
                            String name = scanner.nextLine();
                            System.out.print("Введите фамилию контакта: ");
                            String surname = scanner.nextLine();
                            System.out.print("Введите номер телефона: ");
                            String number = scanner.nextLine();
                            System.out.print("Введите адрес эл. почты: ");
                            String email = scanner.nextLine();
                            System.out.println("Контакт успешно добавлен.");

                            Contact contact = new Contact(name, surname, number, email);
                            contactManager.addContact(contact);
                        }

                        case 2 -> {
                            System.out.println("Список контактов: ");
                            contactManager.printList();
                        }

                        case 3 -> {
                            System.out.print("Введите имя для поиска: ");
                            String name = scanner.nextLine();
                            contactManager.search(name);
                        }

                        case 4 -> {
                            System.out.print("Введите номер контакта для удаления: ");
                            try {
                                int number = Integer.parseInt(scanner.nextLine());
                                if (number > contactManager.getContactListSize() || number < 1) {
                                    throw new IllegalArgumentException();
                                } else {
                                    contactManager.removeContact(number);
                                    System.out.println("Контакт успешно удален.");
                                }
                            } catch (IllegalArgumentException | InputMismatchException ex) {
                                System.out.println("Некорректный номер.");
                            }
                        }

                        case 5 -> {
                            System.out.println("До свидания!");
                            running = false;
                        }
                    }
                }
            } catch (IllegalArgumentException | InputMismatchException ex) {
                System.out.println("Некорректный номер.");
            }
        }
    }
}