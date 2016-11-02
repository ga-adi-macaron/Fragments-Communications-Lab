package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingItemViewHolder> {
    private List<ShoppingItem> mShoppingItems;
    ShoppingListFragment.OnShoppingItemListener mListener;

    public ShoppingListAdapter(List<ShoppingItem> shoppingItems, ShoppingListFragment.OnShoppingItemListener listener) {
        mShoppingItems = shoppingItems;
        mListener = listener;
    }

    @Override
    public ShoppingItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShoppingItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final ShoppingItemViewHolder holder, final int position) {
        ShoppingItem item = mShoppingItems.get(position);
        holder.mNameTextView.setText(item.getName());

        holder.mActivityDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemSelected(mShoppingItems.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShoppingItems.size();
    }
}
