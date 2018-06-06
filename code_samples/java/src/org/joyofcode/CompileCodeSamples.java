package org.joyofcode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.lambda.functions.Function1;

import com.spun.util.StringUtils;
import com.spun.util.io.FileUtils;

public class CompileCodeSamples
{
  public static void now(String base, String[] languages, String output) throws IOException
  {
    for (String language : languages)
    {
      merge(new DirectoryInfo(base, language, output));
    }
  }
  private static void merge(DirectoryInfo info) throws IOException
  {
    clean(info);
    File[] fileList = FileUtils.getRecursiveFileList(info.getInputDirectory());
    for (File file : fileList)
    {
      copy(file, info);
    }
  }
  private static void clean(DirectoryInfo info) throws IOException
  {
    File output = info.getOutputDirectory();
    if (output.exists())
    {
      FileUtils.deleteDirectory(output);
    }
    output.mkdir();
  }
  private static void copy(File file, DirectoryInfo info)
  {
    String to = info.getOutputDirectory()
        + file.getAbsolutePath().substring(info.getInputDirectory().getAbsolutePath().length());
    //SimpleLogger.event("Copying " + to);
    FileUtils.writeFile(new File(to), mergeTextFor(file, info));
  }
  private static String mergeTextFor(File file, DirectoryInfo info)
  {
    String text = FileUtils.readFile(file);
    HashMap<String, String> codeTags = findInCode(info);
    Function1<Matcher, String> replacer = t -> formatCodeBlock(codeTags, t.group(1), info);
    text = swapCodeBlocks(text, replacer);
    return text;
  }
  private static String formatCodeBlock(HashMap<String, String> codeTags, String code, DirectoryInfo info)
  {
    return String.format("```%s\n%s\n```\n", info.getLanguage(), getCodeFor(codeTags, code));
  }
  private static String getCodeFor(HashMap<String, String> codeTags, String tag)
  {
    if (!codeTags.containsKey(tag)) { throw new RuntimeException(String.format("Could not find: ", tag)); }
    return codeTags.get(tag);
  }
  public static String swapCodeBlocks(String text, Function1<Matcher, String> replacer)
  {
    String pattern = "(?m)^\\s*<codeblock ((?:[\\w\\d.]*)) />";
    text = replaceAll(text, pattern, replacer);
    return text;
  }
  private static HashMap<String, String> findInCode(DirectoryInfo info)
  {
    File[] files = FileUtils.getRecursiveFileList(info.getCodeDirectory(),
        f -> f.getName().endsWith(info.getFileExtension()));
    HashMap<String, String> tags = new HashMap<>();
    for (File file : files)
    {
      String text = FileUtils.readFile(file);
      tags.putAll(findTagsInCodeFile(text));
    }
    return tags;
  }
  public static Map<String, String> findTagsInCodeFile(String text)
  {
    HashMap<String, String> tags = new HashMap<>();
    String pattern1 = "(\\/\\* ((?:[\\w\\d.]*)) \\*)\\/((.*?))" + "((# )?\\/\\* end \\*\\/)";
    Pattern p = Pattern.compile(pattern1, Pattern.MULTILINE | Pattern.DOTALL);
    Matcher m = p.matcher(text);
    while (m.find())
    {
      String tag = m.group(2);
      String code = m.group(3);
      tags.put(tag, cleanIndentation(cleanBlankLines(code)));
    }
    return tags;
  }
  private static String cleanBlankLines(String code)
  {
    ArrayList<String> lines = new ArrayList<>(Arrays.asList(code.split("\n")));
    while (!lines.isEmpty())
    {
      if (StringUtils.isEmpty(lines.get(0)))
      {
        lines.remove(0);
      }
      else
      {
        break;
      }
    }
    while (!lines.isEmpty())
    {
      int last = lines.size() - 1;
      if (StringUtils.isEmpty(lines.get(last)))
      {
        lines.remove(last);
      }
      else
      {
        break;
      }
    }
    return String.join("\n", lines);
  }
  public static String replaceAll(String text, String regex, Function1<Matcher, String> replacer)
  {
    Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
    Matcher matcher = pattern.matcher(text);
    StringBuffer result = new StringBuffer();
    while (matcher.find())
    {
      matcher.appendReplacement(result, replacer.call(matcher));
    }
    matcher.appendTail(result);
    return result.toString();
  }
  public static String cleanIndentation(String text)
  {
    String[] lines = text.split("\n");
    Optional<Integer> min = Stream.of(lines).map((String l) -> l.length() - l.replaceAll("^\\s+", "").length())
        .min((a, b) -> a - b);
    Stream<String> trimed = Stream.of(lines).map((String l) -> l.substring(min.orElse(0)));
    return trimed.collect(Collectors.joining("\n"));
  }
}
