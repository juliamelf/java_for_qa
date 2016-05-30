package ru.juliamelf.javaqa.addressbook;

public class PhoneData {
    private final String homeNumber;
    private final String mobileNumber;
    private final String workNumber;
    private final String faxNumber;

    public PhoneData(String homeNumber, String mobileNumber, String workNumber, String faxNumber) {
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.faxNumber = faxNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }
}
