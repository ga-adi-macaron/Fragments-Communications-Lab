package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements ShoppingListFragment.onShoppingListClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        //Setup the RecyclerView
        Fragment shoppingListFragment = ShoppingListFragment.newInstance(null, this);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,shoppingListFragment).commit();


    }

    @Override
    public void onShoppingListClick(int position) {
        Bundle bundle = new Bundle();
        ShoppingItem shoppingItem = ShoppingSQLiteOpenHelper.getInstance(this).getShoppingList().get(position);
        bundle.putString("name", shoppingItem.getName());
        bundle.putString("category", shoppingItem.getType());
        bundle.putString("price", shoppingItem.getPrice());
        bundle.putString("description", shoppingItem.getDescription());

        Fragment fragment = DetailFragment.newInstance(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
    }
}
