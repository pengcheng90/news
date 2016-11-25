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

import news.beans.CaiJingViewBean;
import news.beans.TopViewBean;
import news.utils.BitmapUtil;

/**
 * Created by baobiao on 2016/11/18.
 */
public class CaiJingViewMyAdapter extends RecyclerView.Adapter<CaiJingViewMyAdapter.MyViewHolder> implements View.OnClickListener{

    private List<CaiJingViewBean.ResultBean.DataBean> data;
    private Activity activity;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, CaiJingViewBean.ResultBean.DataBean data);
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(view,(CaiJingViewBean.ResultBean.DataBean)view.getTag());
        }
    }


    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public CaiJingViewMyAdapter(List<CaiJingViewBean.ResultBean.DataBean> data, Activity activity) {
        this.data=data;
        this.activity=activity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topview, parent,
                false);

        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.author_name.setText("来源：" + data.get(position).getAuthor_name());
        BitmapUtil.displayImage(data.get(position).getThumbnail_pic_s(), holder.pic, activity);
        //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author_name;
        ImageView pic;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            author_name = (TextView) itemView.findViewById(R.id.author_name);
            pic = (ImageView) itemView.findViewById(R.id.pic);

        }
    }
}