package com.example.profile.listviewb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.profile.R;

import java.util.List;

public class SVListAdapter extends BaseAdapter {

    List<SinhVien> lstdataSource;
    private LayoutInflater inflater;
    private Context context;

    public SVListAdapter(List<SinhVien> lstdataSource, Context context) {
        this.lstdataSource = lstdataSource;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public class  SVViewHolder{
        ImageView svavatar ;
        TextView svname ;
        TextView svinclass;
    }
    @Override
    public int getCount() {
        return lstdataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return lstdataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SVViewHolder svViewHolder = new SVViewHolder();
        //XML->
        view = inflater.inflate(R.layout.sinhvien_item, null);

        svViewHolder.svavatar = view.findViewById(R.id.sv_avatar_imageView);
        svViewHolder.svname = view.findViewById(R.id.sv_name);
        svViewHolder.svinclass = view.findViewById(R.id.sv_class);
        view.setTag(svViewHolder);

        //Set item's data
        SinhVien sinhvien = lstdataSource.get(i);
        svViewHolder.svname.setText(sinhvien.getTen());
        svViewHolder.svinclass.setText("Study in: " + sinhvien.getLop());
        svViewHolder.svavatar.setImageResource(sinhvien.getAvatarImgId());


        return view;
    }

}
