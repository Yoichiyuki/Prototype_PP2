class AttendanceRecord {
    private int studentId;
    private String date;
    private String status; //pres/abs

    public AttendanceRecord(int studentId, String date, String status){
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    public String getStatus(){
        return status;

    }

    public void setStatus(String status){
        this.status = status;
    }
}