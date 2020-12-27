package ru.stqa.software_testing.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("06e74abe16117158f113f90d8a68d4de9b795b72");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("Kirill-Prokhorov", "software_testing")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){

      System.out.println(new RepoCommit.Smart(commit).message());

    }
  }
}
