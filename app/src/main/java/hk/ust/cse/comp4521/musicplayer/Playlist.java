package hk.ust.cse.comp4521.musicplayer;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Playlist extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String[] songList = getResources().getStringArray(R.array.Songs);
        this.setListAdapter((ListAdapter) new ArrayAdapter<String>(this, R.layout.playlist_item, R.id.songlist, songList));
        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(getApplicationContext(), MusicActivity.class);
                in.putExtra("songIndex", position);
                setResult(100, in);
                finish();
            }
        });
        ActionBar actionBar = getActionBar();
        if(actionBar != null){
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
