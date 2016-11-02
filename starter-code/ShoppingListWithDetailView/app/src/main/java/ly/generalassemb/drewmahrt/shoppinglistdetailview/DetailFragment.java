package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by justinwells on 11/1/16.
 */

public class DetailFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    public static Fragment newInstance (Bundle bundle) {
        Fragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView name = (TextView)view.findViewById(R.id.detail_name);
        TextView description = (TextView)view.findViewById(R.id.detail_description);
        TextView price = (TextView)view.findViewById(R.id.detail_price);

        name.setText(getArguments().getString("name"));
        description.setText(getArguments().getString("description"));
        price.setText(getArguments().getString("price"));

    }
}
