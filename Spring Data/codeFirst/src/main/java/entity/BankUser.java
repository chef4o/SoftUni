package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "bank_users")
public class BankUser extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<BillingInstrument> billingInstruments;

    public BankUser() {
    }

    @Column(name = "first_name", length = 50, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 60, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "owner")
    public Set<BillingInstrument> getBillingInstruments() {
        return billingInstruments;
    }

    public void setBillingInstruments(Set<BillingInstrument> billingInstruments) {
        this.billingInstruments = billingInstruments;
    }
}
