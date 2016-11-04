package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by colinbradley on 11/1/16.
 */

public class DetailFragment extends Fragment {
    public static final String NAME_KEY = "name";
    public static final String DESCRIPTION_KEY = "description";
    public static final String PRICE_KEY = "price";
    public static final String TYPE_KEY = "type";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        return v;
    }

    public static Fragment newInstance(Bundle bundle){
        Fragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        TextView name = (TextView) view.findViewById(R.id.detail_name);
        TextView description = (TextView) view.findViewById(R.id.detail_description);
        TextView price = (TextView) view.findViewById(R.id.detail_price);
        TextView type = (TextView) view.findViewById(R.id.detail_category);

        name.setText(bundle.getString(NAME_KEY));
        description.setText(bundle.getString(DESCRIPTION_KEY));
        price.setText(bundle.getString(PRICE_KEY));
        type.setText(bundle.getString(TYPE_KEY));
    }
}
