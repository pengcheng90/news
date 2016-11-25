package news.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baobiao.news.R;

import java.io.IOException;
import java.util.List;

import news.beans.CommunityViewBean;
import news.beans.WeiXinChoiceBean;
import news.utils.BitmapUtil;
import news.utils.DisplayUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by baobiao on 2016/11/18.
 */
public class WeinXinFragmentMyAdapter extends RecyclerView.Adapter<WeinXinFragmentMyAdapter.MyViewHolder> implements View.OnClickListener {

    private List<WeiXinChoiceBean.ResultBean.ListBean> data;
    private Activity activity;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, WeiXinChoiceBean.ResultBean.ListBean data);
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(view, (WeiXinChoiceBean.ResultBean.ListBean) view.getTag());
        }
    }


    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public WeinXinFragmentMyAdapter(List<WeiXinChoiceBean.ResultBean.ListBean> data, Activity activity) {
        this.data = data;
        this.activity = activity;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weinxinlist, parent,
                false);

        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String imageUrl = data.get(position).getFirstImg().replaceAll("\\\\", "");
        if (!TextUtils.isEmpty(imageUrl)) {
//            BitmapUtil.displayImage(imageUrl,holder.firstImg,activity);
            BitmapUtil.displayImage(imageUrl, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    //response的body是图片的byte字节
                    byte[] bytes = response.body().bytes();
                    //把byte字节组装成图片
                    final Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    int width = bmp.getWidth();

                    if (width <= DisplayUtils.getScreenWidth(activity) / 2) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                holder.firstImg2.setVisibility(View.VISIBLE);
                                holder.firstImg.setVisibility(View.GONE);
                                holder.firstImg2.setImageBitmap(bmp);
                            }
                        });
                    } else {
//                        Log.i("Bitmap", "width:" + width + "scre" + DisplayUtils.getScreenWidth(activity));
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                holder.firstImg.setVisibility(View.VISIBLE);
                                holder.firstImg2.setVisibility(View.GONE);
                                holder.firstImg.setImageBitmap(bmp);
                            }
                        });
                    }
                }
            });
        }
        holder.source.setText(data.get(position).getSource());
        holder.item_title.setText(data.get(position).getTitle());
        holder.itemView.setTag(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView source;
        TextView item_title;
        ImageView firstImg;
        ImageView firstImg2;

        public MyViewHolder(View itemView) {
            super(itemView);
            source = (TextView) itemView.findViewById(R.id.source);
            item_title = (TextView) itemView.findViewById(R.id.item_title);
            firstImg = (ImageView) itemView.findViewById(R.id.firstImg);
            firstImg2 = (ImageView) itemView.findViewById(R.id.firstImg2);

        }
    }
}