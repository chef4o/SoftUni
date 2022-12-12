package entity;

import javax.persistence.*;

@Entity
@Table(name = "billing_instrument")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingInstrument extends BaseEntity{

    private Long number;
    private BankUser owner;

    public BillingInstrument() {
    }

    @Column(name = "number", unique = true)
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @ManyToOne
    public BankUser getOwner() {
        return owner;
    }

    public void setOwner(BankUser owner) {
        this.owner = owner;
    }
}
