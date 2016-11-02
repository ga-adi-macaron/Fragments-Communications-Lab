package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jonlieblich on 11/1/16.
 */

public class DetailFragment extends Fragment {

    public static Fragment newInstance(Bundle bundle) {
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

        TextView nameText = (TextView)view.findViewById(R.id.item_name);
        TextView descriptionText = (TextView)view.findViewById(R.id.item_description);
        TextView priceText = (TextView)view.findViewById(R.id.item_price);
        TextView typeText = (TextView)view.findViewById(R.id.item_type);

        nameText.setText(getArguments().getString("NAME"));
        descriptionText.setText(getArguments().getString("DESC"));
        priceText.setText(getArguments().getString("PRICE"));
        typeText.setText(getArguments().getString("TYPE"));
    }
}
