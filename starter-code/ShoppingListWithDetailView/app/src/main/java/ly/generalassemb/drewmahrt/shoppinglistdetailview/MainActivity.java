package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        Fragment firstFragment = FirstFragment.newInstance(null,this);

        //Populate the list of planets
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,firstFragment)
                .commit();
    }

    @Override
    public void onItemSelected(String name, String description, String price, String type) {
        //Replace list fragment with detail fragment
        //Pass selectedPlanet string to detail fragment in a bundle.

        /**
         * DEĞİŞTİR!
         */

        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("description", description);
        bundle.putString("price", price);
        bundle.putString("type", type);
        Fragment secondFragment = SecondFragment.newInstance(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,secondFragment)
                .commit();
    }
}
