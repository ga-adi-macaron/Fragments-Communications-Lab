package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements ShoppingListFragment.OnShoppingItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        Fragment shoppingListFragment = ShoppingListFragment.newInstance(null, this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, shoppingListFragment).commit();

    }

    @Override
    public void onItemSelected(int selectedItem) {
        Bundle bundle = new Bundle();
        bundle.putInt("selected_item", selectedItem);
        Fragment detailFragment = ShoppingDetailFragment.newInstance(bundle);
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, detailFragment)
                .commit();
    }
}
