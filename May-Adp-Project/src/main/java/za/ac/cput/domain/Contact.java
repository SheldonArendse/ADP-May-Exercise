package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Contact {
    @Id
    private String email;
    private String mobile;
    private String workTelephone;

    protected Contact() {

    }

    public Contact(Builder builder) {
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.workTelephone = builder.workTelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getEmail(), contact.getEmail()) && Objects.equals(getMobile(), contact.getMobile()) && Objects.equals(getWorkTelephone(), contact.getWorkTelephone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getMobile(), getWorkTelephone());
    }

    @Override
    public String toString() {
        return "Contact" + "\n-----------------\n" +
                "Email = " + email + "\n" +
                "Mobile = " + mobile + "\n" +
                "Work Telephone = " + workTelephone + "\n";
    }

    public static class Builder {
        @Id
        private String email;
        private String mobile;
        private String workTelephone;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setWorkTelephone(String workTelephone) {
            this.workTelephone = workTelephone;
            return this;
        }
        public Builder copy(Contact obj) {
            this.email = obj.email;
            this.mobile = obj.mobile;
            this.workTelephone = obj.workTelephone;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
