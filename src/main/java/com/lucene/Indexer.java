package com.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexFileNames;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangke on 2018/1/9.
 */
public class Indexer {

    private  static final String dataDir = "D:\\soft\\elk\\data-integration-yjf-trunk\\repository";

    private  static final  String indexDir = "D:\\soft\\elk\\data-integration-yjf-trunk-lucene\\20180223";

    private IndexWriter writer;

    public static void main(String[] args) throws Exception {


        Long start = System.currentTimeMillis();
        Indexer indexer = new Indexer(indexDir);

        int numIndexed;
        try {
             numIndexed = indexer.index(dataDir, new TextFilesFilter());
        }finally {
            indexer.close();
        }
        long end = System.currentTimeMillis();

        System.out.println("搜索到" + numIndexed + "文件夹共花费 " + (end - start) + "毫秒");


    }


    public void close() throws IOException{
        writer.close();
    }

    public Indexer(String indexDir) throws IOException{
        Directory directory = FSDirectory.open(new File(indexDir).toPath());
        Analyzer  analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        writer = new IndexWriter(directory, config);
    }

    public int index(String dataDir,FileFilter fileFilter) throws Exception{
        List<String> list= new ArrayList<>();
        FileReader.ergdoic(new File(dataDir), list);
        for (String fileStr : list) {
            File file = new File(fileStr);
            if(!file.isDirectory() && !file.isHidden() && file.exists() && file.canRead()
                    && ( fileFilter == null || fileFilter.accept(file))){
                IndexFile(file);
            }
        }
        return  writer.numDocs();
    }

    private void IndexFile(File f) throws  Exception{
        Document document = getDocument(f);
        writer.addDocument(document);
    }

    private Document getDocument(File f) throws  Exception{
        Document document = new Document();
        String fileName = f.getName();
        String fileContent = FileUtils.readFileToString(f);
        // 文件路径
        String filePath = f.getPath();
        // 文件大小
        long fileSize = FileUtils.sizeOf(f);

        // 创建一个Document对象

        // 向Document对象中添加域信息
        // 参数：1、域的名称；2、域的值；3、是否存储；
        Field nameField = new TextField("name", fileName, Field.Store.YES);
        Field contentField = new TextField("content", fileContent , Field.Store.YES);
        // storedFiled默认存储
        Field pathField = new StoredField("path", filePath);
        Field sizeField = new StoredField("size", fileSize);
        // 将域添加到document对象中
        document.add(nameField);
        document.add(contentField);
        document.add(pathField);
        document.add(sizeField);
        return  document;
    }

    private static class TextFilesFilter implements  FileFilter{

        @Override
        public boolean accept(File pathname) {
            if(pathname.getName().toLowerCase().endsWith(".ktr") || pathname.getName().toLowerCase().endsWith(".kjb")){
                return Boolean.TRUE;
            }else{
                return Boolean.FALSE;
            }
        }
    }
}
