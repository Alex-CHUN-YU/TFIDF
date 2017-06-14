# TF-IDF
TF-IDF是資訊檢索(Information Retrieval)與文字挖掘(Text Mining)的常用加權技術，這裡透過/src/main/resources/TestFile.txt 台哥大73個句子(每句話CKIP斷詞後的結果為term)，來進行計算TF-IDF之運用。</br>
WiKi可看到TF-IDF原理(https://github.com/Alex-CHUN-YU/TF-IDF/wiki)

* 計算term之重要程度(權重)
* 去掉停用詞(不重要的term)
* 提取文章摘要(topic...)
* 表達文件的向量與BOW很像

## 使用方式
Input:</br>
1. TFIDF.java 裡的 Main Function 中的 testString 變數(Ex:如何)來進行測試</br>

Output:</br>
如何:</br>
TF-IDF = 0.03895987786198207</br>
TF = 0.05299860529986053</br>
IDF = 0.7351113796589775</br>

## 開發環境
Maven Project</br>
Eclipse Version: Neon.2 Release (4.6.2)</br>
JDK: java version "1.8.0_121"</br>
註: Eclipse 編碼如有問題請參照:</br>
File -> Properties > Resource >> Text file encoding >> UTF-8</br>
Windows -> Preferences >> General >> Workspace >> Text file encoding >> MS950 ... 
