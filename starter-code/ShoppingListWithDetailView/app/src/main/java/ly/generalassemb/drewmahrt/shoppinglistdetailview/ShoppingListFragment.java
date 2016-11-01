package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NikitaShuvalov on 11/1/16.
 */

public class ShoppingListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private onShoppingListClickListener mListener;

    public interface onShoppingListClickListener{
        public void onShoppingListClick(int position);
    }

    public static ShoppingListFragment newInstance(Bundle bundle, onShoppingListClickListener listener) {
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
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new ShoppingListAdapter(ShoppingSQLiteOpenHelper.getInstance(getContext()).getShoppingList(),mListener));
    }
}
