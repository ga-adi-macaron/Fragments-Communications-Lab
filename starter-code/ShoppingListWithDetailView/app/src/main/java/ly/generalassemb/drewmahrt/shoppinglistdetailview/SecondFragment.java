package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Serkan on 01/11/16.
 */

public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment_detail,container,false);
    }

    public static Fragment newInstance(Bundle bundle) {
        Fragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView name = (TextView) view.findViewById(R.id.detail_name);
        TextView description = (TextView) view.findViewById(R.id.detail_description);
        TextView price = (TextView) view.findViewById(R.id.detail_price);
        TextView type = (TextView) view.findViewById(R.id.detail_category);

        String getName = getArguments().getString("name");
        String getDescription = getArguments().getString("description");
        String getPrice = getArguments().getString("price");
        String getType = getArguments().getString("type");

        name.setText(getName);
        description.setText(getDescription);
        price.setText(getPrice);
        type.setText(getType);

        //Burda bundle'dan datayı alıp set edeceksin.
    }

}
