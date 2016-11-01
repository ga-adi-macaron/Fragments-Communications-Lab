package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements ShoppingListFragment.onShoppingListClickListener {
    Button backButt;
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

        backButt = (Button)findViewById(R.id.backbutton);
        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.INVISIBLE);
                Fragment shoppingListFragment = ShoppingListFragment.newInstance(null, MainActivity.this);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,shoppingListFragment).commit();
            }
        });

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
        FrameLayout fragContainer = (FrameLayout) findViewById(R.id.fragment_container);
        fragContainer.setTranslationX(1000); //Put fragcontainer offscreen
        fragContainer.animate().translationXBy(-1000).setDuration(300);//Slide it into view back to where it started.
        backButt.setVisibility(View.VISIBLE); //Makes back button usable after item selection.
    }
}
