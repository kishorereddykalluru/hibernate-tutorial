package io.villageminds;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Embedded divides the Object into fields while saving into database, Object fields are added as columns in UserDetails object
 *
 * If there two instances of same object then database will not allow us to create multiple columns with same name
 * So we use @AttributeOverrides and @AttributeOverride to change the column names while saving to database
 *
 *
 */


@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "state", column = @Column(name = "home_state")),
            @AttributeOverride(name = "pincode", column = @Column(name = "home_pincode"))
    })
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "office_city")),
            @AttributeOverride(name = "street", column = @Column(name = "office_street")),
            @AttributeOverride(name = "state", column = @Column(name = "office_state")),
            @AttributeOverride(name = "pincode", column = @Column(name = "office_pincode"))
    })
    private Address officeAddress;

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
