package com.pj.test.testproject;


import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import java.io.File;

public class ShowPdfAcitivty extends Activity implements OnPageChangeListener{
//	public static String pdfName = "file:///android_asset/603111_20160413_12.pdf";
	public static String pdfName = Environment.getExternalStorageDirectory()+"/sse/603111_20160430_1.pdf";
	int pageNumber = 1;
	PDFView pdfView; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.show_pdf_layout);
		
		pdfView = (PDFView)findViewById(R.id.pdfView);
		display(pdfName,true);
		
	}
	private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage) pageNumber = 1;
        setTitle(pdfName = assetFileName);
		File file = new File(assetFileName);
        pdfView.
        fromFile(file)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableSwipe(true)
                .showMinimap(true)
                .load();
    }
	@Override
	public void onPageChanged(int page, int pageCount) {
		
	}

}
