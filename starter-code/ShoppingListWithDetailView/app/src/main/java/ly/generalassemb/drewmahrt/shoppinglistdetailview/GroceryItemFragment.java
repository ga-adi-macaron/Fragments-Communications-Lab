package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Scott Lindley on 11/1/2016.
 */

public class GroceryItemFragment extends Fragment{

    public static Fragment newInstance(Bundle bundle){
        GroceryItemFragment fragment = new GroceryItemFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grocery_item,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView name = (TextView)view.findViewById(R.id.detail_name);
        TextView description = (TextView)view.findViewById(R.id.detail_description);
        TextView price = (TextView)view.findViewById(R.id.detail_price);
        TextView category = (TextView)view.findViewById(R.id.detail_category);

        //TODO: GET DATA FROM CUSTOM CLICK METHOD BUNDLE
        name.setText(getArguments().getString(MainActivity.ITEM_NAME_KEY));
        description.setText(getArguments().getString(MainActivity.ITEM_DESCRIPTION_KEY));
        price.setText(getArguments().getString(MainActivity.ITEM_PRICE_KEY));
        category.setText(getArguments().getString(MainActivity.ITEM_NAME_KEY));
    }
}
