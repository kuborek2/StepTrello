package anstar.StepTrello.Entity;

import lombok.Getter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "users")
public class User implements Serializable {
//    user_name VARCHAR (25) PRIMARY KEY,
//    email VARCHAR(60),
//    password VARCHAR(30)

    @Id
    @Column(name = "user_name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    private User(Builder builder){
        username = builder.user_name;
        email = builder.email;
        password = builder.password;
    }
    public User() {}

    public static final class Builder {
        private String user_name;
        private String email;
        private String password;

        public Builder () {
        }

        public Builder user_name(String user_name) {
            this.user_name = user_name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }


}
