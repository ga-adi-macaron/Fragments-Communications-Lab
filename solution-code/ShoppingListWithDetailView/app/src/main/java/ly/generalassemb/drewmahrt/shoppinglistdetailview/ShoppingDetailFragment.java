package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by drewmahrt on 10/31/16.
 */

public class ShoppingDetailFragment extends Fragment {
    public static Fragment newInstance(Bundle bundle){
        ShoppingDetailFragment fragment = new ShoppingDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView name = (TextView) view.findViewById(R.id.detail_name);
        TextView description = (TextView) view.findViewById(R.id.detail_description);
        TextView price = (TextView) view.findViewById(R.id.detail_price);
        TextView category = (TextView) view.findViewById(R.id.detail_category);

        // Get ID of selected item
        int selectedItemId = getArguments().getInt("selected_item", -1);

        // If we don't have a valid ID, no reason to continue
        if (selectedItemId == -1) {
            Log.d("DetailActivity", "onCreate: No ID passed on the intent!");
            getActivity().getSupportFragmentManager().popBackStack();
        }

        // Get the selected item from the database.
        // Write a new method in the open helper for this.
        ShoppingItem selectedItem = ShoppingSQLiteOpenHelper.getInstance(getContext())
                .getShoppingItemById(selectedItemId);

        // If unable to retrieve item from database, no reason to continue
        if (selectedItem == null) {
            Log.d("DetailActivity", "onCreate: Unable to get item from database!");
            getActivity().getSupportFragmentManager().popBackStack();
        }

        // Populate the TextViews
        name.setText(selectedItem.getName());
        description.setText(selectedItem.getDescription());
        category.setText(selectedItem.getType());

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        double priceValue = Double.valueOf(selectedItem.getPrice());
        price.setText(currencyFormat.format(priceValue));
    }
}
