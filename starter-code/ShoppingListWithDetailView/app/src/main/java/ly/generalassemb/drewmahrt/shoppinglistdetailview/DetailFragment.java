package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by NikitaShuvalov on 11/1/16.
 */

public class DetailFragment extends Fragment {

    public static DetailFragment newInstance(Bundle bundle) {
        DetailFragment fragment = new DetailFragment();
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
        ShoppingItem item = ShoppingSQLiteOpenHelper.getInstance(view.getContext()).getShoppingItemById(getArguments().getInt("id"));


        TextView nameView = (TextView) view.findViewById(R.id.detail_name);
        TextView descView = (TextView) view.findViewById(R.id.detail_description);
        TextView catView = (TextView)view.findViewById(R.id.detail_category);
        TextView priceView = (TextView)view.findViewById(R.id.detail_price);

        //This was done with a bundle, after rereading the requirements realized the details weren't supposed to be passed by a bundle(intent?)?
//        nameView.setText(getArguments().getString("name"));
//        descView.setText(getArguments().getString("description"));
//        catView.setText(getArguments().getString("category"));
//        priceView.setText(getArguments().getString("price"));

        nameView.setText(item.getName());
        descView.setText(item.getDescription());
        catView.setText(item.getDescription());
        priceView.setText(item.getPrice());
    }
}
