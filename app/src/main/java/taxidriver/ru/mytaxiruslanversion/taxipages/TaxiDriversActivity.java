package taxidriver.ru.mytaxiruslanversion.taxipages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.axel.mysqlphpjson.R;


/**
 * Created by Руслан on 30.05.2015.
 */
public class TaxiDriversActivity extends Activity implements View.OnClickListener{
    public Button all_drivers;
    public Button add_new_driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);
        all_drivers = (Button) findViewById(R.id.btn1);
        add_new_driver = (Button) findViewById(R.id.btn2);
        all_drivers.setOnClickListener(this);
        add_new_driver.setOnClickListener(this);

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
            Intent i = new Intent(getApplicationContext(), AllTaxiListActivity.class);
            startActivity(i);
        }
        if(v.getId() == R.id.btn2) {
            Intent i = new Intent(getApplicationContext(), NewTaxiActivity.class);
            startActivity(i);
        }
    }
}



