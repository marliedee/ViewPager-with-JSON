package org.pursuit.viewpager_json;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private Retrofit retro;
    private final String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retro = RetrofitInstance.getInstance();
        ViewService service = retro.create(ViewService.class);
        viewPager = findViewById(R.id.mainActivity_viewPager);

        final List<ViewFragment> fragmentList = new ArrayList<>();

        final Call<PlanetsWrapper> planetcall = service.getplanetsList();
        planetcall.enqueue(new Callback<PlanetsWrapper>() {
            @Override
            public void onResponse(Call<PlanetsWrapper> call, Response<PlanetsWrapper> response) {

                for (Planets planet : response.body().getPlanets()) {
                    fragmentList.add(ViewFragment.newInstance(planet.getImage(),planet.getNumber(), planet.getName()));
                }


                viewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), fragmentList));                }


            @Override
            public void onFailure(Call<PlanetsWrapper> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.getMessage());
            }
        });

    }
}
