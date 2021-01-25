//package pl.kielinski.covid19_android_app;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import pl.kielinski.covid19_android_app.Entity.MedicalTest;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class Controller {
//
//    String url = "https://covid19-server-app.herokuapp.com";
//    MedicalTest[] medicalTests;
//    MainController mInterface;
//
//    @Override
//    public void onResponse(Call<MedicalTest[]> call, Response<MedicalTest[]> response) {
//        if(response.isSuccessful()){
//            medicalTests = response.body();
//            System.out.println("ID: "+medicalTests[0].getId());
//            System.out.println("Nazwisko doktora: "+medicalTests[0].getDoctorName());
//            System.out.println("Rezultat: "+medicalTests[0].getResult());
//        } else {
//            System.out.println("BLAD W BODY");
//            System.out.println(response.errorBody());
//        }
//    }
//
//    @Override
//    public void onFailure(Call<MedicalTest[]> call, Throwable t) {
//        System.out.println("BLAD Z REQUESTEM");
//    }
//
//
//}
