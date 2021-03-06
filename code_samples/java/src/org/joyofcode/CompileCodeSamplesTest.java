package org.joyofcode;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.macosx.DiffMergeReporter;
import org.junit.Test;

import com.spun.util.io.FileUtils;

@UseReporter(DiffMergeReporter.class)
public class CompileCodeSamplesTest
{
  @Test
  public void test() throws Throwable
  {
    String base = "/Users/llewellyn/Github/JoyOfCodingBook";
    String[] languages = {"java", "cpp", "python", "javascript", "csharp"};
    CompileCodeSamples.now(base, languages, "joy_of_code.%s");
  }
  @Test
  public void testRegexForCodeBlock() throws Exception
  {
    String text = "# Introduce Lambda\n" + "\n" + "\n" + "     <codeblock Introduce.Lambda.Example.1 />\n"
        + "  <codeblock Introduce.Lambda.Example.2 />\n" + "  <codeblock Introduce.Lambda.Example.3 />\n" + "";
    Approvals.verify(CompileCodeSamples.swapCodeBlocks(text, t -> "found: " + t.group(1)));
  }
  @Test
  public void testRegexForCodetags() throws Exception
  {
    String text = FileUtils.readFile("src/org/joyofcode/samples/tests/TestLambda.java");
    Approvals.verify(CompileCodeSamples.findTagsInCodeFile(text));
  }
  @Test
  public void testIndentation() throws Exception
  {
    String text = "                //Original\n" + "                int eat = cake - (1 / 2) * cake;\n"
        + "                    // more indented 4";
    Approvals.verify(CompileCodeSamples.cleanIndentation(text));
  }
}
