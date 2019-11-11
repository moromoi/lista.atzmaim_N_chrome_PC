package im.atzma.lista.model;

public class ClientData {
    private final String tempClientName;
    private final String telNumber;
    private final String email;
    private final String address;

    public ClientData(String tempClientName, String telNumber, String email, String address) {
        this.tempClientName = tempClientName;
        this.telNumber = telNumber;
        this.email = email;
        this.address = address;
    }

    public String getTempClientName() {
        return tempClientName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
