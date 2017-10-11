package com.example.bhasingursifath.feedbackform;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by bhasingursifath on 12-06-2017.
 */

public interface PostRequestInterface {

    //@POST("e/1FAIpQLSfCn8YxeEneV5vUKXQfhe2_jEMqr9SwSZ_gGRciij-MQG3oLA/formResponse")
    @POST("e/1FAIpQLSfmf4sfguBgyx-7vSd2yH0Z84F664P-TyVQ53w0lTG0pdLAgQ/formResponse")
    @FormUrlEncoded
    Call<Void> CompleteForm(

//            @Field("entry.1256178576") String Name,
//            @Field("entry.426491975") String Gender,
//            @Field("entry.2000641666") String Age,
//            @Field("entry.1350691592") String NameOfWorkshop,
//            @Field("entry.1015570159") String AreaOfWorkshop,
//            @Field("entry.1458731727") String Date,
//            @Field("entry.173119943") String Duration,
//            @Field("entry.721038449") String Feedback,
//            @Field("entry.1511956055") String RatingToFacilitator,
//            @Field("entry.639437097") String RatingToTopic,
//            @Field("entry.1512736639") String OverallRating


            @Field("entry.1733438470") String Name,
            @Field("entry.1211093855") String Gender,
            @Field("entry.1110665912") String Age,
            @Field("entry.887540785") String NameOfWorkshop,
            @Field("entry.538362076") String AreaOfWorkshop,
            @Field("entry.2052970862") String Date,
            @Field("entry.1669010573") String Duration,
            @Field("entry.1455564837") String Feedback,
            @Field("entry.1149906875") String RatingToFacilitator,
            @Field("entry.1219015826") String RatingToTopic,
            @Field("entry.1373808904") String OverallRating

    );
}
