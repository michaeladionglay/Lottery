package com.example.lottery;

import androidx.annotation.NonNull;

public class Ticket {

    private String name;
    //private long empId;
   // private String department;

    //private static int ctr = 1;

    Ticket(String name) {
        this.name = name;
        //this.empId = System.currentTimeMillis();
        //this.department = "Department " + ctr;
        //ctr++;
    }

    public String getName() {
        return name;
    }

    //long getEmpId() {
    //    return empId;
    //}

   // String getDepartment() {
   //     return department;
   // }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}