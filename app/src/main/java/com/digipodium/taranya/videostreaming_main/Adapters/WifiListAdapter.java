package com.digipodium.taranya.videostreaming_main.Adapters;

import android.content.Intent;
import android.net.wifi.ScanResult;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.digipodium.taranya.videostreaming_main.R;

import java.util.List;




public class WifiListAdapter extends RecyclerView.Adapter<WifiListAdapter.ViewHolder> {

    private final List<ScanResult> mDataset;

    class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView mTextView;

        ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.name_wifi);
            view = v.findViewById(R.id.click);
        }
    }

    public WifiListAdapter(List<ScanResult> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public WifiListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_wifi_item, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ScanResult result = mDataset.get(position);
        holder.mTextView.setText(result.SSID);
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = holder.mTextView.getText().toString();

                Intent intent=new Intent(holder.mTextView.getContext(), clicktoconnect.class);
                intent.putExtra("ssid", s);
                holder.mTextView.getContext().startActivity(intent);

                Toast.makeText(holder.mTextView.getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
