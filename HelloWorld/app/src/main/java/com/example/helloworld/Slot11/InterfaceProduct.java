package com.example.helloworld.Slot11;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface InterfaceProduct {
    @POST("/api/product/insert")
    Call<ProductResponse> insert(@Body ProductResponse productResponse);
}
