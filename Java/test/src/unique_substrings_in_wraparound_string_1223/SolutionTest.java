package test.src.unique_substrings_in_wraparound_string_1223; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.unique_substrings_in_wraparound_string_1223.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 22, 2020</pre> 
* @version 1.0 
*/ 
public class SolutionTest { 

private Solution solution;

@Before
public void before() throws Exception {
solution = new Solution(); 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findSubstringInWraproundString(String p) 
* 
*/ 
@Test
public void testFindSubstringInWraproundString() throws Exception { 
    TestCase.assertEquals(9, solution.findSubstringInWraproundString("abcbcd"));
    TestCase.assertEquals(1, solution.findSubstringInWraproundString("a"));
    TestCase.assertEquals(2, solution.findSubstringInWraproundString("cac"));
    TestCase.assertEquals(6, solution.findSubstringInWraproundString("zab"));
    TestCase.assertEquals(0, solution.findSubstringInWraproundString(""));
    TestCase.assertEquals(52, solution.findSubstringInWraproundString("jlncrvunidknqavxvifplitlzjbgjhpuakttqswopeusjvfdnvpqowivqtthkqrnvvsqgeksmqkoovfeqghpvfshyiqjunpnyhsfzqwugaqtebhujvutymdxbuojswbtjjrpjfdxrfwcxgfrxufmsmguotwbxqdfmguiauqbwkqftgljqwofrpcnfumagulzacoatznnwckiprvrngsamjzcncygoiggzzrlrkpnrdwhyicbzgxwzmqtgzliggyiwhczvyelgkkalkroexbgxkcxhliuxlcbnbwdwuxwojcqyukirtkjxqolwsrirbgklnlqiscfoecbvbmvumxzwdnydonjmhggevxklinglgdfcxhnyjwmavusvphkjlcihrpvdxrmpufwrreorsfevrorjwgdyqohprfxgyachdfsagzgdzhpimvvcudxcnhalibjvsqlgzwbbpecyfaimnjxofbzecmfriyhvhegrpfmrkhxcmafzbewmlrkjhwtfjmqewajuyhjjutxbaaonzjmxpqxpjohandyrreucvifmspjvevxfytxzlaelkczlvnjydqodascuggfymqgftlkoetdbeljsmnavalkfmslppbrteylbvohmrursugogdhtizvsympjhudghhxadxkpkeudczrpvgiihjpquqspkzuzvgtushaktibibgttzpjvweyhlrdpwzmjubhyuhgtpeaspfuzkowsqvxetatjyncqkaidvfntwtyosotcafaflsjecgnahohtbbypeobgwamaddwvqdfczinsslpvkkjqxlffocblvckyokgaxqllfjaskbiqqnyixhjewxrqzrzkxitkdyloxfocmtvewzyjlboqzebejxxrwvyvdfbotoqaxaojykoypngljlzecstcnrevfzmtzhjzeovflsabpztqcjqyroxihbjwokhnlhwokusvfnvyjoieqiliqejdrqvbrkdxspbyzyumwrwoeyphivsujbcltlxpasbceodpwqlvarfrdugeidtmxaqhtmalujuvpyzjfkxbczjovdvvgrlxuddnrvahwitijsyfbfgddirqmflhlqbwmslkdcabtxtrkewsrdwrtqlvhhnrmloermfjymdbcysruyexginljahukokoqjizwfvqibfvomhbnlglwqbfqkdhnstzmdmmldxgdtbltxjvmgyvuurkjkiwmrovxitdwdsgmkycrlwzdguzqtzhagtkjcwvokstkujcavkxupgmglnzbnscazrugxlwovhaydiogixlrpmwnvjacvjxynqnpsdioqifaqgjkhtqpbwuykcqripibeupausqazfmshghpzhcbiyjkkuywrqnavobkxcnwssgsuyaoogekthahinpnomlambjtotxffkssgtqjnioloqqmiurlwzvbrmwsyiuisnbsrynduzwcjchbrtwomvanppljvrhcbutjhjsqdwlffeiqznzbohekvhfhdeqxffnrycezqrenyeqwqpgtschbilwsgormxamtmkjohkliwlmciyrrcpbvteljwkhqiomljyormrrtpuclknklywmebbtpjobzpqbmpitvrugwjxnizlfcnnsciveoldmwxyhtvsmngdorkblrcwxmwkaazijoaxstutrtnrnwx"));
    TestCase.assertEquals(16, solution.findSubstringInWraproundString("abbccdedeeffgza"));
    // a b c d e f g ab bc cd de ef fg cde z za
}

} 
