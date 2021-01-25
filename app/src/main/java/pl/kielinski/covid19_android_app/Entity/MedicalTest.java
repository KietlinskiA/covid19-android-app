package pl.kielinski.covid19_android_app.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicalTest  {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("typeOfMedicalTest")
    @Expose
    private TypeOfMedicalTest typeOfMedicalTest;
    @SerializedName("medicalTestDate")
    @Expose
    private String medicalTestDate;
    @SerializedName("resultDate")
    @Expose
    private String resultDate;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("doctorName")
    @Expose
    private String doctorName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TypeOfMedicalTest getTypeOfMedicalTest() {
        return typeOfMedicalTest;
    }

    public void setTypeOfMedicalTest(TypeOfMedicalTest typeOfMedicalTest) {
        this.typeOfMedicalTest = typeOfMedicalTest;
    }

    public String getMedicalTestDate() {
        return medicalTestDate;
    }

    public void setMedicalTestDate(String medicalTestDate) {
        this.medicalTestDate = medicalTestDate;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public String toString() {
        return "MedicalTest{" +
                "id='" + id + '\'' +
                ", typeOfMedicalTest=" + typeOfMedicalTest +
                ", medicalTestDate='" + medicalTestDate + '\'' +
                ", resultDate='" + resultDate + '\'' +
                ", result='" + result + '\'' +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
