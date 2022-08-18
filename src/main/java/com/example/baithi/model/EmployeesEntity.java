package com.example.baithi.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "employees")

public class EmployeesEntity {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "id")
        private int id;
        @Basic
        @Column(name = "name")
        @NotNull
        @Size(min = 2 , message = "user name should have at least 2 characters")
        private String name;
        @Column(name = "wage")
        @Size(max = 10)
        private String wage;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getWage() {
                return wage;
        }

        public void setWage(String wage) {
                this.wage = wage;
        }
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                EmployeesEntity that = (EmployeesEntity) o;
                return id == that.id && Objects.equals(name, that.name) && Objects.equals(wage, that.wage);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, wage);
        }
}
