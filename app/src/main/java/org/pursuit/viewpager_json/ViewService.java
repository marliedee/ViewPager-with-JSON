package org.pursuit.viewpager_json;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ViewService {

    String END_POINT_URL = "/JDVila/storybook/master/planets.json";
    @GET(END_POINT_URL)
    Call<PlanetsWrapper> getplanetsList();
}
