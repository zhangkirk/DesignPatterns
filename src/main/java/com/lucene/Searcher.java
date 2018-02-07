package com.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

/**
 *
 * 可以研究下elasticsearch
 * Created by Administrator on 2018/1/9.
 */
public class Searcher {
    public static void main(String[] args) throws IOException, ParseException {
        String indexDir = "E://Lucene//test1";
        search(indexDir);

    }

    public static void search(String indexDir) throws IOException, ParseException {
        Directory directory = FSDirectory.open(new File(indexDir).toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        // 创建一个查询对象
//        TermQuery query = new TermQuery(new Term("content","SRC_ACCTRANS_TRANS_LOG"));


//        TermQuery query = new TermQuery(new Term("name","load_src_acctrans_trans_log"));
        String queryStr = "SRC_ACCOUNT_TITLE";
//        FuzzyQuery 模糊查询  TermQuery 完全匹配  QueryParser 多域查询
//        BooleanQuery 组合查询

        QueryParser parser = new QueryParser("content",new StandardAnalyzer());
        parser.setDefaultOperator(QueryParser.AND_OPERATOR);
        Query query = parser.parse(queryStr);


        // 执行查询
        // 返回的最大值，在分页的时候使用
        TopDocs topDocs = indexSearcher.search(query, 20);
        // 取查询结果总数量
        System.out.println("总共的查询结果：" + topDocs.totalHits);
        System.out.println("");
        // 查询结果，就是documentID列表
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取对象document的对象id
            int docID = scoreDoc.doc;

            // 相关度得分
            float score = scoreDoc.score;

            // 根据ID去document对象
            Document document = indexSearcher.doc(docID);


            System.out.println("文件名：" + document.get("name"));
            // 另外的一种使用方法
//            System.out.println(document.getField("content").stringValue());
            System.out.println("路径：" + document.get("path"));
            System.out.println("相关度得分：" + score);
            System.out.println("=======================");
        }

        indexReader.close();
    }
}

