package src.Project_RentHouseSys.HouseRentDomain;

public class House {
    //House的一个对象表示一个房屋信息
    private int id;
    private String name;
    private String phoneNo;
    private String address;
    private int rent;//租金
    private String status;//出租状态

    public House(int id, String name, String phoneNo, String address, int rent, String status) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.rent = rent;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + "\t\t" + name + "\t\t" + phoneNo + "\t\t" + address + "\t\t" + rent + "\t\t" + status;
    }

}
