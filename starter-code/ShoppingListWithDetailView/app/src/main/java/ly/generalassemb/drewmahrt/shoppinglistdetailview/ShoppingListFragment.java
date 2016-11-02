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
 * Created by jonlieblich on 11/1/16.
 */

public class ShoppingListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private OnShoppingItemListener mListener;
    private List<ShoppingItem> mShoppingItems;

    public interface OnShoppingItemListener {
        void onItemSelected(ShoppingItem selectedItem);
    }

    public static Fragment newInstance(Bundle bundle, OnShoppingItemListener listener) {
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
        mRecyclerView = (RecyclerView)view.findViewById(R.id.shopping_recycler);
        mShoppingItems = ShoppingSQLiteOpenHelper.getInstance(getContext()).getShoppingList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new ShoppingListAdapter(mShoppingItems, mListener));
    }
}
