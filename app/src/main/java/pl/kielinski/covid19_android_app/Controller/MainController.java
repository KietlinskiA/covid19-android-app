package pl.kielinski.covid19_android_app.Controller;

import pl.kielinski.covid19_android_app.Entity.Patient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface MainController {

    @GET("/api/patient/{pesel}")
    Call<Patient> login(@Path("pesel") String pesel);

}
