package im.atzma.lista.model;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "ClientData{" +
                "tempClientName='" + tempClientName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientData that = (ClientData) o;
        return Objects.equals(tempClientName, that.tempClientName) &&
                Objects.equals(telNumber, that.telNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempClientName, telNumber, email, address);
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
