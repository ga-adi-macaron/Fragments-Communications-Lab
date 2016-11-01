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
 * Created by Joe on 11/1/16.
 */

public class ListFragment extends Fragment {

    List<ShoppingItem> mShoppingItems;
    RecyclerView mRecyclerView;
    private OnItemClickListener mListener;

    public static Fragment newInstance(Bundle bundle, OnItemClickListener listener){
        ListFragment fragment = new ListFragment();
        fragment.setArguments(bundle);
        fragment.mListener = listener;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mShoppingItems = ShoppingSQLiteOpenHelper.getInstance(getContext()).getShoppingList();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new ShoppingListAdapter(mShoppingItems,mListener));
    }

    interface OnItemClickListener{
        void OnClick(ShoppingItem item);
    }
}
