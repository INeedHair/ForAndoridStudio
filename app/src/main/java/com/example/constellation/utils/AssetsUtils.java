package com.example.constellation.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.constellation.bean.StarInfoBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*读取assets文件夹当中的数据的工具类*/
public class AssetsUtils {
    private static Map<String,Bitmap> LogoImgMap;
    private static Map<String,Bitmap> contentLogoImgMap;

    /*读取jason字符串d。存放到字符串中*/
    public static String getJsonFromAssets(Context context,String filename){
        //1.获取Assets文件夹管理器
        AssetManager am = context.getResources().getAssets();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //2.获取文件输入流
        try  {
            InputStream inputStream = am.open(filename);
            //读取内容存放到内存流当中
            int hasRead=0;
            byte[]buf=new byte[1024];
           while (true){
               hasRead=inputStream.read(buf);
               if (hasRead==-1){
                   break;
               }
               baos.write(buf,0,hasRead);
           }
           String s=baos.toString();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*读取Assets文件夹下的图片，返回bitmap对象*/
    public static Bitmap getBitmapFromAssets(Context context,String filename){
        Bitmap bitmap=null;
        //获取文件夹管理者
        AssetManager am = context.getResources().getAssets();
        try{
            InputStream is=am.open(filename);
            //通过位图管理器，将输入流转换成位图对象
            bitmap= BitmapFactory.decodeStream(is);
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    //将Asses文件夹中的图片一起读取放置到内存中，便于管理
    public static void saveBitmapFromAssets(Context context , StarInfoBean starInfoBean){
        LogoImgMap=new HashMap<>();
        contentLogoImgMap=new HashMap<>();
        List<StarInfoBean.StarinfoBean> starList = starInfoBean.getStarinfo();
        for (int i=0;starList.size()>i;i++){
            String logoname = starList.get(i).getLogoname();
            String filename="xzlogo/"+logoname+".png";
            Bitmap logoBm = getBitmapFromAssets(context, filename);
            LogoImgMap.put(logoname,logoBm);

            String contentName="xzcontentlogo/"+logoname+".png";
            Bitmap bitmap = getBitmapFromAssets(context, contentName);
            contentLogoImgMap.put(logoname,bitmap);
        }
    }

    public static Map<String, Bitmap> getContentLogoImgMap() {
        return contentLogoImgMap;
    }

    public static Map<String, Bitmap> getLogoImgMap() {
        return LogoImgMap;
    }
}
