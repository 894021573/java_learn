package cn.demo;
import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.UUID;

public class TestParticiple
{
    /**
     * 依赖包
     *       ansj_seg-5.1.6.jar
     *       nlp-lang-1.7.7.jar
     *  文档 http://nlpchina.github.io/ansj_seg/
     * @param args
     */
    public static void main(String[] args)
    {
        Result parse = ToAnalysis.parse("夏季color短袖衬衫");
        System.out.println(parse.toStringWithOutNature("|"));
    }
}
