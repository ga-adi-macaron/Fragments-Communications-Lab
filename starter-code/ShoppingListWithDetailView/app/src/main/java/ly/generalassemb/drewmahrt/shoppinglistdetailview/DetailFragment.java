package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ds on 11/1/16.
 */

public class DetailFragment extends Fragment {

    public static final String ID_KEY = "ID_KEY";

    public static Fragment newInstance(Bundle bundle){
        Fragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        int id =  bundle.getInt(ID_KEY);

        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(getContext());
        ShoppingItem shoppingItem = db.getShoppingItemById(id);

        TextView name = (TextView) view.findViewById(R.id.detail_name);
        TextView description = (TextView) view.findViewById(R.id.detail_description);
        TextView price = (TextView) view.findViewById(R.id.detail_price);
        TextView category = (TextView) view.findViewById(R.id.detail_category);
        name.setText(shoppingItem.getName());
        description.setText(shoppingItem.getDescription());
        price.setText(shoppingItem.getPrice());
        category.setText(shoppingItem.getType());


    }
}


