package ru.juliamelf.javaqa.addressbook.model;

public class GroupData {
    private final String name;
    private final String header;
    private final String footer;

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return name.equals(groupData.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
