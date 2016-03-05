package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.creativejones.andre.jokeactivity.JokeActivity;
import com.example.andre.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Context, Void, String> {

    private MyApi myApiService = null;
    private Context mContext;

    @Override
    protected String doInBackground(Context... params) {
        mContext = params[0];

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/") //used this url because im using Genymotion
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            builder.setApplicationName(mContext.getString(R.string.app_name));
            myApiService = builder.build();
        }

        try {
            return myApiService.provideJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent intent = new Intent(mContext, JokeActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, joke);
        mContext.startActivity(intent);
    }
}
