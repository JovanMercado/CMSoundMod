package com.modinstaller.oneshotz.soundmod;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ThirdActivity extends Activity {

        public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
        private Button startBtn;
        private ProgressDialog mProgressDialog;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(com.modinstaller.oneshotz.cm13soundmodinstaller.R.layout.activity_third);
            startBtn = (Button)findViewById(com.modinstaller.oneshotz.cm13soundmodinstaller.R.id.button3);
            startBtn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {

                    if (MainActivity.stockSoundLibs){

                        startDownload1();

                    }

                    if (MainActivity.volumeBoost){

                        startDownload2();

                    }

                    if (MainActivity.dolbyDigitalPlus){

                        startDownload3();

                    }
                }
            });
        }

        private void startDownload1() {
            String url = "http://farm1.static.flickr.com/114/298125983_0e4bf66782_b.jpg";
            new DownloadFileAsync().execute(url);
        }
        private void startDownload2() {
            String url = "http://farm1.static.flickr.com/114/298125983_0e4bf66782_b.jpg";
            new DownloadFileAsync().execute(url);
        }
        private void startDownload3() {
            String url = "http://farm1.static.flickr.com/114/298125983_0e4bf66782_b.jpg";
            new DownloadFileAsync().execute(url);
        }
        private void startDownload4() {
            String url = "http://farm1.static.flickr.com/114/298125983_0e4bf66782_b.jpg";
            new DownloadFileAsync().execute(url);
        }
        private void startDownload5() {
            String url = "http://farm1.static.flickr.com/114/298125983_0e4bf66782_b.jpg";
            new DownloadFileAsync().execute(url);
        }
        private void startDownload6() {
            String url = "http://farm1.static.flickr.com/114/298125983_0e4bf66782_b.jpg";
            new DownloadFileAsync().execute(url);
        }
        private void startDownload7() {
            String url = "http://farm1.static.flickr.com/114/298125983_0e4bf66782_b.jpg";
            new DownloadFileAsync().execute(url);
        }
        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
                case DIALOG_DOWNLOAD_PROGRESS:
                    mProgressDialog = new ProgressDialog(this);
                    mProgressDialog.setMessage("Downloading file..");
                    mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mProgressDialog.setCancelable(false);
                    mProgressDialog.show();
                    return mProgressDialog;
                default:
                    return null;
            }
        }

        class DownloadFileAsync extends AsyncTask<String, String, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                showDialog(DIALOG_DOWNLOAD_PROGRESS);
            }

            @Override
            protected String doInBackground(String... aurl) {
                int count;

                try {

                    URL url = new URL(aurl[0]);
                    URLConnection conexion = url.openConnection();
                    conexion.connect();

                    int lenghtOfFile = conexion.getContentLength();
                    Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

                    InputStream input = new BufferedInputStream(url.openStream());
                    OutputStream output = new FileOutputStream(getExternalFilesDir(""));

                    byte data[] = new byte[1024];

                    long total = 0;

                    while ((count = input.read(data)) != -1) {
                        total += count;
                        publishProgress(""+(int)((total*100)/lenghtOfFile));
                        output.write(data, 0, count);
                    }

                    output.flush();
                    output.close();
                    input.close();
                } catch (Exception e) {}
                return null;

            }
            protected void onProgressUpdate(String... progress) {
                Log.d("ANDRO_ASYNC",progress[0]);
                mProgressDialog.setProgress(Integer.parseInt(progress[0]));
            }

            @Override
            protected void onPostExecute(String unused) {
                dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
            }
        }
    }



