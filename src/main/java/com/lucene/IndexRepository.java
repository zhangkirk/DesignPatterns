package com.lucene;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


/**
 * Created by Administrator on 2017/7/20.
 */
public class IndexRepository {
    public static void main(String[] args) throws IOException {
        // 指定索引库的存放路径，需要在系统中首先进行索引库的创建
        // 指定索引库存放路径
        File indexrepository_file = new File("E://index");
        Path path = indexrepository_file.toPath();
        Directory directory = FSDirectory.open(path);
        // 读取原始文档内容
        File files = new File("E://docindex");
        // 创建一个分析器对象
        // 使用标准分析器
        Analyzer analyzer = new StandardAnalyzer();
        // 创建一个IndexwriterConfig对象
        // 分析器
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        // 创建一个IndexWriter对象，对于索引库进行写操作
        IndexWriter indexWriter = new IndexWriter(directory, config);
        // 遍历一个文件
        for (File f : files.listFiles()) {
            // 文件名
            String fileName = f.getName();
            // 文件内容
            @SuppressWarnings("deprecation")
            String fileContent = FileUtils.readFileToString(f);
            // 文件路径
            String filePath = f.getPath();
            // 文件大小
            long fileSize = FileUtils.sizeOf(f);

            // 创建一个Document对象
            Document document = new Document();
            // 向Document对象中添加域信息
            // 参数：1、域的名称；2、域的值；3、是否存储；
            Field nameField = new TextField("name", fileName, Store.YES);
            Field contentField = new TextField("content", fileContent , Store.YES);
            // storedFiled默认存储
            Field pathField = new StoredField("path", filePath);
            Field sizeField = new StoredField("size", fileSize);
            // 将域添加到document对象中
            document.add(nameField);
            document.add(contentField);
            document.add(pathField);
            document.add(sizeField);
            // 将信息写入到索引库中
            indexWriter.addDocument(document);

        }

        // 关闭indexWriter
        indexWriter.close();
    }
}
