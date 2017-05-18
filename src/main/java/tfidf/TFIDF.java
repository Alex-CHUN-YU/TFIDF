package tfidf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import tfidf.POS.Tuple;

/**
 *
 * TFIDF TEST: 由於TestFile.txt裡面總共73句(每一句視為doc計算IDF)(整個文件視為一個doc計算TF).
 *
 * @version 1.0 2017年5月18日
 * @author ALEX-CHUN-YU
 *
 */
public class TFIDF {

    /**
     * CKIP斷詞.
     */
    private static ArrayList<Tuple<String, String>> pos = new ArrayList<Tuple<String, String>>();

    /**
     * Corpus(這個Corpus有73份文件).
     */
    private static ArrayList<ArrayList<String>> documentList = new ArrayList<ArrayList<String>>();

    /**
     * Doc Of Corpus.
     */
    private static ArrayList<String> doc = new ArrayList<String>();

    /**
     * Test Document(整個文件視為一個doc計算TF，也就是這個Corpus只有一個文件).
     */
    private static ArrayList<String> demoDocument = new ArrayList<String>();

    /**
     * @param tfDemoDocument  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
    public double tf(final ArrayList<String> tfDemoDocument, final String term) {
        double result = 0;
        for (String word : tfDemoDocument) {
            if (term.equalsIgnoreCase(word)) {
                result++;
            }
        }
        return result / tfDemoDocument.size();
    }

    /**
     * @param corpus list of list of strings represents the DataSet
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
    public double idf(final ArrayList<ArrayList<String>> corpus, final String term) {
        double count = 0;
        for (ArrayList<String> idfdoc : corpus) {
            for (String word : idfdoc) {
                if (term.equalsIgnoreCase(word)) {
                    count++;
                    break;
                }
            }
        }
        return Math.log(corpus.size() / count);
    }

    /**
     * @param tfidfdoc  a text document
     * @param corpus corpus
     * @param term term
     * @return the TF-IDF of term
     */
    public double tfIdf(final ArrayList<String> tfidfdoc, final ArrayList<ArrayList<String>> corpus,
            final String term) {
        return tf(tfidfdoc, term) * idf(corpus, term);
    }

    /**
     *
     * @param args argument
     * @throws IOException IOException
     */
    public static void main(final String[] args) throws IOException {
        POS ws = new POS();
        File file = new File(".");
        String path = file.getCanonicalPath();
        // Set File Name
        String fileSeparator = System.getProperty("file.separator");
        String fileName = path + fileSeparator + "src//main//resources//TestFile.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
        BufferedReader read = new BufferedReader(isr);
        String str;
        while ((str = read.readLine()) != null) {
            //將每句話當成Doc
            doc = new ArrayList<String>();
            //斷詞後結果
            pos = ws.seg(str);
            //將Doc斷詞後的結果加上去
            for (int i = 0; i < pos.size(); i++) {
                doc.add(pos.get(i).getWord());
            }
            //將全部的doc視為一個corpus
            documentList.add(doc);
            //將TestFile.txt視為一個doc，主要計算TF用的
            demoDocument.addAll(doc);
        }
        TFIDF calculator = new TFIDF();
        System.out.println("測試的Term:如何");
        System.out.println("TF-IDF = " + calculator.tfIdf(demoDocument, documentList, "如何"));
        System.out.println("TF = " + calculator.tf(demoDocument, "如何"));
        System.out.println("IDF = " + calculator.idf(documentList, "如何"));
        // Close Reader
        isr.close();
        read.close();
    }
}