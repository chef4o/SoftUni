package com.example.jsonex.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
        private int age;
        private String firstName;
        private String lastName;
        private Set<User> friends;

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
