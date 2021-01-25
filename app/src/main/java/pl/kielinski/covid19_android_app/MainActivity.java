package pl.kielinski.covid19_android_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.kielinski.covid19_android_app.Controller.MainController;
import pl.kielinski.covid19_android_app.Entity.MedicalTest;
import pl.kielinski.covid19_android_app.Entity.Patient;
import pl.kielinski.covid19_android_app.Entity.TypeOfMedicalTest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Patient> {

    TextView txtHello;
    TextView txtPassword;
    TextView txtCorrectPesel;
    TextView txtName;
    TextView txtMedicalTestDate;
    TextView txtResultDate;
    TextView txtMedicalTestName;
    TextView txtMedicalTestMethod;
    TextView txtCollectMethod;
    TextView txtMedicalTestDescription;
    TextView txtResult;
    String url = "https://covid19-server-app.herokuapp.com";
//    String url = "http://localhost:8080";

    MainController mainController;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        txtHello = findViewById(R.id.txt_hello);
        txtPassword = findViewById(R.id.txt_password);
        txtCorrectPesel = findViewById(R.id.txt_correct_pesel);
        txtName = findViewById(R.id.txt_name);
        txtMedicalTestDate = findViewById(R.id.txt_medical_test_date);
        txtResultDate = findViewById(R.id.txt_result_date);
        txtMedicalTestName = findViewById(R.id.txt_medical_test_name);
        txtMedicalTestMethod = findViewById(R.id.txt_medical_test_method);
        txtCollectMethod = findViewById(R.id.txt_collect_method);
        txtMedicalTestDescription = findViewById(R.id.txt_medical_test_description);
        txtResult = findViewById(R.id.txt_medical_test_result);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mainController = retrofit.create(MainController.class);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(Call<Patient> call, Response<Patient> response) {
        if(response.isSuccessful()){
            Patient body = response.body();

            if(body.getId() != 0){
                MedicalTest medicalTest = body.getMedicalTest();
                TypeOfMedicalTest typeOfMedicalTest = medicalTest.getTypeOfMedicalTest();
                txtCorrectPesel.setVisibility(View.INVISIBLE);
                txtName.setText(body.getName() + " " + body.getSurname());
                txtMedicalTestDate.setText("Data wykonania: " + medicalTest.getMedicalTestDate());
                txtResultDate.setText("Data wyniku: " + medicalTest.getResultDate());
                txtMedicalTestName.setText("Nazwa badania: " + typeOfMedicalTest.getMedicalTestName());
                txtMedicalTestMethod.setText("Metoda badania: " + typeOfMedicalTest.getMedicalTestMethod());
                txtCollectMethod.setText("Metoda pobrania: " + typeOfMedicalTest.getCollectMethod());
                txtMedicalTestDescription.setText("Opis: " + typeOfMedicalTest.getMedicalTestDescription());
                if (medicalTest.getResult().equals("FALSE")) {
                    txtResult.setText("Wynik ostateczny: NEGATYWNY");
                } else {
                    txtResult.setText("Wynik ostateczny: POZYTYWNY");
                }
            } else {
                txtCorrectPesel.setVisibility(View.VISIBLE);
                txtName.setText("");
                txtMedicalTestDate.setText("");
                txtResultDate.setText("");
                txtMedicalTestName.setText("");
                txtMedicalTestMethod.setText("");
                txtCollectMethod.setText("");
                txtMedicalTestDescription.setText("");
                txtResult.setText("");
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Patient> call, Throwable t) {
        System.out.println("BLAD Z REQUESTEM");
    }

    public void sayHi(View view) {
        Call<Patient> call = mainController.login(txtPassword.getText().toString());
        call.enqueue(this);
    }
}
