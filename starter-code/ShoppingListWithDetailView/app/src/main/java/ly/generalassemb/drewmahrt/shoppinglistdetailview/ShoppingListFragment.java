package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds on 11/1/16.
 */

public class ShoppingListFragment extends Fragment {

    public static final String SHOPPING_LIST_KEY = "shoppingList";
    private RecyclerView mRecyclerView;
    private OnItemSelectedListener mListener;

    public interface OnItemSelectedListener{
        void onItemSelected(int id);
    }

    public static Fragment newInstance(Bundle bundle, OnItemSelectedListener listener) {
        ShoppingListFragment fragment = new ShoppingListFragment();
        fragment.setArguments(bundle);
        fragment.mListener = listener;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shopping_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.shopping_list_recyclerview);
        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(getContext());
        List<ShoppingItem> shoppingList = db.getShoppingList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new ShoppingListAdapter(shoppingList, mListener));
    }
}

