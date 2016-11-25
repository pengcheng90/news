package news.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by baobiao on 2016/11/21.
 */

public class Okhttp {

    public static void post(String url, Map<String, String> parms, Callback callback) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            FormBody.Builder builder = new FormBody.Builder();
            Set set = parms.keySet();
            for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
                String key = (String) iterator.next();
                String value = (String) parms.get(key);
                builder.add(key, value);
            }

            RequestBody formBody = builder.build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
