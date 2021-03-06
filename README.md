# TF-IDF
![demo](https://github.com/Alex-CHUN-YU/TFIDF/blob/master/image/demo.png)</br></br>
TF-IDF 是資訊檢索(Information Retrieval)與文字挖掘(Text Mining)的常用加權技術，這裡透過/src/main/resources/TestFile.txt 台哥大73個句子(每句話 CKIP 斷詞後的結果為 term )，來進行計算 TF-IDF 之運用。</br>
* 計算 term 之重要程度(權重)
* 去掉停用詞(不重要的 term )
* 提取文章摘要(topic...)
* 表達文件的向量是 Bag of Word 的進階板(1.不會被不重要的 term 主導 2.不會完全只取決文件長度而導致 term 高太多分數)

## 使用方式
Input:</br>
```
1.執行 Main.java 可更改 testString 的字串(EX:如何)
```
Output:</br>
```
測試的Term:如何
TF-IDF = 0.03895987786198207
TF = 0.05299860529986053
IDF = 0.7351113796589775
```

## 開發環境
Maven Project</br>
Eclipse Version: Neon.2 Release (4.6.2)</br>
JDK: java version "1.8.0_121"</br>
註: Eclipse 編碼如有問題請參照:</br>
File -> Properties > Resource >> Text file encoding >> UTF-8</br>
Windows -> Preferences >> General >> Workspace >> Text file encoding >> MS950 ... 
