package lk.ijse.practice.dto;

public class CustomerDto {
    private String customerId;
    private String name;
    private String address;
    private String tel;

    public CustomerDto(){}
    public CustomerDto(String customerId , String name , String address , String tel) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "ManageCustomerDto{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
