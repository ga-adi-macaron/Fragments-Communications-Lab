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
 * Created by drewmahrt on 10/31/16.
 */

public class ShoppingListFragment extends Fragment {
    private OnShoppingItemSelectedListener mListener;

    public interface OnShoppingItemSelectedListener{
        void onItemSelected(int selectedItem);
    }

    public static Fragment newInstance(Bundle bundle, OnShoppingItemSelectedListener listener){
        ShoppingListFragment fragment = new ShoppingListFragment();
        fragment.setArguments(bundle);
        fragment.mListener = listener;
        return fragment;
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
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.shopping_list_recyclerview);


        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(getContext());
        List<ShoppingItem> shoppingList = db.getShoppingList();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new ShoppingListAdapter(shoppingList,mListener));
    }
}
