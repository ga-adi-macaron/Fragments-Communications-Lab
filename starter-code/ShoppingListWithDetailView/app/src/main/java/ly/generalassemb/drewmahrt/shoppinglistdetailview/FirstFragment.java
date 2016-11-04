package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Serkan on 01/11/16.
 */

public class FirstFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private OnItemSelectedListener mListener;

    //INTERFACE
    public interface OnItemSelectedListener {
        public void onItemSelected(String name, String description, String price, String type);
    }
    //

    public static Fragment newInstance(Bundle bundle, OnItemSelectedListener listener) {
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setArguments(bundle);
        firstFragment.mListener = listener;
        return firstFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(getContext());
        List<ShoppingItem> shoppingList = db.getShoppingList();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new ShoppingListAdapter(shoppingList,mListener));
    }

}
