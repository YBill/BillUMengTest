package com.bill.umengtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    public void handleClick(View view) {
        /*new ShareAction(MainActivity.this)
                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                .withText("hello")//分享内容
                .setCallback(shareListener)//回调监听器
                .share();*/

        /*UMImage image = new UMImage(MainActivity.this, R.drawable.umeng_socialize_qzone);
        UMImage thumb =  new UMImage(this, R.drawable.umeng_socialize_qq);
        image.setThumb(thumb);
        new ShareAction(ShareActivity.this)
                .setPlatform(SHARE_MEDIA.QQ)
                .withText("hello")
                .withMedia(image)
                .setCallback(shareListener)
                .share();*/

        UMImage thumb =  new UMImage(this, R.drawable.umeng_socialize_qq);
        UMWeb web = new UMWeb("http://www.baidu.com");
        web.setTitle("This is title");//标题
        web.setThumb(thumb);  //缩略图
        web.setDescription("my description");//描述
        new ShareAction(ShareActivity.this)
                .setPlatform(SHARE_MEDIA.QQ)
                .withMedia(web)
                .setCallback(shareListener)
                .share();

        /*new ShareAction(ShareActivity.this).withText("hello").setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener).open();*/
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ShareActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShareActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShareActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };
}