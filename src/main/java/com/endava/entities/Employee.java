package com.endava.entities;

import java.util.Objects;

/**
 * Created by sbogdanschi on 3/04/2017.
 */
public class Employee {
    private String name;
    private String surname;
    private String work;

    public Employee() {
        //empty constructor
    }

    public Employee(String name, String surname, String work) {
        this.name = name;
        this.surname = surname;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(work, employee.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, work);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", work='").append(work).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
