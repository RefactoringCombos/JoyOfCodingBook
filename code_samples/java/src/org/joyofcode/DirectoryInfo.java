package org.joyofcode;

import java.io.File;

public class DirectoryInfo
{
  private String base;
  private String language;
  private String output;
  public DirectoryInfo(String base, String language, String output)
  {
    this.base = base;
    this.language = language;
    this.output = output;
  }
  public File getOutputDirectory()
  {
    return new File(String.format("%s/%s", base, getName()));
  }
  private String getName()
  {
    return String.format(output, language);
  }
  public File getInputDirectory()
  {
    return new File(String.format("%s/book", base));
  }
  public String getLanguage()
  {
    return language;
  }
  public File getCodeDirectory()
  {
    return new File(String.format("%s/code_samples/%s", base, language));
  }
  public String getFileExtension()
  {
    return ".java";
  }
}
