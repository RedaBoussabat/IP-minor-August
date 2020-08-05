package order.example.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min=4)
    private String name, phone;
    private boolean processed;

    public Order(@NotEmpty @Size(min = 4) String name, @NotEmpty @Size(min = 4) String phone, boolean processed) {
        this.name = name;
        this.phone = phone;
        this.processed = processed;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isProcessed(){
        return processed;
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
