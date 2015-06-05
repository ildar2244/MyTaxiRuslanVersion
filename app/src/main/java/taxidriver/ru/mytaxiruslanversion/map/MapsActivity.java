package taxidriver.ru.mytaxiruslanversion.map;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.axel.mysqlphpjson.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import taxidriver.ru.mytaxiruslanversion.clientpages.ClientLocation;


public class MapsActivity extends FragmentActivity {

    SupportMapFragment mapFragment;
    GoogleMap map;
    //final String TAG = "myLogs";
    Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        map = mapFragment.getMap();
        if (map == null) {
            finish();
            return;
        }
        init();
    }

    private void init() {

        //map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        ClientLocation gpsCL = new ClientLocation(this);
        double latitude = gpsCL.getLatitude();
        double longitude = gpsCL.getLongitude();

        map.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .title("Здесь Вы"));

        /*if(gpsCL.canGetLocation()){

            map.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude, longitude))
                    .title("Здесь Вы"));

        }else{

            gpsCL.showSettingsAlert();
        }*/

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude))
                .zoom(5)
                .bearing(45)
                .tilt(20)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.moveCamera(cameraUpdate);
    }

    public void onClickTest(View view) {

    }
}
