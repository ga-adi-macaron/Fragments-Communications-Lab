package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        Fragment listFragment = ListFragment.newInstance(null,this);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,listFragment).commit();

    }

    @Override
    public void OnClick(ShoppingItem item) {
        Bundle bundle = new Bundle();
        bundle.putString("name",item.getName());
        bundle.putString("description",item.getDescription());
        bundle.putString("price",item.getPrice());
        bundle.putString("type",item.getType());
        Fragment detailFragment = DetailFragment.newInstance(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,detailFragment).commit();

    }
}
