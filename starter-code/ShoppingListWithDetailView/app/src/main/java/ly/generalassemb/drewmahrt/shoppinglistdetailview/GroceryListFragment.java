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
 * Created by Scott Lindley on 11/1/2016.
 */

public class GroceryListFragment extends Fragment{
    private OnItemSelectedListener mListener;
    private RecyclerView mRecyclerView;
    private List<ShoppingItem> mShoppingList;


    public interface OnItemSelectedListener{
        public void onItemSelected(ShoppingItem itemSelected);
    }

    public static Fragment newInstance(Bundle bundle, OnItemSelectedListener listener){
        GroceryListFragment fragment = new GroceryListFragment();
        fragment.setArguments(bundle);
        fragment.mListener = listener;
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grocery_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(getContext());
        mShoppingList = db.getShoppingList();

        mRecyclerView = (RecyclerView)view.findViewById(R.id.shopping_list_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(new ShoppingListAdapter(mShoppingList, mListener));
    }
}
