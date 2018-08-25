package me.riddhi.gada.olcademy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.riddhi.gada.olcademy.CourseDesc;
import me.riddhi.gada.olcademy.R;
import me.riddhi.gada.olcademy.model.*;

import java.util.ArrayList;

public class SectionListData extends RecyclerView.Adapter<SectionListData.SingleItemRowHolder> {

    private ArrayList<SingleItem> itemsList;
    private Context mContext;

    public SectionListData(Context context, ArrayList<SingleItem> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {
        SingleItem singleItem = itemsList.get(i);
        holder.tvTitle.setText(singleItem.getName());
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected ImageView itemImage;
        String value;

        public SingleItemRowHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(v.getContext(),CourseDesc.class);
                    value = tvTitle.getText().toString();
                    i.putExtra("CourseName", value);
                    v.getContext().startActivity(i);

                }
            });

        }
    }
}
