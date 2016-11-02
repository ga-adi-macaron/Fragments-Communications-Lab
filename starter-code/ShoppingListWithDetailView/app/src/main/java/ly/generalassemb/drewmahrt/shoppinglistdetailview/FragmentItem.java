package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by KorbBookProReturns on 11/1/16.
 */

public class FragmentItem extends Fragment {
    public static Fragment newInstance(Bundle bundle){
        FragmentItem fragmentItem = new FragmentItem();
        fragmentItem.setArguments(bundle);
        return fragmentItem;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView name = (TextView)view.findViewById(R.id.fTextName);
        TextView descript = (TextView)view.findViewById(R.id.fTextDescript);
        TextView price = (TextView)view.findViewById(R.id.fTextPrice);
        TextView type = (TextView)view.findViewById(R.id.fTextType);

        name.setText(getArguments().getString("name"));
        descript.setText(getArguments().getString("descript"));
        price.setText(getArguments().getString("price"));
        type.setText(getArguments().getString("type"));
    }
}
