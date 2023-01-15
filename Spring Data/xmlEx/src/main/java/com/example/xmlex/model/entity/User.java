package com.example.xmlex.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
        private int age;
        private String firstName;
        private String lastName;
        private Set<User> friends;
        private Set<Product> soldProducts;

        public User() {
        }

        @Column
        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        @Column(name = "first_name")
        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        @Column(name = "last_name", nullable = false)
        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        @ManyToMany
        public Set<User> getFriends() {
                return friends;
        }

        public void setFriends(Set<User> friends) {
                this.friends = friends;
        }

}
