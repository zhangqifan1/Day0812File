package com.example.administrator.day0812file;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String path = Environment.getExternalStorageDirectory().getPath();
    /**
     * 写文件
     */
    private Button mButWrite;
    /**
     * 读文件
     */
    private Button mButRead;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        file = new File(path,"stu.text");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        mButWrite = (Button) findViewById(R.id.butWrite);
        mButWrite.setOnClickListener(this);
        mButRead = (Button) findViewById(R.id.butRead);
        mButRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butWrite:
                try {
                    FileWriter writer=new FileWriter(file,true);
                    writer.write("万新就业,高薪就业");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.butRead:
                try {
                    FileReader reader=new FileReader(file);
                    BufferedReader reader1=new BufferedReader(reader);
                    String str="";
                    while((str=reader1.readLine())!=null){
                        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
