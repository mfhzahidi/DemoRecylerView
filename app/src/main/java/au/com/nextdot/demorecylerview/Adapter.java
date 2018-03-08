package au.com.nextdot.demorecylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by sakib on 2/14/2018.
 */

public class Adapter extends RecyclerView.Adapter {

    List<ItemDataModels> itemDataModels;
    Context context;
    public Adapter(Context context)
    {
        this.context=context;
        itemDataModels=new ArrayList<>();
    }
    public void addModels(List<ItemDataModels> itemDataModels) {

        int pos = this.itemDataModels.size();
        this.itemDataModels.addAll(itemDataModels);
        notifyItemRangeInserted(pos, itemDataModels.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View row=inflater.inflate(R.layout.list_row_items,parent,false);
        return new ItemHolder(row);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemDataModels mCurrentItem = itemDataModels.get(position);
        ItemHolder itemHolder = (ItemHolder) holder;
        Picasso.with(context).load(R.drawable.d).resize(900,300).into(((ItemHolder)holder).imageView);
        itemHolder.heading.setText(mCurrentItem.title);
        itemHolder.body.setText(mCurrentItem.description);

    }

    @Override
    public int getItemCount() {
        return itemDataModels.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        TextView heading,body;
        ImageView imageView;

        public ItemHolder(View itemview) {
            super(itemview);
            imageView=itemview.findViewById(R.id.image);
            heading=itemview.findViewById(R.id.heading);
            body=itemview.findViewById(R.id.body);
        }
    }
}
