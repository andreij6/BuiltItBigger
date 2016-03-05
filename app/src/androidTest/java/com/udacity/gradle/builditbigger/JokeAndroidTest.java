package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JokeAndroidTest extends AndroidTestCase {

    String mResult;

    public void testJokeFetches(){
        mResult = "";
        CountDownLatch signal = new CountDownLatch(1);

        final JokeAsyncTask myTask = new JokeAsyncTask(){
            @Override
            protected void onPostExecute(String joke) {
               mResult = joke;
            }
        };

        myTask.execute(getContext());

        try {
            signal.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue("Happyness", true);
        assertTrue("Result: " + mResult, mResult.length() > 0);
    }
}
