package order.example.restaurant.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClientDTO {

    private Long id;
    @NotEmpty
    @Size(min = 4)
    private String name;
    private String phone;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
