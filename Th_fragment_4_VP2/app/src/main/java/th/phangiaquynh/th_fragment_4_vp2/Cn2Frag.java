package th.phangiaquynh.th_fragment_4_vp2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cn2Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cn2Frag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<String> cn2ArrayList;
    RecyclerView recyclerView;
    public Cn2Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cn2Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Cn2Frag newInstance(String param1, String param2) {
        Cn2Frag fragment = new Cn2Frag();
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
        View view = inflater.inflate(R.layout.fragment_cn2, container, false);
        cn2ArrayList=getCn2ArrayList();
        recyclerView=view.findViewById(R.id.recyCn2);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerView.Adapter<Item>() {
            @NonNull
            @Override
            public Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater=LayoutInflater.from(getActivity());
                View vItem=inflater.inflate(R.layout.items,parent,false);
                Item holderCreated =new Item(vItem);

                return holderCreated;
            }

            @Override
            public void onBindViewHolder(@NonNull Item holder, int position) {
                String cn2=cn2ArrayList.get(position);

                holder.textView.setText(cn2);


            }

            @Override
            public int getItemCount() {
                return cn2ArrayList.size();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    class Item extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public Item(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.img_cn2);
            textView=itemView.findViewById(R.id.tv_cn2);
        }
    }
    ArrayList<String> getCn2ArrayList(){
        ArrayList<String> listData=new ArrayList<>();
        listData.add("Tóm tắt 1");
        listData.add("Tóm tắt 2");
        listData.add("Tóm tắt 3");
        listData.add("Tóm tắt 4");
        listData.add("Tóm tắt 5");

        return listData;
    }
}