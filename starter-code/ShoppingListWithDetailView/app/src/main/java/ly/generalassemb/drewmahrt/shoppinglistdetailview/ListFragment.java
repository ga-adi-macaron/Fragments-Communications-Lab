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
 * Created by colinbradley on 11/1/16.
 */

public class ListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private OnItemSelectedListener mListener;
    List<ShoppingItem> mShoppingList;

    public interface OnItemSelectedListener{
        void onItemSelected(ShoppingItem selected);
    }

    public static Fragment newInstance(Bundle bundle, OnItemSelectedListener listener){
        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(bundle);
        listFragment.mListener = listener;
        return listFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shopping_list, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mShoppingList = ShoppingSQLiteOpenHelper.getInstance(getContext()).getShoppingList();

        mRecyclerView = (RecyclerView)view.findViewById(R.id.shopping_list_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new ShoppingListAdapter(mShoppingList, mListener));
    }
}
