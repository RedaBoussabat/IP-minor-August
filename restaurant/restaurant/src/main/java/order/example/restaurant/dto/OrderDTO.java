package order.example.restaurant.dto;

public class OrderDTO {

    private String name, phone;
    private boolean processed;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
