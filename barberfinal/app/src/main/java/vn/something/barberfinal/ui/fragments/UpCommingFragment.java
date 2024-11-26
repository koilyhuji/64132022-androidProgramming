package vn.something.barberfinal.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.something.barberfinal.BookingDetail;
import vn.something.barberfinal.R;
import vn.something.barberfinal.adapter.CardAdapterBooking;

public class UpCommingFragment extends Fragment implements CardAdapterBooking.OnItemClickListener{
    private RecyclerView recyclerView;
    private CardAdapterBooking cardAdapter;
    private List<String> dataList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.upcoming_fragment_tab, container, false);
        ///request data from firebase or some shit
        System.out.println("recivedBund");
        recyclerView = root.findViewById(R.id.recyclerViewBookingCardu);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cardAdapter = new CardAdapterBooking(dataList, this);
        recyclerView.setAdapter(cardAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                String item = dataList.get(position);

                if (direction == ItemTouchHelper.LEFT) {
                    dataList.remove(position);
                    cardAdapter.notifyItemRemoved(position);
                    //TODO: add card to sap toi tab
//                    Bundle bundle = new Bundle();
//                    bundle.putString("movedItem", item);
//
//                    UpCommingFragment upCommingFragment = new UpCommingFragment();
//                    upCommingFragment.setArguments(bundle);
//
//                    // Handle fragment transaction
//                    getParentFragmentManager().beginTransaction()
//                            .replace(R.id.fragment_container, anotherFragment)
//                            .addToBackStack(null)
//                            .commit();

                    Toast.makeText(getContext(), "Card moved to another fragment: " + item, Toast.LENGTH_SHORT).show();
                }
            }
        });


        itemTouchHelper.attachToRecyclerView(recyclerView);


        return root;
    }


    @Override
    public void onItemClick(int position) {
        String clickedItem = dataList.get(position);

        Intent intent = new Intent(getContext(), BookingDetail.class);
        intent.putExtra("item", clickedItem);
        startActivity(intent);
    }
}
