package nico.styTool;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import com.bumptech.glide.Glide;
//impo/rt com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by luxin on 15-12-10.
 *  http://luxin.gitcafe.io
 */
public class ImageChoseAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private List<String> mDatas;
    private String dirPath;

    private static final int DEFAULT_MAX_ITEM=9;
    public static Set<String> mSelectImg=new HashSet<String>();
    public ImageChoseAdapter(Context context,List<String> list,String dirPath){
        this.mContext=context;
        this.mDatas=list;
        this.dirPath=dirPath;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView==null){
        //  /  convertView=inflater.inflate(R.layout.lxw_item_chose_img,null);
            holder=new ViewHolder();
           /// holder.mImage= (ImageView) convertView.findViewById(R.id.id_lxw_item_chose_img_image);
         //   holder.mSelect= (ImageButton) convertView.findViewById(R.id.id_lxw_item_chose_img_select);
            convertView.setTag(holder);
        }else{
           holder= (ViewHolder) convertView.getTag();
        }

       // holder.mImage.setImageResource(R.drawable.pictures_no);
       // holder.mSelect.setImageResource(R.drawable.ic_done_white_24dp);
        holder.mImage.setColorFilter(null);

        //ImageLoader.getInstance(3, ImageLoader.Type.LIFO).loaderImage(dirPath + "/" + mDatas.get(position), holder.mImage, false);

     //   Glide.with(mContext).load(dirPath+"/"+mDatas.get(position)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.mImage);
        final String filePath=dirPath+"/"+mDatas.get(position);

        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mChangeImgSize!=null){
                    mChangeImgSize.ChangeSlect(mSelectImg);
                }

                if(mSelectImg.contains(filePath)){
                    holder.mImage.setColorFilter(null);
                    //holder.mSelect.setImageResource(R.drawable.ic_done_white_24dp);
                    mSelectImg.remove(filePath);
                }else{
                    if(mSelectImg.size()>DEFAULT_MAX_ITEM-1){
                      //  Toast.makeText(mContext,"最多选择9张图片",Toast.LENGTH_SHORT).show();
                    }else {
                        holder.mImage.setColorFilter(Color.parseColor("#77000000"));
                    //   * holder.mSelect.setImageResource(R.drawable.ic_done_white_24dp);
                        mSelectImg.add(filePath);
                    }
                }
            }
        });

        if(mSelectImg.contains(filePath)){
            holder.mImage.setColorFilter(Color.parseColor("#77000000"));
            //holder.mSelect.setImageResource(R.drawable.ic_done_white_24dp);
        }
        return convertView;
    }
    private class ViewHolder{
        ImageView mImage;
        ImageButton mSelect;
    }


    public interface OnChangeImageSize{
        void ChangeSlect(Set<String> mSlectImgs);
    }
    public OnChangeImageSize mChangeImgSize;

    public void setmChangeImgSize(OnChangeImageSize mChangeImgSize) {
        this.mChangeImgSize = mChangeImgSize;
    }
}
