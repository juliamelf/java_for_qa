package ru.juliamelf.javaqa.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.juliamelf.javaqa.addressbook.model.ContactData;
import ru.juliamelf.javaqa.addressbook.model.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 7/3/2016.
 */
public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data Format")
    public String format;

    public static void main (String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);

        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactData.class);
        String xml = xStream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private static void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ContactData contact : contacts) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                        contact.getFirstName(), contact.getMiddleName(), contact.getLastName(),
                        contact.getFirstAddress(), contact.getCompany(),
                        contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail(),
                        contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()));
            }
        }
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
