package tfidf;

import java.io.IOException;

/**
 * Created by alex on 2017/7/7.
 */
public class Main {

    /**
     *
     * Main Function Test TF And IDF.
     *
     * @param args argument
     * @throws IOException IOException
     *
     */
    public static void main(final String[] args) throws IOException {
        
        System.out.println("由於受限於CKIP斷詞速率，請耐心等待...(可將其斷詞結果加入辭典中進行讀取)\n");
        TFIDF calculator = new TFIDF();
        String testString = "如何";
        System.out.println("測試的Term:" + testString);
        System.out.println("TF-IDF = " + calculator.tfIdf(testString));
        System.out.println("TF = " + calculator.tf(testString));
        System.out.println("IDF = " + calculator.idf(testString));

    }

}
