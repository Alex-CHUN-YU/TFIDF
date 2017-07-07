package tfidf;

import java.util.ArrayList;

import tw.cheyingwu.ckip.CKIP;
import tw.cheyingwu.ckip.Term;

/**
 *
 * CKIP Part Of Speech.
 *
 * @version 1.0 2017/05/24
 * @author NCKU WMMKS LAB
 *
 */
public class POS {

    /**
     * CKIP User Connection.
     */
    private CKIP connection;

    /**
     * CKIP ServerIP.
     */
    private static String serverIP = "140.109.19.104";

    /**
     * CKIP ServerPort.
     */
    private static String serverPort = "1501";

    /**
     * CKIP UserName.
     */
    private static String userName = "ncku4alex@gmail.com"; // "kenmonmouth";

    /**
     * CKIP User Password.
     */
    private static String password = "ncku4alex"; // "6cd25e45";

    /**
     * CKIP Connect.
     */
    public POS() {
        connect(serverIP, Integer.parseInt(serverPort), userName, password);
    }

    /**
     * CKIP Connect.
     * @param serverIPTemp CKIP serverIP
     * @param serverPortTemp CKIP serverPort
     * @param userNameTemp CKIP userName
     * @param passwordTemp User Password
     */
    private void connect(final String serverIPTemp, final int serverPortTemp,
            final String userNameTemp, final String passwordTemp) {
        connection = new CKIP(serverIPTemp, serverPortTemp, userNameTemp, passwordTemp);
    }

    /**
     * CKIP Connect.
     * @param sentence Segment
     * @return object
     */
    public ArrayList<Tuple<String, String>> seg(final String sentence) {
        ArrayList<Tuple<String, String>> wsResult = new ArrayList<Tuple<String, String>>();
        connection.setRawText(sentence);
        connection.send();
        for (Term t : connection.getTerm()) {
            Tuple<String, String> pair = new Tuple<String, String>(t.getTerm(), t.getTag());
            wsResult.add(pair);
        }
        return wsResult;
    }

    /**
     *
     * Tuple Format.
     *
     * @param <X> declare X
     * @param <Y> declare Y
     *
     */
    public static class Tuple<X, Y> {

        /**
         * X SegmentWord.
         */
        private X getWord;

        /**
         * Y SegmentPos.
         */
        private Y getPos;

        /**
         * Get x Segment.
         * @return word
         */
        public X getWord() {
            return getWord;
        }

        /**
         * Get y Segment.
         * @return POS
         */
        public Y getPos() {
            return getPos;
        }

        /**
         * SegmentPOS.
         * @param x is X declare
         * @param y is Y declare
         */
        public Tuple(final X x, final Y y) {
            this.getWord = x;
            this.getPos = y;
        }
    }

}
