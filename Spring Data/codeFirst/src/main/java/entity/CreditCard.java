package entity;

import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingInstrument {

    private CreditCardType type;
    private int expMonth;
    private int expYear;

    public CreditCard() {
    }

    @Enumerated(EnumType.STRING)
    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    @Column(name = "exp_month", nullable = false)
    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    @Column(name = "exp_year", nullable = false)
    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }
}
