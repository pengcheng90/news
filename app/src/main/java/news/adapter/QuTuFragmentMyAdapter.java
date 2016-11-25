package news.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baobiao.news.R;

import java.util.List;

import news.beans.QuTuBean;
import news.utils.BitmapUtil;
import news.view.GifView;

/**
 * Created by baobiao on 2016/11/18.
 */
public class QuTuFragmentMyAdapter extends RecyclerView.Adapter<QuTuFragmentMyAdapter.MyViewHolder> implements View.OnClickListener {

    private List<QuTuBean.ResultBean> data;
    private Activity activity;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, QuTuBean.ResultBean data);
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(view, (QuTuBean.ResultBean) view.getTag());
        }
    }


    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public QuTuFragmentMyAdapter(List<QuTuBean.ResultBean> data, Activity activity) {
        this.data = data;
        this.activity = activity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qutu, parent,
                false);

        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.content.setText(data.get(position).getContent());
        String url = data.get(position).getUrl().replace("\\\\", "");
        if (url.indexOf(".gif") != -1) {
            holder.gifView.setVisibility(View.VISIBLE);
            holder.imageView.setVisibility(View.GONE);
            holder.gifView.setMovieResource(activity, url, holder.gifView.getId());
        } else {
            holder.imageView.setVisibility(View.VISIBLE);
            holder.gifView.setVisibility(View.GONE);
            BitmapUtil.displayImage(url, holder.imageView, activity);
        }

//        //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        GifView gifView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.content);
            gifView = (GifView) itemView.findViewById(R.id.gifView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}