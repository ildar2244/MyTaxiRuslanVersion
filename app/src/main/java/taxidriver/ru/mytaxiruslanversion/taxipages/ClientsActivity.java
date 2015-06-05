package taxidriver.ru.mytaxiruslanversion.taxipages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.axel.mysqlphpjson.R;

import taxidriver.ru.mytaxiruslanversion.MapsActivity;


/**
 * Created by Руслан on 30.05.2015.
 */
public class ClientsActivity extends Activity implements View.OnClickListener{
    public Button all_clients;
    public Button drivers_on_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
        all_clients = (Button) findViewById(R.id.btn1);
        drivers_on_map = (Button) findViewById(R.id.btn2);
        all_clients.setOnClickListener(this);
        drivers_on_map.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn1) {
            Intent i = new Intent(getApplicationContext(), AllClientsActivity.class);
            startActivity(i);
        }
        if(v.getId() == R.id.btn2) {
            Intent i = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(i);
        }
    }
}



