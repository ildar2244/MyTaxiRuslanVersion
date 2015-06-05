package taxidriver.ru.mytaxiruslanversion.driverpages;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.axel.mysqlphpjson.R;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Руслан on 30.05.2015.
 */
public class NewTaxiActivity extends Activity implements View.OnClickListener{
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_taxi_driver);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        add = (Button) findViewById(R.id.btnAdd);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        InsertData task1 = new InsertData();
        task1.execute(new String[]{"http://javaapp.ru/insert_taxi_drivers_details.php"});

    }

    private class InsertData extends AsyncTask<String, Void, Boolean>{
        ProgressDialog dialog = new ProgressDialog(NewTaxiActivity.this);

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Sending Data...");
            dialog.show();
        }

        @Override
        protected Boolean doInBackground(String... urls) {

            for(String url : urls) {
                try {
                    ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
                    pairs.add(new BasicNameValuePair("FIO", et1.getText().toString()));
                    pairs.add(new BasicNameValuePair("Modele_auto", et2.getText().toString()));
                    pairs.add(new BasicNameValuePair("Driver_location", et3.getText().toString()));
                    pairs.add(new BasicNameValuePair("isFree", et4.getText().toString()));

                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url);
                    post.setEntity(new UrlEncodedFormEntity(pairs));
                    HttpResponse responce = client.execute(post);
                } catch (IOException e) {
                    Toast.makeText(NewTaxiActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                   return  false;
                }
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result == true){
                Toast.makeText(NewTaxiActivity.this, "Insert success", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(NewTaxiActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
            dialog.dismiss();
        }
    }
}
