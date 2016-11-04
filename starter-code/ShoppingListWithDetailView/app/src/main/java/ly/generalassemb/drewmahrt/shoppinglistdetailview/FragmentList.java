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
 * Created by KorbBookProReturns on 11/1/16.
 */

public class FragmentList extends Fragment {

    private RecyclerView mRecyclerView;
    private List<ShoppingItem> mShoppingItems;
    private OnItemSelectedListener mListener;

    public interface OnItemSelectedListener{
        void onItemSelected(ShoppingItem selectedItem);
    }

    public static Fragment newInstance(Bundle bundle, OnItemSelectedListener listener){
        FragmentList fragmentList = new FragmentList();
        fragmentList.setArguments(bundle);
        fragmentList.mListener = listener;
        return fragmentList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_fragment);

        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(this.getContext());
        mShoppingItems = db.getShoppingList();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new ShoppingListAdapter(mShoppingItems, mListener));

    }
}
