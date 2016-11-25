package news.utils;

import com.google.gson.Gson;
//import com.squareup.okhttp.Call;
//import com.squareup.okhttp.Callback;
//import com.squareup.okhttp.FormEncodingBuilder;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;


/**
 * Created by baobiao on 2016/11/16.
 */

public class OkhttpUtil {
    private static Gson gson;

//    public static void post(String URL, FormEncodingBuilder builder, Callback callback) {
//
//        OkHttpClient okHttpClient = new OkHttpClient();
//        final Request request = new Request.Builder()
//                .url(URL)
//                .post(builder.build())
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(callback);
//
//    }

    public static Gson getGsoninstance() {

        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
}
