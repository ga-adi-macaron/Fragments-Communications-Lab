package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements ShoppingListFragment.OnShoppingItemListener{

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

    //Change to accept a shopping item as parameter and take values for bundle from shopping item
    @Override
    public void onItemSelected(ShoppingItem selectedItem) {
        Bundle bundle = new Bundle();
        bundle.putString("NAME", selectedItem.getName());
        bundle.putString("DESC", selectedItem.getDescription());
        bundle.putString("PRICE", selectedItem.getPrice());
        bundle.putString("TYPE", selectedItem.getType());
        Fragment fragment = DetailFragment.newInstance(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit();
    }
}
