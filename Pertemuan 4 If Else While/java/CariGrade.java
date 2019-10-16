package com.example.kelaspaklis4ifelse;



    public class CariGrade {
        public String carigrade(double akhir){
            String grade;
            if(akhir>=85 ){
                grade = "A";
            } else if(akhir>=80 && akhir<85){
                grade = "A-";
            } else if(akhir>=75 && akhir<80){
                grade = "B+";
            } else if(akhir>=70 && akhir<75){
                grade = "B";
            } else if(akhir>=65 && akhir<=70){
                grade = "B-";
            } else if(akhir>=60 && akhir<=65){
                grade = "C";
            } else if(akhir>=45 && akhir<=60){
                grade = "D";
            } else {
                grade = "E";
            }
            return grade;
        }
            }

