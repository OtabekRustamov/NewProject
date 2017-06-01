package com.example.root.newproject;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> imageList;
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageList = new ArrayList<>();
        imageList.add("https://s-media-cache-ak0.pinimg.com/736x/a4/f5/72/a4f57278c9faa0aa700ce18d67f50e6d.jpg");
        imageList.add("http://e0.365dm.com/15/11/16-9/20/cristiano-ronaldo-film_3372321.jpg?20151103124831");
        imageList.add("http://givemesport.azureedge.net/images/17/04/28/51e3cec5b56e7db3d5882703250a96d8/960.jpg");
        imageList.add("https://cdn-s3.si.com/s3fs-public/images/2014-0608-Neymar.jpg");
        imageList.add("http://gazettereview.com/wp-content/uploads/2016/09/what-happened-to-jim-carrey.jpg");
        imageList.add("http://i.huffpost.com/gen/1893475/thumbs/o-JAMES-RODRIGUEZ-570.jpg?6");
        imageList.add("http://cdn.images.express.co.uk/img/dynamic/67/590x/Arjen-Robben-621787.jpg");
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/3/32/JeromeBoateng_Lviv2015.jpg");
        imageList.add("http://1tvs492zptzq380hni2k8x8p.wpengine.netdna-cdn.com/wp-content/uploads/2017/03/GettyImages-652594168.jpg");
        imageList.add("http://i1.mirror.co.uk/incoming/article9296790.ece/ALTERNATES/s615/Bayern-Munichs-defender-Mats-Hummels-ap.jpg");
        imageList.add("http://www.laptopmag.com/images/uploads/ppress/44878/toshiba-kirabook-2015-300x194.jpg");
        imageList.add("https://images-na.ssl-images-amazon.com/images/I/81bg2pCysDL._SL1500_.jpg");
        imageList.add("http://images.locanto.net/1292279983/Zone-Of-Apple-Laptops-Repair-Macbook-Pro-Macbook-Air-Repair_2.jpg");
        imageList.add("http://www.junkmail.co.za/blog/wp-content/uploads/2014/10/samsung-laptop-535x450.jpg");
        imageList.add("http://store.hp.com/UKStore/Html/Merch/Images/c05212890_209x189.jpg");
        imageList.add("http://media.webcollage.net/rwvfp/wc/cp/16603591/module/dellbtoc//_cp/products/i7347-7550slv/tab-3e23a95a-a192-441c-90c0-e60e7478fc40/55096ea6-0948-4c69-9c79-3feb1d62669b.jpg.w960.jpg");

        recyclerView = (RecyclerView) findViewById(R.id.mainActivity_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyAdapter());

    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.recycler_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            Glide.with(MainActivity.this)
                    .load(imageList.get(position))
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            count++;
                            if (count == imageList.size()) {
                                Toast.makeText(MainActivity.this, "Download has finished", Toast.LENGTH_SHORT).show();
                            }
                            return false;
                        }
                    })
                    .into(holder.imageView1);
        }

        @Override
        public int getItemCount() {
            return imageList.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView1;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView1 = (ImageView) itemView.findViewById(R.id.iv_one);

        }
    }
}
