package com.example.aircraftwar;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*加减乘除运算
    EditText e;
    TextView textView;
    private EditText editText;
    private EditText editText2;
    private TextView result;
    private TextView textN;
    private Button add;
    private Button remove;
    private Button shen;
    private Button chu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = (EditText)findViewById(R.id.mytext);
        textView = (TextView)findViewById(R.id.textView);
        Button b = (Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Rcc",e.getText().toString());
                textView.setText("输入" + e.getText().toString());
            }
        });

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);

        result = (TextView)findViewById(R.id.textView7);
        textN = (TextView)findViewById(R.id.textView3);

        add = (Button)findViewById(R.id.button);
        remove = (Button)findViewById(R.id.button6);
        shen = (Button)findViewById(R.id.button3);
        chu = (Button)findViewById(R.id.button5);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer a = Integer.parseInt(editText.getText().toString());
                Integer b = Integer.parseInt(editText2.getText().toString());
                Log.i("Rcc",a.toString());
                Log.i("Rcc",b.toString());
                textN.setText("+");
                result.setText(String.valueOf(a + b));
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer a = Integer.parseInt(editText.getText().toString());
                Integer b = Integer.parseInt(editText2.getText().toString());
                textN.setText("-");
                result.setText(String.valueOf(a - b));
            }
        });

        shen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer a = Integer.parseInt(editText.getText().toString());
                Integer b = Integer.parseInt(editText2.getText().toString());
                textN.setText("*");
                result.setText(String.valueOf(a * b));
            }
        });

        chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer a = Integer.parseInt(editText.getText().toString());
                Integer b = Integer.parseInt(editText2.getText().toString());
                textN.setText("/");
                result.setText(String.valueOf(a / b));
            }
        });
    }*/

    private ExpandableListView elistView = null;
    private ExpandableListAdapter adapter = null;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        this.elistView = (ExpandableListView)findViewById(R.id.elistView);
        this.adapter = new MyExpandableListAdpter(this);
        this.elistView.setAdapter(this.adapter);
        registerForContextMenu(this.elistView);
        this.elistView.setOnChildClickListener(new OnChildClickListenerImpl());
        this.elistView.setOnChildClickListener(new OnGroupClickListenerImpl());
        this.elistView.setOnChildClickListener(new OnGroupCollapseListenterImpl());
        this.elistView.setOnChildClickListener(new OnGroupExpandListenterImpl());
    }

    private class OnChildClickListenerImpl implements View.OnClickListener, ExpandableListView.OnChildClickListener {
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id){
            Toast.makeText(MainActivity.this, "子选项 groupPosition="+groupPosition+" childPosition"+childPosition, Toast.LENGTH_SHORT);
            return false;
        }
        @Override
        public void onClick(View v) {
        }
    }

    private class OnGroupClickListenerImpl implements View.OnClickListener, ExpandableListView.OnChildClickListener {
        public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id){
            Toast.makeText(MainActivity.this, "分组 groupPosition="+groupPosition, Toast.LENGTH_SHORT).show();
            return false;
        }
        @Override
        public void onClick(View v) {
        }

        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            return false;
        }
    }
    private class OnGroupCollapseListenterImpl implements ExpandableListView.OnChildClickListener {

        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            Toast.makeText(MainActivity.this, "关闭分组 groupPosition="+groupPosition, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private class OnGroupExpandListenterImpl implements ExpandableListView.OnChildClickListener {
        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            Toast.makeText(MainActivity.this, "打开分组 groupPosition="+groupPosition, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        onCreateContextMenu(menu, view, menuInfo);
        ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo) menuInfo;
        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        int group = ExpandableListView.getPackedPositionGroup(info.packedPosition);
        int child = ExpandableListView.getPackedPositionChild(info.packedPosition);
        Toast.makeText(MainActivity.this, "打开分组 type="+type+" group="+group+" child="+child, Toast.LENGTH_SHORT).show();
    }
}