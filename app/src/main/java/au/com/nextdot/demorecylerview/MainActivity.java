package au.com.nextdot.demorecylerview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/*
    add dependencies 'compile 'com.squareup.picasso:picasso:2.5.2'

 */
public class MainActivity extends Activity {

    RecyclerView recyclerView;
    Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new VerticalSpace(20));
        mAdapter = new Adapter(this);
        recyclerView.setAdapter(mAdapter);

        feedData();
    }
    
    private void feedData() {
        String[] imageUrls = {"image_url_1", "image_url_2", "image_url_3", "image_url_4"};
        String[] titles = {"t1", "t2", "t3", "t4"};
        String[] descriptions = {"d1","d2","d3","d4"};
        List<ItemDataModels> itemDataModels = new ArrayList<>();

            for (int j = 0; j < titles.length; j++) {
                ItemDataModels itemDataModel = new ItemDataModels(imageUrls[j], titles[j], descriptions[j]);
                itemDataModels.add(itemDataModel);
            }

        mAdapter.addModels(itemDataModels);
    }
}
