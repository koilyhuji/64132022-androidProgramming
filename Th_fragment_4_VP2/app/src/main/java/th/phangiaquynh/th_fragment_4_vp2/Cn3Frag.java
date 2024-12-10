package th.phangiaquynh.th_fragment_4_vp2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cn3Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cn3Frag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager2 viewPager;
    private Button btn1, btn2, btn3;

    public Cn3Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cn3Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Cn3Frag newInstance(String param1, String param2) {
        Cn3Frag fragment = new Cn3Frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cn3, container, false);
        viewPager = view.findViewById(R.id.view_pager);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);

        List<String> titles = new ArrayList<>();
        titles.add("Item 1");
        titles.add("Item 2");
        titles.add("Item 3");

        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(new RecyclerView.Adapter<TabViewHolder>() {
            @NonNull
            @Override
            public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_pager_page, parent, false);
                return new TabViewHolder(view) ;
            }

            @Override
            public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {
                holder.title.setText(titles.get(position));
            }

            @Override
            public int getItemCount() {
                return titles.size();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    public static class TabViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public TabViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.page_title);

        }
    }
}