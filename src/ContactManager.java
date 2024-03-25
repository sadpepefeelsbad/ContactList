import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    private final List<Contact> contacts = new ArrayList<>();

    public ContactManager() {
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(int number) {
        contacts.remove(number - 1);
    }

    public void printList() {
        if (contacts.isEmpty()) System.out.println("Список контактов пуст");
        else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.printf("%d. %s \n", i + 1, contacts.get(i));
            }
        }
    }

    public void search(String name) {
        int counter = 0;
        System.out.println("Результаты поиска: ");
        for (Contact contact : contacts) {
            if (name.equals(contact.getName())) {
                counter++;
                System.out.printf("%d. %s\n", counter, contact);
            }
        }
        if (counter == 0) System.out.printf("Контакт с именем %s не найден\n", name);
    }

    public int getContactListSize() {
        return contacts.size();
    }
}
