package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements FragmentList.OnItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        Fragment listFragment = FragmentList.newInstance(null, this);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,listFragment).commit();
    }

    @Override
    public void onItemSelected(ShoppingItem selectedItem) {
        Bundle bundle = new Bundle();
        bundle.putString("name",selectedItem.getName());
        bundle.putString("descript",selectedItem.getDescription());
        bundle.putString("price",selectedItem.getPrice());
        bundle.putString("type",selectedItem.getType());

        Fragment fragment = FragmentItem.newInstance(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();

    }
}
