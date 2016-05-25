package com.pj.test.testproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Administrator on 2016/4/7.
 */
public class WordViewer extends Activity{

    private File myFile;
    private String htmlPath="/sdcard/sse/a.html";
    private FileOutputStream output;
//    private Range range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        readDOC();
    }


//    /**
//     *  读取word中的内容写到sdcard上的.html文件中
//     */
//    public void readDOC() {
//        InputStream is = null;
//        HWPFDocument document ;
//        try {
//            is = new FileInputStream("/sdcard/sse/2016050515170141477060097.doc");
//            document = new HWPFDocument(is);
//            range = document.getRange();
//            TableIterator tableIterator =new TableIterator(range);
//            myFile = new File(htmlPath);
//            output = new FileOutputStream(myFile);
//            String head = "<html><head><meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" /></head><body>";
//            String tagBegin = "<p>";
//            String tagEnd = "</p>";;
//            output.write(head.getBytes());
//            int numParagraphs = range.numParagraphs();// 得到页面所有的段落数
//            for (int i = 0; i < numParagraphs; i++) { // 遍历段落数
//                Paragraph p = range.getParagraph(i); // 得到文档中的每一个段落
//                if (p.isInTable()) {
//                    int temp = i;
//                    if (tableIterator.hasNext()) {
//                        String tableBegin = "<table style=\"border-collapse:collapse; border:1; bordercolor:black\">";
//                        String tableEnd = "</table>";;
//                        String rowBegin = "<tr>";
//                        String rowEnd = "</tr>";;
//                        String colBegin = "<td>";
//                        String colEnd = "</td>";
//                        Table table = tableIterator.next();
//                        output.write(tableBegin.getBytes());
//                        int rows = table.numRows();
//                        for (int r = 0; r < rows; r++) {
//                            output.write(rowBegin.getBytes());
//                            TableRow row = table.getRow(r);
//                            int cols = row.numCells();
//                            int rowNumParagraphs = row.numParagraphs();
//                            int colsNumParagraphs = 0;
//                            for (int c = 0; c < cols; c++) {
//                                output.write(colBegin.getBytes());
//                                TableCell cell = row.getCell(c);
//                                int max = temp + cell.numParagraphs();
//                                colsNumParagraphs = colsNumParagraphs
//                                        + cell.numParagraphs();
//                                for (int cp = temp; cp < max; cp++) {
//                                    Paragraph p1 = range.getParagraph(cp);
//                                    output.write(tagBegin.getBytes());
//                                    writeParagraphContent(p1);
//                                    output.write(tagEnd.getBytes());
//                                    temp++;
//                                }
//                                output.write(colEnd.getBytes());
//                            }
//                            int max1 = temp + rowNumParagraphs;
//                            for (int m = temp + colsNumParagraphs; m < max1; m++) {
//                                temp++;
//                            }
//                            output.write(rowEnd.getBytes());
//                        }
//                        output.write(tableEnd.getBytes());
//                    }
//                    i = temp;
//                }
//                else {
//                    output.write(tagBegin.getBytes());
//                    writeParagraphContent(p);
//                    output.write(tagEnd.getBytes());
//                }
//            }
//            String end ="</body></html>";
//            output.write(end.getBytes());
//            output.close();
//        } catch (Exception e) {
////            System.out.println(&quot;readAndWrite Exception&quot;);
//        }
//    }
//
//    private void writeParagraphContent(Paragraph p) {
//        try {
//            output.write( p.text().getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    /**
//     * 读取07及以上版本的word文档
//     * 2013-5-15 下午2:38:33 chenhao添加此方法
//     */
//    private void readDOCX() {
//        String river = &quot;&quot;;
//        try {
//            this.myFile = new File(this.htmlPath);// new一个File,路径为html文件
//            this.output = new FileOutputStream(this.myFile);// new一个流,目标为html文件
//            String head = &quot;&lt;!DOCTYPE&gt;&lt;html&gt;&lt;meta charset=\\&quot;utf-8\\&quot;&gt;&lt;body&gt;&quot;;// 定义头文件,我在这里加了utf-8,不然会出现乱码
//            String end = &quot;&lt;/body&gt;&lt;/html&gt;&quot;;
//            String tagBegin = &quot;&lt;p&gt;&quot;;// 段落开始,标记开始?
//            String tagEnd = &quot;&lt;/p&gt;&quot;;// 段落结束
//            String tableBegin = &quot;&lt;table style=\\&quot;border-collapse:collapse\\&quot; border=1 bordercolor=\\&quot;black\\&quot;&gt;&quot;;
//            String tableEnd = &quot;&lt;/table&gt;&quot;;
//            String rowBegin = &quot;&lt;tr&gt;&quot;;
//            String rowEnd = &quot;&lt;/tr&gt;&quot;;
//            String colBegin = &quot;&lt;td&gt;&quot;;
//            String colEnd = &quot;&lt;/td&gt;&quot;;
//            this.output.write(head.getBytes());// 写如头部
//            ZipFile xlsxFile = new ZipFile(new File(this.filePath));
//            ZipEntry sharedStringXML = xlsxFile.getEntry(&quot;word/document.xml&quot;);
//            InputStream inputStream = xlsxFile.getInputStream(sharedStringXML);
//            XmlPullParser xmlParser = Xml.newPullParser();
//            xmlParser.setInput(inputStream, &quot;utf-8&quot;);
//            int evtType = xmlParser.getEventType();
//            boolean isTable = false; // 是表格 用来统计 列 行 数
//            boolean isSize = false; // 大小状态
//            boolean isColor = false; // 颜色状态
//            boolean isCenter = false; // 居中状态
//            boolean isRight = false; // 居右状态
//            boolean isItalic = false; // 是斜体
//            boolean isUnderline = false; // 是下划线
//            boolean isBold = false; // 加粗
//            boolean isR = false; // 在那个r中
//            int pictureIndex = 1; // docx 压缩包中的图片名 iamge1 开始 所以索引从1开始
//            while (evtType != XmlPullParser.END_DOCUMENT) {
//                switch (evtType) {
//                    // 开始标签
//                    case XmlPullParser.START_TAG:
//                        String tag = xmlParser.getName();
//                        System.out.println(tag);
//                        if (tag.equalsIgnoreCase(&quot;r&quot;)) {
//                        isR = true;
//                    }
//                    if (tag.equalsIgnoreCase(&quot;u&quot;)) { // 判断下划线
//                        isUnderline = true;
//                    }
//                    if (tag.equalsIgnoreCase(&quot;jc&quot;)) { // 判断对齐方式
//                        String align = xmlParser.getAttributeValue(0);
//                        if (align.equals(&quot;center&quot;)) {
//                            this.output.write(&quot;&lt;center&gt;&quot;.getBytes());
//                            isCenter = true;
//                        }
//                        if (align.equals(&quot;right&quot;)) {
//                            this.output.write(&quot;&lt;div align=\\&quot;right\\&quot;&gt;&quot;
//                            .getBytes());
//                            isRight = true;
//                        }
//                    }
//                    if (tag.equalsIgnoreCase(&quot;color&quot;)) { // 判断颜色
//                        String color = xmlParser.getAttributeValue(0);
//                        this.output.write((&quot;&lt;font color=&quot; + color + &quot;&gt;&quot;)
//                        .getBytes());
//                        isColor = true;
//                    }
//                    if (tag.equalsIgnoreCase(&quot;sz&quot;)) { // 判断大小
//                        if (isR == true) {
//                            int size = decideSize(Integer.valueOf(xmlParser
//                                    .getAttributeValue(0)));
//                            this.output.write((&quot;&lt;font size=&quot; + size + &quot;&gt;&quot;)
//                            .getBytes());
//                            isSize = true;
//                        }
//                    }
//                    // 下面是表格处理
//                    if (tag.equalsIgnoreCase(&quot;tbl&quot;)) { // 检测到tbl 表格开始
//                        this.output.write(tableBegin.getBytes());
//                        isTable = true;
//                    }
//                    if (tag.equalsIgnoreCase(&quot;tr&quot;)) { // 行
//                        this.output.write(rowBegin.getBytes());
//                    }
//                    if (tag.equalsIgnoreCase(&quot;tc&quot;)) { // 列
//                        this.output.write(colBegin.getBytes());
//                    }
//                    if (tag.equalsIgnoreCase(&quot;pic&quot;)) { // 检测到标签 pic 图片
//                        String entryName_jpeg = &quot;word/media/image&quot;
//                        + pictureIndex + &quot;.jpeg&quot;;
//                        String entryName_png = &quot;word/media/image&quot;
//                        + pictureIndex + &quot;.png&quot;;
//                        String entryName_gif = &quot;word/media/image&quot;
//                        + pictureIndex + &quot;.gif&quot;;
//                        ZipEntry sharePicture = null;
//                        InputStream pictIS = null;
//                        sharePicture = xlsxFile.getEntry(entryName_jpeg);
//                        // 一下为读取docx的图片 转化为流数组
//                        if (sharePicture == null) {
//                            sharePicture = xlsxFile.getEntry(entryName_png);
//                        }
//                        if(sharePicture == null){
//                            sharePicture = xlsxFile.getEntry(entryName_gif);
//                        }
//                        pictIS = xlsxFile.getInputStream(sharePicture);
//                        ByteArrayOutputStream pOut = new ByteArrayOutputStream();
//                        byte[] bt = null;
//                        byte[] b = new byte[1000];
//                        int len = 0;
//                        while ((len = pictIS.read(b)) != -1) {
//                            pOut.write(b, 0, len);
//                        }
//                        pictIS.close();
//                        pOut.close();
//                        bt = pOut.toByteArray();
//                        Log.i(&quot;byteArray&quot;, &quot;&quot; + bt);
//                        if (pictIS != null)
//                            pictIS.close();
//                        if (pOut != null)
//                            pOut.close();
//                        writeDOCXPicture(bt);
//                        pictureIndex++; // 转换一张后 索引+1
//                    }
//                    if (tag.equalsIgnoreCase(&quot;b&quot;)) { // 检测到加粗标签
//                        isBold = true;
//                    }
//                    if (tag.equalsIgnoreCase(&quot;p&quot;)) {// 检测到 p 标签
//                        if (isTable == false) { // 如果在表格中 就无视
//                            this.output.write(tagBegin.getBytes());
//                        }
//                    }
//                    if (tag.equalsIgnoreCase(&quot;i&quot;)) { // 斜体
//                        isItalic = true;
//                    }
//                    // 检测到值 标签
//                    if (tag.equalsIgnoreCase(&quot;t&quot;)) {
//                        if (isBold == true) { // 加粗
//                            this.output.write(&quot;&lt;b&gt;&quot;.getBytes());
//                        }
//                        if (isUnderline == true) { // 检测到下划线标签,输入&lt;u&gt;
//                            this.output.write(&quot;&lt;u&gt;&quot;.getBytes());
//                        }
//                        if (isItalic == true) { // 检测到斜体标签,输入&lt;i&gt;
//                            output.write(&quot;&lt;i&gt;&quot;.getBytes());
//                        }
//                        river = xmlParser.nextText();
//                        this.output.write(river.getBytes()); // 写入数值
//                        if (isItalic == true) { // 检测到斜体标签,在输入值之后,输入&lt;/i&gt;,并且斜体状态=false
//                            this.output.write(&quot;&lt;/i&gt;&quot;.getBytes());
//                            isItalic = false;
//                        }
//                        if (isUnderline == true) {// 检测到下划线标签,在输入值之后,输入&lt;/u&gt;,并且下划线状态=false
//                            this.output.write(&quot;&lt;/u&gt;&quot;.getBytes());
//                            isUnderline = false;
//                        }
//                        if (isBold == true) { // 加粗
//                            this.output.write(&quot;&lt;/b&gt;&quot;.getBytes());
//                            isBold = false;
//                        }
//                        if (isSize == true) { // 检测到大小设置,输入结束标签
//                            this.output.write(&quot;&lt;/font&gt;&quot;.getBytes());
//                            isSize = false;
//                        }
//                        if (isColor == true) { // 检测到颜色设置存在,输入结束标签
//                            this.output.write(&quot;&lt;/font&gt;&quot;.getBytes());
//                            isColor = false;
//                        }
//                        if (isCenter == true) { // 检测到居中,输入结束标签
//                            this.output.write(&quot;&lt;/center&gt;&quot;.getBytes());
//                            isCenter = false;
//                        }
//                        if (isRight == true) { // 居右不能使用&lt;right&gt;&lt;/right&gt;,使用div可能会有状况,先用着
//                            this.output.write(&quot;&lt;/div&gt;&quot;.getBytes());
//                            isRight = false;
//                        }
//                    }
//                    break;
//                    // 结束标签
//                    case XmlPullParser.END_TAG:
//                        String tag2 = xmlParser.getName();
//                        if (tag2.equalsIgnoreCase(&quot;tbl&quot;)) { // 检测到表格结束,更改表格状态
//                        this.output.write(tableEnd.getBytes());
//                        isTable = false;
//                    }
//                    if (tag2.equalsIgnoreCase(&quot;tr&quot;)) { // 行结束
//                        this.output.write(rowEnd.getBytes());
//                    }
//                    if (tag2.equalsIgnoreCase(&quot;tc&quot;)) { // 列结束
//                        this.output.write(colEnd.getBytes());
//                    }
//                    if (tag2.equalsIgnoreCase(&quot;p&quot;)) { // p结束,如果在表格中就无视
//                        if (isTable == false) {
//                            this.output.write(tagEnd.getBytes());
//                        }
//                    }
//                    if (tag2.equalsIgnoreCase(&quot;r&quot;)) {
//                        isR = false;
//                    }
//                    break;
//                    default:
//                        break;
//                }
//                evtType = xmlParser.next();
//            }
//            this.output.write(end.getBytes());
//        } catch (ZipException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (XmlPullParserException e) {
//            e.printStackTrace();
//        }
//        if (river == null) {
//            river = &quot;解析文件出现问题&quot;;
//        }
//    }

}
