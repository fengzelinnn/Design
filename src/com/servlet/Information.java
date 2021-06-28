package com.servlet;

public class Information {
    public String StuName;
    public String StuId;
    public String StuGrade_4;
    public String StuGrade_6;
    public String CertId;
    public String RoomId;
    public String SeatId;
    public int[] NUM;

    public void setStuName(String stuName) { StuName = stuName; }
    public void setStuId(String stuId) { StuId = stuId; }
    public void setStuGrade_4(String stuGrade_4) { StuGrade_4 = stuGrade_4; }
    public void setStuGrade_6(String stuGrade_6) { StuGrade_6 = stuGrade_6; }
    public void setCertId(String certId) { CertId = certId; }
    public void setRoomId(String roomId) { RoomId = roomId; }
    public void setSeatId(String seatId) { SeatId = seatId; }
    public String getStuName(){return StuName;}
    public String getStuId(){return StuId;}
    public String getStuGrade_4(){return StuGrade_4;}
    public String getStuGrade_6(){return StuGrade_6;}
    public String getCertId(){return CertId;}
    public String getRoomId(){return RoomId;}
    public String getSeatId(){return SeatId;}
//    public void setNUM(){
//        int j;
//        int num = (int) (Math.random() * 900 + 1);
//        boolean flag = false;
//        for(j = 0; j < NUM.length; j++) {
//            if(NUM[j] == num) {
//                flag = true;
//            }
//        }
//        if(flag) setNUM();
//        else NUM[j - 1] = num;
//    }
//    public int getNUM(int i) {
//        return NUM[i];
//    }
}
