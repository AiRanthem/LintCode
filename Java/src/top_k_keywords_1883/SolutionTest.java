package src.top_k_keywords_1883;

import org.junit.Test;
import utils.TestUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void topkKeywords() {
        Solution solution = new Solution();
        List<String> strings = solution.TopkKeywords(
                2, TestUtil.buildArray("anacell", "cetracular", "betacellular"),
                TestUtil.buildArray("Anacell provides the best services in the city.",
                        "betacellular has awesome services",
                        "Best services provided by anacell, everyone should use anacell"));
        TestUtil.assertListEquals(Arrays.asList("anacell", "betacellular"), strings);
    }

    @Test
    public void topkKeywords2() {
        Solution solution = new Solution();
        List<String> strings = solution.TopkKeywords(
                2, TestUtil.buildArray("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"),
                TestUtil.buildArray("I love anacell Best services; Best services provided by anacell",
                        "betacellular has great services",
                        "deltacellular provides much better services than betacellular",
                        "cetracular is worse than anacell",
                        "Betacellular is better than deltacellular."));
        TestUtil.assertListEquals(Arrays.asList("betacellular", "anacell"), strings);
    }

    @Test
    public void topkKeywords4() {
        Solution solution = new Solution();
        List<String> strings = solution.TopkKeywords(
                12, TestUtil.buildArray("qebqhd", "mferd", "glhc", "axos", "hxxsx", "xvtj", "dajth", "slokx"),
                TestUtil.buildArray(
                        "YlCtq uFC Dajth hxxsx WUgjg dajth qlOi VqVQQN Slokx Axos COLKc ESXLTt",
                        "SJhv KonM PDkiEc ZKoQIt slokx AlmbD xvtj HhOGAc cYXC JCFYo Glhc",
                        "qebqhd viy xvtj NTnL FMT axos UZx dajth HKa Qebqhd",
                        "JsrgPD qGGD byBTA jJMV axos vtL MNE axos qWkYI jsj qebqhd Slokx axos ucD",
                        "vhQjyf qfoAM bZY FxgnF axos Bojq Axos lbmH HsxboA NBpig MOlKR zml dajth KFYw Xvtj Dajth xvtj rTZVYU JMgBfc",
                        "RtojO Xvtj BQbtL LDYaM Glhc",
                        "glhc Zltfa hxxsx xrDTd Htg TrJ Glhc Xvtj hxxsx UUImeD Hxxsx pRLw",
                        "BSKIM slokx ety Qebqhd LkgiA UEo oxwBc NpjO ELruV fETjzs KIeSH dMRZq slokx bjwL",
                        "mferd aAbncH bic tqEk Mferd",
                        "vlku Glhc slokx dDO Xvtj QlCEOd"));
        TestUtil.assertListEquals(Arrays.asList("xvtj", "slokx", "axos", "glhc", "dajth", "qebqhd", "hxxsx", "mferd"),
                strings);
    }

    @Test
    public void errorTest() throws Exception {
        Solution solution = new Solution();
        File in = new File("src/top_k_keywords_1883/testdatav2_1883_data_18.in");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(in));
        BufferedReader bufferedReader = new BufferedReader(reader);

        List<String> ans = solution.TopkKeywords(
                Integer.parseInt(bufferedReader.readLine()),
                TestUtil.parsePythonStyleStringArray(bufferedReader.readLine()),
                TestUtil.parsePythonStyleStringArray(bufferedReader.readLine())
        );

        TestUtil.assertListEquals(Arrays.asList("ozyno", "itafp", "ojqzs", "nalm", "hswp", "pgfs", "detw", "nmnz",
                "vapu", "bki", "jjjo", "sjelgs", "uriyns", "wme", "zxr", "czso", "gwqc", "ywt", "zefmp", "arg", "coee",
                "kinf", "xmnf", "nypgqx", "bnl", "rmx", "swslmv", "ydfpep", "yrmsie", "zdw", "kcjez", "nbzlgf"), ans);
    }

    @Test
    public void errorTest2() throws Exception {
        Solution solution = new Solution();
        File in = new File("src/top_k_keywords_1883/testdatav2_1883_data_21.in");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(in));
        BufferedReader bufferedReader = new BufferedReader(reader);

        List<String> ans = solution.TopkKeywords(
                Integer.parseInt(bufferedReader.readLine()),
                TestUtil.parsePythonStyleStringArray(bufferedReader.readLine()),
                TestUtil.parsePythonStyleStringArray(bufferedReader.readLine())
        );

        TestUtil.assertListEquals(Arrays.asList("fot","vix","hvcx","ihco","kqrtl","fep","jhek","wfgp","ocgd","vyk",
                "ogveag","tvhpp","xocuw","cixfjc","elnphj","fezdxo","qfj","ulf","zreq","cmkqd","lhow","uil","hni",
                "ppzi","uhn","svlh","xof","ybno","ywmqsf","ywn","xkpwv","aivve","akupjl","bhtnn","fxjrdw","jqvejm",
                "xtgfzc","ynsxvx","ayfpw","bkdd","jygu","vrca","ablgq","ipxfp","jaht","mzmy","nwl","ukbrz","ybj",
                "gwjunx","vcmotd","xbthqa","aemmph","gmzpge","iqhsk","mlvr","pgmdj","vkt","wnqzg","wliu","zqunfs",
                "awnm","cpjjv","cwhnrd"), ans);
    }

    @Test
    public void testNext() {
        Solution solution = new Solution();
        int[] next = solution.cacuKmpNext("abcabdddabcabc");
        assertArrayEquals(TestUtil.buildIntArray(0, 0, 0, 1, 2, 0, 0, 0, 1, 2, 3, 4, 5, 3), next);
    }

}