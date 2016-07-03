package ru.juliamelf.javaqa.addressbook.generators;

import ru.juliamelf.javaqa.addressbook.model.ContactData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 7/3/2016.
 */
public class ContactDataGenerator {

    public static void main (String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);

    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                    contact.getFirstName(), contact.getMiddleName(), contact.getLastName(),
                    contact.getFirstAddress(), contact.getCompany(),
                    contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail(),
                    contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstName(String.format("Alex %s", i))
                    .withMiddleName(String.format("Alexandrovich %s", i))
                    .withLastName(String.format("Alexandrov %s", i))
                    .withFirstAddress(String.format("Arbat %s", i))
                    .withCompany(String.format("Alex Company %s", i))
                    .withFirstEmail(String.format("firstemail%s@email.com", i))
                    .withSecondEmail(String.format("secondemail%s@email.com", i))
                    .withThirdEmail(String.format("thirdemail%s@email.com", i))
                    .withHomePhone(String.format("111222%s", i))
                    .withMobilePhone(String.format("333444%s", i))
                    .withWorkPhone(String.format("555666%s", i)));
        }
        return contacts;
    }
}
