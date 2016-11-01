package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements GroceryListFragment.OnItemSelectedListener{
    public static final String ITEM_NAME_KEY = "item_name";
    public static final String ITEM_DESCRIPTION_KEY = "item_description";
    public static final String ITEM_PRICE_KEY = "item_price";
    public static final String ITEM_CATEGORY_KEY = "item_category";


    @Override
    public void onItemSelected(ShoppingItem itemSelected) {
        Bundle bundle = new Bundle();
        bundle.putString(ITEM_NAME_KEY,itemSelected.getName());
        bundle.putString(ITEM_DESCRIPTION_KEY,itemSelected.getDescription());
        bundle.putString(ITEM_PRICE_KEY,itemSelected.getPrice());
        bundle.putString(ITEM_CATEGORY_KEY,itemSelected.getType());

        Fragment groceryItemFragment = GroceryItemFragment.newInstance(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_frame, groceryItemFragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        Fragment groceryListFragment = GroceryListFragment.newInstance(null, this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_frame,groceryListFragment)
                .commit();

    }
}
