package pl.kielinski.covid19_android_app.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TypeOfMedicalTest {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("medicalTestName")
    @Expose
    private String medicalTestName;
    @SerializedName("medicalTestMethod")
    @Expose
    private String medicalTestMethod;
    @SerializedName("collectMethod")
    @Expose
    private String collectMethod;
    @SerializedName("medicalTestDescription")
    @Expose
    private String medicalTestDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedicalTestName() {
        return medicalTestName;
    }

    public void setMedicalTestName(String medicalTestName) {
        this.medicalTestName = medicalTestName;
    }

    public String getMedicalTestMethod() {
        return medicalTestMethod;
    }

    public void setMedicalTestMethod(String medicalTestMethod) {
        this.medicalTestMethod = medicalTestMethod;
    }

    public String getCollectMethod() {
        return collectMethod;
    }

    public void setCollectMethod(String collectMethod) {
        this.collectMethod = collectMethod;
    }

    public String getMedicalTestDescription() {
        return medicalTestDescription;
    }

    public void setMedicalTestDescription(String medicalTestDescription) {
        this.medicalTestDescription = medicalTestDescription;
    }

    @Override
    public String toString() {
        return "TypeOfMedicalTest{" +
                "id='" + id + '\'' +
                ", medicalTestName='" + medicalTestName + '\'' +
                ", medicalTestMethod='" + medicalTestMethod + '\'' +
                ", collectMethod='" + collectMethod + '\'' +
                ", medicalTestDescription='" + medicalTestDescription + '\'' +
                '}';
    }
}
