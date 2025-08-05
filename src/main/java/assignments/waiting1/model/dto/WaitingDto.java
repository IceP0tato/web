package assignments.waiting1.model.dto;

public class WaitingDto {
    private String phone;
    private int num, count;

    public WaitingDto() {
    }

    public WaitingDto(int num, String phone, int count) {
        this.num = num;
        this.phone = phone;
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "num=" + num +
                ", phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}
