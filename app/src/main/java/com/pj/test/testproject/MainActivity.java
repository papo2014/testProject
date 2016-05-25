package com.pj.test.testproject;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pj.test.activity.TestActivity;
import com.pj.test.util.DESTool;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_savaData;
    private Button btn_jni;

    static {

        System.loadLibrary("desjni");
        System.loadLibrary("vudroid");
    }

    private Button open_word;
    private Button open_pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_savaData = (Button)findViewById(R.id.btn_savaData);
        btn_savaData.setOnClickListener(this);
        btn_jni = (Button)findViewById(R.id.btn_jni);
        btn_jni.setOnClickListener(this);
        open_word = (Button)findViewById(R.id.open_word);
        open_word.setOnClickListener(this);
        open_pdf = (Button)findViewById(R.id.open_pdf);
        open_pdf.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_savaData:
                Intent intent = new Intent(MainActivity.this,SaveDataActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_jni:
                Intent intent1 = new Intent(MainActivity.this,JniActivity.class);
                startActivity(intent1);
                break;
            case R.id.open_word:
                Intent intent2 = new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent2);
                break;
            case R.id.open_pdf:
                Intent intent3 = new Intent(MainActivity.this,ShowPdfAcitivty.class);
                intent3.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME, Environment.getExternalStorageDirectory()+"/sse/603111_20160430_1.pdf");
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
